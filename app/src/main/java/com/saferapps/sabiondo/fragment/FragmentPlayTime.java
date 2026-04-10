package com.saferapps.sabiondo.fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.card.MaterialCardView;
import com.saferapps.sabiondo.Constant;
import com.saferapps.sabiondo.R;
import com.saferapps.sabiondo.adapter.DBHelper;
import com.saferapps.sabiondo.helper.CheckNetworkConnection;

import com.saferapps.sabiondo.helper.CircularProgressIndicator2;
import com.saferapps.sabiondo.helper.SettingsPreferences;
import com.saferapps.sabiondo.helper.StopWatch;
import com.saferapps.sabiondo.model.QuizTimeLevel;
import com.saferapps.sabiondo.model.Review;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;




public class FragmentPlayTime extends Fragment implements View.OnClickListener {


    private Boolean isNewRecord=false;
    private FragmentLock fragmentLock;
    private MaterialCardView cardView_A, cardView_B, cardView_C, cardView_D;
    private LottieAnimationView fifty_fifty, skip_question,audience_poll,resettimer, correctanim;
    private View v;
    private Animation RightSwipe_A, RightSwipe_B, RightSwipe_C, RightSwipe_D, Fade_in, fifty_fifty_anim;
    private RelativeLayout layout_A, layout_B, layout_C, layout_D;
    private Context mContext;
    private SharedPreferences settings;
    private int schoolGrade;
    private static SharedPreferences.Editor editor;
    private CircularProgressIndicator2 progressBarTwo_A, progressBarTwo_B, progressBarTwo_C, progressBarTwo_D;
    private static QuizTimeLevel level;
    private int quextionIndex = 0, totalScore = 0, inCorrectQuestion = 0, correctQuestion = 0,count_question_completed = 0,score = 0, coin = 6, btnposition = 0,timeToSave=0;
    public static ArrayList<Review> reviewspt = new ArrayList<>();
    private TextView txtQuestionIndex, txtQuestion, btnOpt1, btnOpt2, btnOpt3, btnOpt4, txtScore, txtTrueQuestion, coin_count, mTvTimer,recordTime,recordQuestion;
    private Animation animation;
    private final Handler mHandler = new Handler();
    private FragmentTimeComplete fragmentTimeComplete;
    private StopWatch stopWatch;
    private DBHelper dbHelper;





    public FragmentPlayTime() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_play_time, container, false);

        final int[] CLICKABLES = new int[]{R.id.cardView_A2, R.id.cardView_B2, R.id.cardView_C2, R.id.cardView_D2};
        for (int i : CLICKABLES) {
            v.findViewById(i).setOnClickListener(this);
        }
        fragmentTimeComplete= new FragmentTimeComplete();
        fragmentLock= new FragmentLock();
        mContext = getContext();
        dbHelper= new DBHelper(mContext);
        fifty_fifty = v.findViewById(R.id.fifty_fifty2);
        mTvTimer= v.findViewById(R.id.tv_timer);
        RightSwipe_A = AnimationUtils.loadAnimation(getActivity(), R.anim.anim_right_a);
        RightSwipe_B = AnimationUtils.loadAnimation(getActivity(), R.anim.anim_right_b);
        RightSwipe_C = AnimationUtils.loadAnimation(getActivity(), R.anim.anim_right_c);
        RightSwipe_D = AnimationUtils.loadAnimation(getActivity(), R.anim.anim_right_d);
        Fade_in = AnimationUtils.loadAnimation(getActivity(), R.anim.fade_out);
        fifty_fifty_anim = AnimationUtils.loadAnimation(getActivity(), R.anim.fifty_fifty);
        settings = mContext.getSharedPreferences(SettingsPreferences.SETTING_Quiz_PREF, 0);
        schoolGrade = SettingsPreferences.getSchoolGrade(mContext);
        schoolGrade= SettingsPreferences.getSchoolGrade(mContext);
        stopWatch= new StopWatch(mTvTimer);


        



        RelativeLayout relativeLayout = v.findViewById(R.id.wave_layout2);

        AnimationDrawable animationDrawable = (AnimationDrawable) relativeLayout.getBackground();

        animationDrawable.setEnterFadeDuration(2500);
        animationDrawable.setExitFadeDuration(5000);

        animationDrawable.start();
        reviewspt.clear();
        resetAllValue();
        return v;
    }



    @Override
    public void onClick(View v) {
        if (quextionIndex < level.getNoOfQuestion()) {
            cardView_A.setClickable(false);
            cardView_B.setClickable(false);
            cardView_C.setClickable(false);
            cardView_D.setClickable(false);
            if (progressBarTwo_A.getVisibility() == (View.VISIBLE)) {
                progressBarTwo_A.setVisibility(View.GONE);
                progressBarTwo_B.setVisibility(View.GONE);
                progressBarTwo_C.setVisibility(View.GONE);
                progressBarTwo_D.setVisibility(View.GONE);
            }
            int id = v.getId();
            if (id == R.id.cardView_A2) {
                reviewspt.add(new Review(level.getQuestion().get(quextionIndex).getQuestion(),
                        level.getQuestion().get(quextionIndex).getTrueAns(),
                        btnOpt1.getText().toString(),
                        level.getQuestion().get(quextionIndex).getOptions()));


                if (btnOpt1.getText().toString().trim().equalsIgnoreCase(level.getQuestion().get(quextionIndex).getTrueAns().trim())) {
                    quextionIndex++;
                    addScore();
                    layout_A.setBackgroundResource(R.drawable.right_gradient);
                    cardView_A.startAnimation(animation);
                    layout_B.setBackgroundResource(R.drawable.bg_gradient);
                    layout_C.setBackgroundResource(R.drawable.bg_gradient);
                    layout_D.setBackgroundResource(R.drawable.bg_gradient);

                } else if (!btnOpt1.getText().toString().trim().equalsIgnoreCase(level.getQuestion().get(quextionIndex).getTrueAns().trim())) {

                    layout_A.setBackgroundResource(R.drawable.wrong_gradient);
                    wrongQuestion();
                    String trueAns = level.getQuestion().get(quextionIndex).getTrueAns().trim();
                    if (btnOpt2.getText().toString().trim().equals(trueAns)) {
                        cardView_B.startAnimation(animation);
                        layout_B.setBackgroundResource(R.drawable.right_gradient);
                        layout_C.setBackgroundResource(R.drawable.bg_gradient);
                        layout_D.setBackgroundResource(R.drawable.bg_gradient);


                    } else if (btnOpt3.getText().toString().trim().equals(trueAns)) {
                        layout_C.setBackgroundResource(R.drawable.right_gradient);
                        cardView_C.startAnimation(animation);
                        layout_B.setBackgroundResource(R.drawable.bg_gradient);
                        layout_D.setBackgroundResource(R.drawable.bg_gradient);

                    } else if (btnOpt4.getText().toString().trim().equals(trueAns)) {
                        layout_D.setBackgroundResource(R.drawable.right_gradient);
                        cardView_D.startAnimation(animation);
                        layout_B.setBackgroundResource(R.drawable.bg_gradient);
                        layout_C.setBackgroundResource(R.drawable.bg_gradient);
                    }


                    quextionIndex++;
                }

            } else if (id == R.id.cardView_B2) {
                reviewspt.add(new Review(level.getQuestion().get(quextionIndex).getQuestion(),
                        level.getQuestion().get(quextionIndex).getTrueAns(),
                        btnOpt2.getText().toString(),
                        level.getQuestion().get(quextionIndex).getOptions()));
                if (btnOpt2.getText().toString().trim().equalsIgnoreCase(level.getQuestion().get(quextionIndex).getTrueAns().trim())) {
                    quextionIndex++;
                    addScore();
                    layout_B.setBackgroundResource(R.drawable.right_gradient);
                    cardView_B.startAnimation(animation);
                    layout_A.setBackgroundResource(R.drawable.bg_gradient);
                    layout_C.setBackgroundResource(R.drawable.bg_gradient);
                    layout_D.setBackgroundResource(R.drawable.bg_gradient);

                } else if (!btnOpt2.getText().toString().trim().equalsIgnoreCase(level.getQuestion().get(quextionIndex).getTrueAns().trim())) {

                    String trueAns = level.getQuestion().get(quextionIndex).getTrueAns().trim();
                    layout_B.setBackgroundResource(R.drawable.wrong_gradient);
                    wrongQuestion();

                    if (btnOpt1.getText().toString().trim().equals(trueAns)) {
                        cardView_A.startAnimation(animation);
                        layout_A.setBackgroundResource(R.drawable.right_gradient);
                        layout_C.setBackgroundResource(R.drawable.bg_gradient);
                        layout_D.setBackgroundResource(R.drawable.bg_gradient);

                    } else if (btnOpt3.getText().toString().trim().equals(trueAns)) {
                        layout_C.setBackgroundResource(R.drawable.right_gradient);
                        cardView_C.startAnimation(animation);
                        layout_A.setBackgroundResource(R.drawable.bg_gradient);
                        layout_D.setBackgroundResource(R.drawable.bg_gradient);

                    } else if (btnOpt4.getText().toString().trim().equals(trueAns)) {
                        layout_D.setBackgroundResource(R.drawable.right_gradient);
                        cardView_D.startAnimation(animation);
                        layout_A.setBackgroundResource(R.drawable.bg_gradient);
                        layout_C.setBackgroundResource(R.drawable.bg_gradient);
                    }

                    quextionIndex++;
                }

            } else if (id == R.id.cardView_C2) {
                reviewspt.add(new Review(level.getQuestion().get(quextionIndex).getQuestion(),
                        level.getQuestion().get(quextionIndex).getTrueAns(),
                        btnOpt3.getText().toString(),
                        level.getQuestion().get(quextionIndex).getOptions()));
                if (btnOpt3.getText().toString().trim().equalsIgnoreCase(level.getQuestion().get(quextionIndex).getTrueAns().trim())) {
                    quextionIndex++;
                    addScore();
                    layout_C.setBackgroundResource(R.drawable.right_gradient);
                    cardView_C.startAnimation(animation);
                    layout_A.setBackgroundResource(R.drawable.bg_gradient);
                    layout_B.setBackgroundResource(R.drawable.bg_gradient);
                    layout_D.setBackgroundResource(R.drawable.bg_gradient);


                } else if (!btnOpt3.getText().toString().trim().equalsIgnoreCase(level.getQuestion().get(quextionIndex).getTrueAns().trim())) {
                    layout_C.setBackgroundResource(R.drawable.wrong_gradient);
                    String trueAns = level.getQuestion().get(quextionIndex).getTrueAns().trim();

                    wrongQuestion();
                    if (btnOpt1.getText().toString().trim().equals(trueAns)) {
                        cardView_A.startAnimation(animation);
                        layout_A.setBackgroundResource(R.drawable.right_gradient);
                        layout_B.setBackgroundResource(R.drawable.bg_gradient);
                        layout_D.setBackgroundResource(R.drawable.bg_gradient);

                    } else if (btnOpt2.getText().toString().trim().equals(trueAns)) {
                        cardView_B.startAnimation(animation);
                        layout_B.setBackgroundResource(R.drawable.right_gradient);
                        layout_A.setBackgroundResource(R.drawable.bg_gradient);
                        layout_D.setBackgroundResource(R.drawable.bg_gradient);

                    } else if (btnOpt4.getText().toString().trim().equals(trueAns)) {
                        layout_D.setBackgroundResource(R.drawable.right_gradient);
                        cardView_D.startAnimation(animation);
                        layout_A.setBackgroundResource(R.drawable.bg_gradient);
                        layout_B.setBackgroundResource(R.drawable.bg_gradient);
                    }


                    quextionIndex++;
                }


            } else if (id == R.id.cardView_D2) {
                reviewspt.add(new Review(level.getQuestion().get(quextionIndex).getQuestion(),
                        level.getQuestion().get(quextionIndex).getTrueAns(),
                        btnOpt4.getText().toString(),
                        level.getQuestion().get(quextionIndex).getOptions()));

                if (btnOpt4.getText().toString().trim().equalsIgnoreCase(level.getQuestion().get(quextionIndex).getTrueAns().trim())) {
                    layout_D.setBackgroundResource(R.drawable.right_gradient);
                    cardView_D.startAnimation(animation);
                    quextionIndex++;
                    layout_A.setBackgroundResource(R.drawable.bg_gradient);
                    layout_B.setBackgroundResource(R.drawable.bg_gradient);
                    layout_C.setBackgroundResource(R.drawable.bg_gradient);
                    addScore();

                } else if (!btnOpt4.getText().toString().trim().equalsIgnoreCase(level.getQuestion().get(quextionIndex).getTrueAns().trim())) {
                    layout_D.setBackgroundResource(R.drawable.wrong_gradient);
                    wrongQuestion();
                    String trueAns = level.getQuestion().get(quextionIndex).getTrueAns().trim();

                    if (btnOpt1.getText().toString().trim().equals(trueAns)) {
                        cardView_A.startAnimation(animation);
                        layout_A.setBackgroundResource(R.drawable.right_gradient);
                        layout_B.setBackgroundResource(R.drawable.bg_gradient);
                        layout_C.setBackgroundResource(R.drawable.bg_gradient);

                    } else if (btnOpt2.getText().toString().trim().equals(trueAns)) {
                        cardView_B.startAnimation(animation);
                        layout_B.setBackgroundResource(R.drawable.right_gradient);
                        layout_A.setBackgroundResource(R.drawable.bg_gradient);
                        layout_C.setBackgroundResource(R.drawable.bg_gradient);

                    } else if (btnOpt3.getText().toString().trim().equals(trueAns)) {
                        layout_C.setBackgroundResource(R.drawable.right_gradient);
                        cardView_C.startAnimation(animation);
                        layout_A.setBackgroundResource(R.drawable.bg_gradient);
                        layout_B.setBackgroundResource(R.drawable.bg_gradient);

                    }

                    quextionIndex++;
                }

            }

        } else {
            mHandler.postDelayed(mUpdateUITimerTask, 100);


        }
        mHandler.postDelayed(mUpdateUITimerTask, 1000);


    }
    private final Runnable mUpdateUITimerTask = new Runnable() {
        public void run() {
            layout_A.setBackgroundResource(R.drawable.bg_gradient);
            layout_B.setBackgroundResource(R.drawable.bg_gradient);
            layout_C.setBackgroundResource(R.drawable.bg_gradient);
            layout_D.setBackgroundResource(R.drawable.bg_gradient);
            correctanim.setVisibility(View.GONE);
            cardView_A.clearAnimation();
            cardView_B.clearAnimation();
            cardView_C.clearAnimation();
            cardView_D.clearAnimation();
            if (getActivity() != null) {
                nextQuizQuestion();
            }
        }
    };
    private void addScore() {
        correctanim.setVisibility(View.VISIBLE);
        correctanim.setAnimation("correct-animation.json");
        correctanim.playAnimation();
        rightSound();
        correctQuestion++;
        totalScore = totalScore + 5;
        count_question_completed = count_question_completed + 1;
        score = score + 5;
        txtScore.setText("" + score);
        txtTrueQuestion.setText(""+ correctQuestion);
        int rightAns = SettingsPreferences.getRightAns(mContext);
        rightAns++;
        SettingsPreferences.setRightAns(mContext, rightAns);

    }
    private void wrongQuestion() {
        playWrongSound();
        saveScore();
        totalScore = totalScore - 2;
        score=score-2;
        txtScore.setText(""+score);
        count_question_completed = count_question_completed - 1;
        score = score - 2;

    }
    public void rightSound() {
        if (SettingsPreferences.getSoundEnableDisable(mContext)) {
            Constant.setrightAnssound(mContext);
        }
        if (SettingsPreferences.getVibration(mContext)) {
            Constant.vibrate(mContext, Constant.VIBRATION_DURATION);
        }
    }

    private void playWrongSound() {
        if (SettingsPreferences.getSoundEnableDisable(mContext)) {
            Constant.setwronAnssound(mContext);
        }
        if (SettingsPreferences.getVibration(mContext)) {
            Constant.vibrate(mContext, Constant.VIBRATION_DURATION);
        }
    }
    private void saveScore() {
        int questionRecord=SettingsPreferences.getQuestionRecord(mContext,schoolGrade);
        editor = settings.edit();
        SettingsPreferences.setCountQuestionCompleted(mContext, count_question_completed);
        editor.putInt(SettingsPreferences.TOTAL_SCORE, totalScore);
        editor.putInt(SettingsPreferences.LAST_LEVEL_SCORE, score);
        editor.putInt(SettingsPreferences.COUNT_QUESTION_COMPLETED, count_question_completed);
        editor.apply();
        int operador= 0;
        int otro=3;
        operador=correctQuestion/otro;
        if(operador<1){
            operador++;
        }
        SettingsPreferences.setCountCoinsPlaytime(mContext,operador);
        coin=coin+operador;
        SettingsPreferences.setPoint(mContext,coin);
        String record= String.valueOf(mTvTimer.getText());
        SettingsPreferences.setPoint(mContext,coin);
        if(questionRecord<correctQuestion){
            isNewRecord= true;
            SettingsPreferences.setQuestionRecord(mContext,correctQuestion,schoolGrade);
            SettingsPreferences.setTimeRecord(mContext,record,schoolGrade);
        }
        levelCompleted();



    }
    private void nextQuizQuestion() {
        setAgain();
        cardView_A.setClickable(true);
        cardView_B.setClickable(true);
        cardView_C.setClickable(true);
        cardView_D.setClickable(true);
        btnOpt1.startAnimation(RightSwipe_A);
        btnOpt2.startAnimation(RightSwipe_B);
        btnOpt3.startAnimation(RightSwipe_C);
        btnOpt4.startAnimation(RightSwipe_D);
        txtQuestion.startAnimation(Fade_in);
        if (quextionIndex < level.getNoOfQuestion()) {
            int temp = quextionIndex;

            String imgName = level.getQuestion().get(quextionIndex).getQuestion();
            Pattern p = Pattern.compile(" \r\n");
            Matcher m = p.matcher(imgName);
            imgName = m.replaceAll("_");
            txtQuestion.setText(level.getQuestion().get(quextionIndex).getQuestion());
            ArrayList<String> options = new ArrayList<>();
            options.addAll(level.getQuestion().get(quextionIndex).getOptions());
            Collections.shuffle(options);

            btnOpt1.setText("" + options.get(0).trim());
            btnOpt2.setText("" + options.get(1).trim());
            btnOpt3.setText("" + options.get(2).trim());
            btnOpt4.setText("" + options.get(3).trim());

        }

    }
    private void setAgain() {
        if (correctanim.getVisibility() == (View.VISIBLE)) {
            correctanim.setVisibility(View.GONE);
        }
        if (progressBarTwo_A.getVisibility() == (View.VISIBLE)) {
            progressBarTwo_A.setVisibility(View.GONE);
            progressBarTwo_B.setVisibility(View.GONE);
            progressBarTwo_C.setVisibility(View.GONE);
            progressBarTwo_D.setVisibility(View.GONE);
        }
    }
    private void resetAllValue() {
        correctanim= v.findViewById(R.id.correctanim2);

        recordQuestion= v.findViewById(R.id.record);
        recordTime=v.findViewById(R.id.record2);
        int recordQ= SettingsPreferences.getQuestionRecord(mContext,schoolGrade);
        String recordT=SettingsPreferences.getTimeRecord(mContext,schoolGrade);
        recordQuestion.setText(" "+ recordQ);
        recordTime.setText(recordT);
        stopWatch = new StopWatch(mTvTimer);
        stopWatch.start();
        txtTrueQuestion= v.findViewById(R.id.txtTrueQuestion2);
        txtQuestion =  v.findViewById(R.id.txtQuestion2);
        coin_count= v.findViewById(R.id.coin_count2);
        txtScore= v.findViewById(R.id.txtScore2);
        layout_A =  v.findViewById(R.id.a_layout2);
        layout_B =  v.findViewById(R.id.b_layout2);
        layout_C =  v.findViewById(R.id.c_layout2);
        layout_D =  v.findViewById(R.id.d_layout2);
        btnOpt1 = v.findViewById(R.id.btnOpt12);
        btnOpt2 = v.findViewById(R.id.btnOpt22);
        btnOpt3 = v.findViewById(R.id.btnOpt32);
        btnOpt4 = v.findViewById(R.id.btnOpt42);
        cardView_A =  v.findViewById(R.id.cardView_A2);
        cardView_B =  v.findViewById(R.id.cardView_B2);
        cardView_C =  v.findViewById(R.id.cardView_C2);
        cardView_D =  v.findViewById(R.id.cardView_D2);
        skip_question =  v.findViewById(R.id.skip_quation2);
        resettimer =  v.findViewById(R.id.reset_timer2);
        audience_poll =  v.findViewById(R.id.audience_poll2);
        progressBarTwo_A =  v.findViewById(R.id.progress_A2);
        progressBarTwo_B =  v.findViewById(R.id.progress_B2);
        progressBarTwo_C =  v.findViewById(R.id.progress_C2);
        progressBarTwo_D =  v.findViewById(R.id.progress_D2);
        progressBarTwo_A.SetAttributes(Color.parseColor(Constant.PROGRESS_COLOR), Color.parseColor(Constant.DOT_COLOR), Color.WHITE, 10);
        progressBarTwo_B.SetAttributes(Color.parseColor(Constant.PROGRESS_COLOR), Color.parseColor(Constant.DOT_COLOR), Color.WHITE, 10);
        progressBarTwo_C.SetAttributes(Color.parseColor(Constant.PROGRESS_COLOR), Color.parseColor(Constant.DOT_COLOR), Color.WHITE, 10);
        progressBarTwo_D.SetAttributes(Color.parseColor(Constant.PROGRESS_COLOR), Color.parseColor(Constant.DOT_COLOR), Color.WHITE, 10);



        audience_poll.setOnClickListener(view -> {
            if (SettingsPreferences.getSoundEnableDisable(mContext)) {
                Constant.backSoundonclick(mContext);
            }
            if (SettingsPreferences.getVibration(mContext)) {
                Constant.vibrate(mContext, Constant.VIBRATION_DURATION);
            }
            if (coin >= 4) {
                btnposition = 0;
                coin = coin - 4;

                fifty_fifty.cancelAnimation();
                skip_question.cancelAnimation();
                audience_poll.cancelAnimation();
                resettimer.cancelAnimation();
                skip_question.setProgress(0.3f);
                fifty_fifty.setProgress(0.2f);
                audience_poll.setProgress(0.5f);
                resettimer.setProgress(0.0f);
                if(coin>=4){
                    fifty_fifty.playAnimation();
                    skip_question.playAnimation();
                    audience_poll.playAnimation();
                    resettimer.playAnimation();
                }

                int min = 45;
                int max = 70;
                Random r = new Random();
                int A = r.nextInt(max - min + 1) + min;
                int remain1 = 100 - A;
                int B = r.nextInt(((remain1 - 10)) + 1);
                int remain2 = remain1 - B;
                int C = r.nextInt(((remain2 - 5)) + 1);
                int D = remain2 - C;
                progressBarTwo_A.setVisibility(View.VISIBLE);
                progressBarTwo_B.setVisibility(View.VISIBLE);
                progressBarTwo_C.setVisibility(View.VISIBLE);
                progressBarTwo_D.setVisibility(View.VISIBLE);


                if (btnOpt1.getText().toString().trim().equalsIgnoreCase(level.getQuestion().get(quextionIndex).getTrueAns().trim())) {

                    btnposition = 1;
                }

                if (btnOpt2.getText().toString().trim().equalsIgnoreCase(level.getQuestion().get(quextionIndex).getTrueAns().trim())) {

                    btnposition = 2;
                }

                if (btnOpt3.getText().toString().trim().equalsIgnoreCase(level.getQuestion().get(quextionIndex).getTrueAns().trim())) {

                    btnposition = 3;
                }

                if (btnOpt4.getText().toString().trim().equalsIgnoreCase(level.getQuestion().get(quextionIndex).getTrueAns().trim())) {
                    btnposition = 4;
                }

                if (btnposition == 1) {
                    progressBarTwo_A.setCurrentProgress(A);
                    progressBarTwo_B.setCurrentProgress(B);
                    progressBarTwo_C.setCurrentProgress(C);
                    progressBarTwo_D.setCurrentProgress(D);

                } else if (btnposition == 2) {
                    progressBarTwo_B.setCurrentProgress(A);
                    progressBarTwo_C.setCurrentProgress(C);
                    progressBarTwo_D.setCurrentProgress(D);
                    progressBarTwo_A.setCurrentProgress(B);

                } else if (btnposition == 3) {
                    progressBarTwo_C.setCurrentProgress(A);
                    progressBarTwo_B.setCurrentProgress(C);
                    progressBarTwo_D.setCurrentProgress(D);
                    progressBarTwo_A.setCurrentProgress(B);

                } else if (btnposition == 4) {
                    progressBarTwo_D.setCurrentProgress(A);
                    progressBarTwo_B.setCurrentProgress(C);
                    progressBarTwo_C.setCurrentProgress(D);
                    progressBarTwo_A.setCurrentProgress(B);

                }
            } else {
                ShowRewarded(mContext);
            }
        });
        resettimer.setOnClickListener(v -> {
            if (SettingsPreferences.getSoundEnableDisable(mContext)) {
                Constant.backSoundonclick(mContext);
            }
            if (SettingsPreferences.getVibration(mContext)) {
                Constant.vibrate(mContext, Constant.VIBRATION_DURATION);
            }
            if (coin >= 4) {
                coin = coin - 4;
                int time= stopWatch.getTime();
                time= time-50;
                stopWatch.setTime(time);
                fifty_fifty.cancelAnimation();
                skip_question.cancelAnimation();
                audience_poll.cancelAnimation();
                resettimer.cancelAnimation();
                skip_question.setProgress(0.3f);
                fifty_fifty.setProgress(0.2f);
                audience_poll.setProgress(0.5f);
                resettimer.setProgress(0.0f);
                if(coin>=4){
                    fifty_fifty.playAnimation();
                    skip_question.playAnimation();
                    audience_poll.playAnimation();
                    resettimer.playAnimation();
                }
            } else {
                ShowRewarded(getActivity());

            }
        });
        skip_question.setOnClickListener(v -> {
            if (SettingsPreferences.getSoundEnableDisable(getActivity())) {
                Constant.backSoundonclick(getActivity());
            }
            if (SettingsPreferences.getVibration(getActivity())) {
                Constant.vibrate(getActivity(), Constant.VIBRATION_DURATION);
            }
            if (coin >= 4) {
                coin = coin - 4;


                layout_A.setBackgroundResource(R.drawable.bg_gradient);
                layout_B.setBackgroundResource(R.drawable.bg_gradient);
                layout_C.setBackgroundResource(R.drawable.bg_gradient);
                layout_D.setBackgroundResource(R.drawable.bg_gradient);
                fifty_fifty.cancelAnimation();
                skip_question.cancelAnimation();
                audience_poll.cancelAnimation();
                resettimer.cancelAnimation();
                skip_question.setProgress(0.3f);
                fifty_fifty.setProgress(0.2f);
                audience_poll.setProgress(0.5f);
                resettimer.setProgress(0.0f);
                quextionIndex++;
                addScore();
                Handler mHandler= new Handler();
                mHandler.postDelayed(new Runnable() {
                    public void run() {
                        nextQuizQuestion();
                    }
                }, 1000);
                if(coin>=4){
                    fifty_fifty.playAnimation();
                    skip_question.playAnimation();
                    audience_poll.playAnimation();
                    resettimer.playAnimation();
                }

            } else {
                ShowRewarded(getActivity());
            }
        });
        fifty_fifty.setOnClickListener(v -> {
            if (SettingsPreferences.getSoundEnableDisable(mContext)) {
                Constant.backSoundonclick(mContext);
            }
            if (SettingsPreferences.getVibration(mContext)) {
                Constant.vibrate(mContext, Constant.VIBRATION_DURATION);
            }
            if (coin >= 4) {
                btnposition = 0;


                coin = coin - 4;

                fifty_fifty.cancelAnimation();
                skip_question.cancelAnimation();
                audience_poll.cancelAnimation();
                resettimer.cancelAnimation();
                skip_question.setProgress(0.3f);
                fifty_fifty.setProgress(0.2f);
                audience_poll.setProgress(0.5f);
                resettimer.setProgress(0.0f);
                if(coin>=4){
                    fifty_fifty.playAnimation();
                    skip_question.playAnimation();
                    audience_poll.playAnimation();
                    resettimer.playAnimation();
                }

                if (btnOpt1.getText().toString().trim().equalsIgnoreCase(level.getQuestion().get(quextionIndex).getTrueAns().trim())) {
                    btnposition = 1;
                }

                if (btnOpt2.getText().toString().trim().equalsIgnoreCase(level.getQuestion().get(quextionIndex).getTrueAns().trim())) {
                    btnposition = 2;
                }

                if (btnOpt3.getText().toString().trim().equalsIgnoreCase(level.getQuestion().get(quextionIndex).getTrueAns().trim())) {
                    btnposition = 3;
                }

                if (btnOpt4.getText().toString().trim().equalsIgnoreCase(level.getQuestion().get(quextionIndex).getTrueAns().trim())) {
                    btnposition = 4;
                }

                if (btnposition == 1) {
                    cardView_B.startAnimation(fifty_fifty_anim);
                    cardView_C.startAnimation(fifty_fifty_anim);

                } else if (btnposition == 2) {
                    cardView_C.startAnimation(fifty_fifty_anim);
                    cardView_D.startAnimation(fifty_fifty_anim);

                } else if (btnposition == 3) {
                    cardView_D.startAnimation(fifty_fifty_anim);
                    cardView_A.startAnimation(fifty_fifty_anim);
                } else if (btnposition == 4) {
                    cardView_A.startAnimation(fifty_fifty_anim);
                    cardView_B.startAnimation(fifty_fifty_anim);
                }
            } else {
                ShowRewarded(getActivity());
            }
        });
        txtTrueQuestion.setText("0");
        animation = AnimationUtils.loadAnimation(getActivity(), R.anim.right_ans_anim); // Change alpha from fully visible
        animation.setDuration(500); // duration - half a second
        animation.setInterpolator(new LinearInterpolator()); // do not alter
        animation.setRepeatCount(Animation.INFINITE); // Repeat animation
        animation.setRepeatMode(Animation.REVERSE); // Reverse animation at the
        count_question_completed = SettingsPreferences.getCountQuestionCompleted(mContext);
        coin = SettingsPreferences.getPoint(mContext);
        score= SettingsPreferences.getScore(mContext);
        txtScore.setText(""+score);
        coin_count.setText("" + coin);
        fifty_fifty.setProgress(0.2f);
        skip_question.setProgress(0.3f);
        audience_poll.setProgress(0.5f);
        resettimer.setProgress(0.0f);
        level = new QuizTimeLevel(SettingsPreferences.getSchoolGrade(mContext), Constant.NO_OF_QUESTIONS_PER_TIME_LEVEL, dbHelper);
        level.setTimeQuestions();
        nextQuizQuestion();

    }




    private void ShowRewarded(final Context context) {
        if (!CheckNetworkConnection.isConnectionAvailable(context)) {
            Toast.makeText(mContext,"No hay conexion a internet", Toast.LENGTH_SHORT).show();
        } else {
            final AlertDialog.Builder dialog = new AlertDialog.Builder(context);
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final View dialogView = inflater.inflate(R.layout.dialog_layout, null);
            dialog.setView(dialogView);
            TextView skip =  dialogView.findViewById(R.id.skip);
            TextView watchNow = dialogView.findViewById(R.id.watch_now);
            final AlertDialog alertDialog = dialog.create();
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
            alertDialog.show();

            alertDialog.setCancelable(false);
            skip.setOnClickListener(view -> {
                alertDialog.dismiss();
            });
            watchNow.setOnClickListener(view -> {

                alertDialog.dismiss();
            });

        }
    }
    private void levelCompleted() {




        stopWatch.pause();
        if (!isNewRecord) {
            retryDialog();
        }else if(correctQuestion<1){
            retryDialog();
            }else{

                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, fragmentTimeComplete)
                        .commit();
        }
    }
    private void blankAllValue() {
        quextionIndex = 0;
        totalScore = 0;
        count_question_completed = 0;
        score = 0;
        correctQuestion = 0;
        inCorrectQuestion = 0;

    }
    @Override
    public void onResume() {
        stopWatch.resume();
        if(coin>=4){
            fifty_fifty.playAnimation();
            skip_question.playAnimation();
            audience_poll.playAnimation();
            resettimer.playAnimation();
        }
        super.onResume();
        coin_count.setText("" + coin);

    }

    private void retryDialog() {


// Create the AlertDialog
   AlertDialog.Builder alertDialog= new AlertDialog.Builder(getActivity());
   alertDialog.setMessage("Buen Trabajo.\nPero no has superado tu record...\n¿Deseas intentar nuevamente?")
           .setCancelable(false)
           .setPositiveButton("Si", new DialogInterface.OnClickListener() {
               @Override
               public void onClick(DialogInterface dialog, int which) {
                   blankAllValue();
                   resetAllValue();
                   dialog.dismiss();
               }
           })
           .setNegativeButton("No", new DialogInterface.OnClickListener() {
               @Override
               public void onClick(DialogInterface dialog, int which) {
                   getActivity().getSupportFragmentManager().popBackStack();
                   getActivity()
                           .getSupportFragmentManager()
                           .beginTransaction()
                           .replace(R.id.fragment_container, fragmentLock)
                           .addToBackStack("tag").commit();
                   blankAllValue();
                   dialog.dismiss();
               }
           });
            AlertDialog titulo= alertDialog.create();
            titulo.setTitle("Oops..");
            titulo.show();

    }

}
