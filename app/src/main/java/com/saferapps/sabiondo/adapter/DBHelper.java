package com.saferapps.sabiondo.adapter;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;


import com.saferapps.sabiondo.model.Quizplay;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;


public class DBHelper extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "quiz_dbi.db";
    Context mContext;


    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.mContext = context;
        copyDatabaseIfNeeded();
    }

    private void copyDatabaseIfNeeded() {
        try {
            File dbFile = mContext.getDatabasePath(DB_NAME);

            if (dbFile.exists()) return;

            dbFile.getParentFile().mkdirs();

            InputStream is = mContext.getAssets().open(DB_NAME);
            OutputStream os = new FileOutputStream(dbFile);

            byte[] buffer = new byte[4096];
            int length;

            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }

            os.flush();
            os.close();
            is.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    private int getQuestionCount(SQLiteDatabase db, String where, String[] args) {
        Cursor c = db.rawQuery("SELECT COUNT(*) FROM questions_list " + where, args);
        c.moveToFirst();
        int count = c.getInt(0);
        c.close();
        return count;
    }

    public List<Quizplay> getQuestions(int total, Integer level, int grade) {

        SQLiteDatabase db = getReadableDatabase();
        List<Quizplay> quizplay = new ArrayList<>();

        String where = "WHERE school_grade=?";
        List<String> argsList = new ArrayList<>();
        argsList.add(String.valueOf(grade));

        if (level != null) {
            where += " AND level=?";
            argsList.add(String.valueOf(level));
        }

        String[] args = argsList.toArray(new String[0]);

        int count = getQuestionCount(db, where, args);
        if (count == 0) return quizplay;

        Random random = new Random();
        Set<Integer> selectedOffsets = new HashSet<>();

        while (selectedOffsets.size() < total && selectedOffsets.size() < count) {
            selectedOffsets.add(random.nextInt(count));
        }

        for (int offset : selectedOffsets) {

            Cursor cursor = db.rawQuery(
                    "SELECT question,option_a,option_b,option_c,option_d,right_answer " +
                            "FROM questions_list " + where + " LIMIT 1 OFFSET " + offset,
                    args
            );

            if (cursor.moveToFirst()) {

                Quizplay question = new Quizplay(cursor.getString(0));
                question.addOption(cursor.getString(1));
                question.addOption(cursor.getString(2));
                question.addOption(cursor.getString(3));
                question.addOption(cursor.getString(4));

                String rightAns = cursor.getString(5);

                switch (rightAns.toUpperCase()) {
                    case "A": question.setTrueAns(cursor.getString(1)); break;
                    case "B": question.setTrueAns(cursor.getString(2)); break;
                    case "C": question.setTrueAns(cursor.getString(3)); break;
                    default: question.setTrueAns(cursor.getString(4));
                }

                quizplay.add(question);
            }

            cursor.close();
        }

        db.close();
        Collections.shuffle(quizplay);
        return quizplay;
    }


}
