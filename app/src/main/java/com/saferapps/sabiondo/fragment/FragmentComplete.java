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
import android.os.Environment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.games.Games;
import com.google.android.material.card.MaterialCardView;
import com.saferapps.sabiondo.Constant;
import com.saferapps.sabiondo.R;
import com.saferapps.sabiondo.activity.ReviewActivity;
import com.saferapps.sabiondo.helper.CircularProgressIndicator2;
import com.saferapps.sabiondo.helper.SettingsPreferences;

import java.io.File;
import java.io.FileOutputStream;


public class FragmentComplete extends Fragment implements android.view.View.OnClickListener {
    private MaterialCardView btnPlayAgain, btnShare, btnReview;
    private TextView txt_result_title, txt_score, txtLevelTotalScore, txtLevel, txt_right, txt_wrong, point, coin_count,num_coins,equis,btn_playagaintxt;
    private CircularProgressIndicator2 result_prog;
    private SharedPreferences settings;
    private static Context mContext;
    private int levelNo = 1;
    private int lastLevelScore = 0;
    private int coin = 0;
    private int totalScore = 0;
    private LottieAnimationView coins;
    private View v;
    private FragmentPlay fragmentPlay;
    private Bitmap bitmap;
    private FragmentLock fragmentLevel;
    private File imagePath;
    protected RelativeLayout native_resit;
    private int mRequestedScore = 0;

    private int schoolgrade,level;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_complete, container, false);
        final int[] CLICKABLES = new int[]{R.id.btn_playagain, R.id.btn_share};
        for (int i : CLICKABLES) {
            v.findViewById(i).setOnClickListener(this);
        }
        v.findViewById(R.id.animation_view);
        mContext = getContext();



        btn_playagaintxt= v.findViewById(R.id.btn_playagaintxt);
        native_resit=v. findViewById(R.id.relativeLayoutcomplete);
        fragmentPlay = new FragmentPlay();
        fragmentLevel = new FragmentLock();

        result_prog =  v.findViewById(R.id.result_progress);
        result_prog.SetAttributes1();
        settings = getActivity().getSharedPreferences(SettingsPreferences.SETTING_Quiz_PREF, 0);
        txt_result_title =  v.findViewById(R.id.txt_result_title);
        txt_right =  v.findViewById(R.id.right);
        txt_wrong =  v.findViewById(R.id.wrong);
        txt_score =  v.findViewById(R.id.txtScore);
        num_coins= v.findViewById(R.id.tv_coins);
        equis= v.findViewById(R.id.tv_equis);
        coins= v.findViewById(R.id.anim_coins);
        schoolgrade= SettingsPreferences.getSchoolGrade(mContext);
        level= Constant.RequestlevelNo;



        coin = SettingsPreferences.getPoint(mContext);
        totalScore = settings.getInt(SettingsPreferences.TOTAL_SCORE, 0);
        txt_score.setText("" + totalScore);
        lastLevelScore = settings.getInt(SettingsPreferences.LAST_LEVEL_SCORE, 0);
        SettingsPreferences.setLevelScore(mContext,schoolgrade,level,Constant.CorrectQuestions);
        SettingsPreferences.setLevelPoints(mContext,schoolgrade,level,lastLevelScore);
        txtLevelTotalScore =  v.findViewById(R.id.total_score);
        point =  v.findViewById(R.id.earncoin);
        coin_count = v.findViewById(R.id.coin_count);
        coin_count.setText("" + coin);
        num_coins.setText("" + Constant.level_coin);
        txtLevelTotalScore.setText("Puntuacion Total: " + lastLevelScore);
        txtLevel =  v.findViewById(R.id.txtLevel);
        btnPlayAgain =  v.findViewById(R.id.btn_playagain);
        btnReview =  v.findViewById(R.id.btn_review);
        btnPlayAgain.setOnClickListener(this);
        btnReview.setOnClickListener(this);



        if (FragmentPlay.reviewst.size() == 0) {
            btnReview.setVisibility(View.GONE);
        }
        btnShare = v.findViewById(R.id.btn_share);
        btnShare.setOnClickListener(this);
        v.setOnKeyListener((v, keyCode, event) -> {
            if( keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP) {
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_container, fragmentLevel);
                ft.commit();
                return true;
            }
            return false;
        });

        boolean islevelcomplted = settings.getBoolean(
                SettingsPreferences.IS_LAST_LEVEL_COMPLETED, false);

        levelNo = settings.getInt(SettingsPreferences.LEVEL_COMPLETED, 0);
        txtLevel.setText("Nivel" + ": " + Constant.RequestlevelNo);


        if (islevelcomplted) {
            levelNo--;
            if (Constant.NO_OF_QUIZ_LEVEL == Constant.RequestlevelNo) {
                btn_playagaintxt.setText("Jugar Otra Vez");
                Constant.RequestlevelNo = 1;

            } else {
                txt_result_title.setText(getActivity().getString(R.string.completed));
                btn_playagaintxt.setText(getResources().getString(R.string.next_play));
                setScore(totalScore);
                Constant.RequestlevelNo = Constant.RequestlevelNo + 1;
                SettingsPreferences.setNoCompletedLevel(mContext,Constant.RequestlevelNo,SettingsPreferences.getSchoolGrade(mContext));
                LottieAnimationView animationView= v.findViewById (R.id.animation_view);
                animationView.playAnimation();
                equis.setVisibility(View.VISIBLE);
                num_coins.setVisibility(View.VISIBLE);
                coins.playAnimation();
                updateLeaderBoard();

            }
        } else {

            txt_result_title.setText(getActivity().getString(R.string.not_completed));
            btn_playagaintxt.setText(getResources().getString(R.string.play_next));
            equis.setVisibility(View.GONE);
            num_coins.setVisibility(View.GONE);
            coins.setVisibility(View.GONE);
            txtLevelTotalScore.setVisibility(View.GONE);

        }
        result_prog.setCurrentProgress(getPercentageCorrect(Constant.TotalQuestion, Constant.CorrectQuestions));
        if(SettingsPreferences.getNightMode(mContext)){
            result_prog.setTextColor(Color.WHITE);
        }else{
            result_prog.setTextColor(Color.BLACK);
        }
        txt_right.setText("" + Constant.CorrectQuestions);
        txt_wrong.setText("" + Constant.WrongQuestions);





        return v;
    }



    private void setScore(int score) {
        mRequestedScore = score;
    }

    public static float getPercentageCorrect(int questions, int correct) {
        float proportionCorrect = ((float) correct) / ((float) questions);
        return proportionCorrect * 100;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btn_playagain) {
            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.fragment_container, fragmentPlay, "fragment");
            ft.commit();
        } else if (id == R.id.btn_share) {
            print();
            shareIt();

        } else if (id == R.id.btn_review) {
            Intent intent = new Intent(getActivity(), ReviewActivity.class);
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

            String filename = "Resultado "+".jpg";
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
    private void updateLeaderBoard(){
        if(isSignedIn()){
        int lastUpdatescore= SettingsPreferences.getLastUpdateScore(mContext);
        if(lastUpdatescore<totalScore){
               Games.getLeaderboardsClient(mContext, GoogleSignIn.getLastSignedInAccount(mContext))
                       .submitScore(getString(R.string.leaderboard_sabiondos), totalScore);
               SettingsPreferences.setLastUpdateScore(mContext,totalScore);
           }

       }

    }
    private boolean isSignedIn() {
        return GoogleSignIn.getLastSignedInAccount(mContext) != null;
    }

}
