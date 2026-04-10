package com.saferapps.sabiondo.helper;

import android.os.Handler;
import android.os.Looper;

import com.saferapps.sabiondo.adapter.DBHelper;
import com.saferapps.sabiondo.model.Quizplay;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class GameLoader {

    public interface Callback {
        void onLoaded(List<Quizplay> questions);
    }

    public static void loadQuestions(DBHelper dbHelper, int total, Integer level, int grade, Callback callback) {

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler mainHandler = new Handler(Looper.getMainLooper());

        executor.execute(() -> {

            // trabajo pesado fuera del UI
            List<Quizplay> questions = dbHelper.getQuestions(total, level, grade);

            // regresar al UI thread
            mainHandler.post(() -> callback.onLoaded(questions));
        });
    }
}
