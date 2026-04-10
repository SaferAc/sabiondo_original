package com.saferapps.sabiondo.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.card.MaterialCardView;
import com.saferapps.sabiondo.R;
import com.saferapps.sabiondo.activity.ReviewActivity;
import com.saferapps.sabiondo.activity.ReviewActivityTime;
import com.saferapps.sabiondo.helper.SettingsPreferences;

import java.io.File;
import java.io.FileOutputStream;

public class FragmentTimeComplete extends Fragment implements android.view.View.OnClickListener {
    private MaterialCardView btnPlayAgain, btnShare, btnReview;
    private TextView txt_score, txtLevelTotalScore, coin_count,num_coins, timeRecord,btn_playagaintxt2;
    private SharedPreferences settings;
    private Context mContext;
    private int coin = 0, question_right=0, coin_win=0;
    private int totalScore = 0;
    private View v;
    private Bitmap bitmap;
    private FragmentLock fragmentLevel;
    private File imagePath;
    protected RelativeLayout native_resit;
    private int schoolgrade;
    private String timeRecordString;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_time_complete, container, false);
        final int[] CLICKABLES = new int[]{R.id.btn_playagain2, R.id.btn_share2};
        for (int i : CLICKABLES) {
            v.findViewById(i).setOnClickListener(this);
        }
        mContext= getContext();
        v.findViewById(R.id.animation_view2);
        btn_playagaintxt2= v.findViewById(R.id.btn_playagaintxt2);



        native_resit=v. findViewById(R.id.relativeLayoutcomplete2);
        fragmentLevel = new FragmentLock();
        settings = getActivity().getSharedPreferences(SettingsPreferences.SETTING_Quiz_PREF, 0);
        num_coins= v.findViewById(R.id.numcoins);
        timeRecord= v.findViewById(R.id.timerecord2);
        txtLevelTotalScore =  v.findViewById(R.id.total_question2);
        schoolgrade= SettingsPreferences.getSchoolGrade(mContext);
        timeRecordString= SettingsPreferences.getTimeRecord(mContext,schoolgrade);
        timeRecord= v.findViewById(R.id.timerecord2);
        btnPlayAgain =  v.findViewById(R.id.btn_playagain2);
        btnReview =  v.findViewById(R.id.btn_review2);
        totalScore = SettingsPreferences.getScore(mContext);
        txt_score =  v.findViewById(R.id.txtScore2);
        txt_score.setText(""+totalScore);
        coin = SettingsPreferences.getPoint(mContext);
        coin_count = v.findViewById(R.id.coin_count2);
        coin_count.setText("" + coin);
        question_right=SettingsPreferences.getQuestionRecord(mContext,schoolgrade);
        timeRecord.setText("Tiempo: "+ timeRecordString);
        txtLevelTotalScore.setText("Preguntas Correctas: " +question_right);
        btnPlayAgain.setOnClickListener(this);
        btnReview.setOnClickListener(this);
        coin_win=SettingsPreferences.getCountCoinsPlayTime(mContext);
        num_coins.setText(""+coin_win);






        if (FragmentPlayTime.reviewspt.size() == 0) {
            btnReview.setVisibility(View.GONE);
        }
        btnShare = v.findViewById(R.id.btn_share2);
        btnShare.setOnClickListener(this);
        btn_playagaintxt2.setText("Jugar Otra Vez");
        return v;
    }




    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btn_playagain2) {
            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
            getActivity().getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            ft.replace(R.id.fragment_container, fragmentLevel, "fragment");
            ft.addToBackStack("tag");
            ft.commit();
        } else if (id == R.id.btn_share2) {
            print();
            shareIt();

        } else if (id == R.id.btn_review2) {
            Intent intent = new Intent(getActivity(), ReviewActivityTime.class);
            startActivity(intent);

        }
    }
    private void print(){

        ProgressDialog dialog = new ProgressDialog(getContext());
        dialog.setMessage("Guardando...");
        dialog.show();

        Bitmap bitmap = getBitmapFromView(native_resit,native_resit.getChildAt(0).getHeight(),native_resit.getChildAt(0).getWidth());
        try {
            File defaultFile  = new File(Environment.getExternalStorageDirectory().getAbsolutePath());
            if (!defaultFile .exists())
                defaultFile .mkdirs();

            String filename = "Record"+".jpg";
            imagePath = new File(defaultFile ,filename);
            if (imagePath.exists()) {
                imagePath.delete();
                imagePath = new File(defaultFile ,filename);
            }



            FileOutputStream output = new FileOutputStream(imagePath);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, output);
            output.flush();
            output.close();

            dialog.dismiss();

            Toast.makeText(getContext(),"Guardado", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();

            Toast.makeText(getContext(),"Error", Toast.LENGTH_SHORT).show();
        }
    }
    //create bitmap from the view
    private Bitmap getBitmapFromView(View view,int height,int width) {
        bitmap = Bitmap.createBitmap(width, height,Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Drawable bgDrawable =view.getBackground();
        if (bgDrawable!=null)
            bgDrawable.draw(canvas);
        else
            canvas.drawColor(Color.WHITE);
        view.draw(canvas);
        return bitmap;
    }
    private void shareIt() {
        Uri uri = FileProvider.getUriForFile(getContext(),
                "com.saferapps.sabiondo.fileprovider",
                imagePath);
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("image/*");
        sharingIntent.putExtra(Intent.EXTRA_STREAM, uri);
        startActivity(Intent.createChooser(sharingIntent, "Compartir Via"));
    }

}
