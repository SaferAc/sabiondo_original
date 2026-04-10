package com.saferapps.sabiondo.fragment;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.card.MaterialCardView;
import com.saferapps.sabiondo.Constant;
import com.saferapps.sabiondo.R;
import com.saferapps.sabiondo.activity.MainActivity;
import com.saferapps.sabiondo.adapter.DBHelper;
import com.saferapps.sabiondo.helper.CheckNetworkConnection;
import com.saferapps.sabiondo.helper.CircularProgressIndicator;
import com.saferapps.sabiondo.helper.CircularProgressIndicator2;
import com.saferapps.sabiondo.helper.SettingsPreferences;
import com.saferapps.sabiondo.model.QuizLevel;
import com.saferapps.sabiondo.model.Review;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.concurrent.Executors;



public class FragmentPlay extends Fragment implements OnClickListener {

    private FragmentLock fragmentLevel;
    private static int levelNo = 1;
    private static QuizLevel level;
    private int schoolGrade, inCorrectQuestion = 0, quextionIndex = 0, btnposition = 0, totalScore = 0, count_question_completed = 0, score = 0, coin = 6, correctQuestion = 0;
    private FragmentComplete fragmentComplete;
    private MaterialCardView cardView_A, cardView_B, cardView_C, cardView_D;
    private LottieAnimationView fifty_fifty, skip_quation, audience_poll, resettimer, correctanim;
    private TextView txtQuestionIndex, txtQuestion, btnOpt1, btnOpt2, btnOpt3, btnOpt4, txtScore, txtTrueQuestion, txtFalseQuestion, coin_count;
    private SharedPreferences settings;
    private RelativeLayout layout_A, layout_B, layout_C, layout_D;
    private Animation animation;
    private final Handler mHandler = new Handler();
    private static SharedPreferences.Editor editor;
    private View v;
    private View loadingLayout;
    private Animation RightSwipe_A, RightSwipe_B, RightSwipe_C, RightSwipe_D, Fade_in, fifty_fifty_anim;
    private CircularProgressIndicator2 progressBarTwo_A, progressBarTwo_B, progressBarTwo_C, progressBarTwo_D;
    private CircularProgressIndicator pwOne;
    private static MyCountDownTimer myCountDownTimer;
    private Context mcontex;
    public static ArrayList<Review> reviewst = new ArrayList<>();
    private MyCountDownTimer myCountDownTimer1;


    private long leftTime = 0;

    private DBHelper dbHelper;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_play, container, false);
        fragmentComplete = new FragmentComplete();
        final int[] CLICKABLES = new int[]{R.id.cardView_A, R.id.cardView_B, R.id.cardView_C, R.id.cardView_D};
        for (int i : CLICKABLES) {
            v.findViewById(i).setOnClickListener(this);
        }
        mcontex = getContext();

            dbHelper= new DBHelper(mcontex);

        fragmentLevel= new FragmentLock();
        fifty_fifty = v.findViewById(R.id.fifty_fifty);
        RightSwipe_A = AnimationUtils.loadAnimation(getActivity(), R.anim.anim_right_a);
        RightSwipe_B = AnimationUtils.loadAnimation(getActivity(), R.anim.anim_right_b);
        RightSwipe_C = AnimationUtils.loadAnimation(getActivity(), R.anim.anim_right_c);
        RightSwipe_D = AnimationUtils.loadAnimation(getActivity(), R.anim.anim_right_d);
        Fade_in = AnimationUtils.loadAnimation(getActivity(), R.anim.fade_out);
        fifty_fifty_anim = AnimationUtils.loadAnimation(getActivity(), R.anim.fifty_fifty);
        settings = mcontex.getSharedPreferences(SettingsPreferences.SETTING_Quiz_PREF, 0);


        schoolGrade = SettingsPreferences.getSchoolGrade(mcontex);






        pwOne = v.findViewById(R.id.progressBarTwo);
        pwOne.setMaxProgress(Constant.CIRCULAR_MAX_PROGRESS);
        pwOne.setCurrentProgress(Constant.CIRCULAR_MAX_PROGRESS);

        RelativeLayout relativeLayout = v.findViewById(R.id.wave_layout);
        AnimationDrawable animationDrawable = (AnimationDrawable) relativeLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2500);
        animationDrawable.setExitFadeDuration(5000);

        animationDrawable.start();

        reviewst.clear();
        resetAllValue();

        v.setFocusableInTouchMode(true);
        v.requestFocus();
        v.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if( keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP) {
                    if (myCountDownTimer1 != null) {
                        myCountDownTimer1.cancel();
                    }
                    if (myCountDownTimer != null) {
                        myCountDownTimer.cancel();
                    }
                    FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.fragment_container, fragmentLevel);
                    ft.commit();
                    return true;
                }
                return false;
            }
        });




        return v;
    }




    private void ShowRewarded(final Context context) {
        if (myCountDownTimer != null) {
            myCountDownTimer.cancel();
        }
        if (myCountDownTimer1 != null) {
            myCountDownTimer1.cancel();
        }
        if (!CheckNetworkConnection.isConnectionAvailable(context)) {
            Toast.makeText(mcontex, "No hay conexion a internet", Toast.LENGTH_SHORT).show();
            if (leftTime != 0) {
                myCountDownTimer1 = new MyCountDownTimer(leftTime, Constant.COUNT_DOWN_TIMER);
                myCountDownTimer1.start();
            }
        } else {
            final AlertDialog.Builder dialog = new AlertDialog.Builder(context);
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final View dialogView = inflater.inflate(R.layout.dialog_layout, null);
            dialog.setView(dialogView);
            TextView skip = dialogView.findViewById(R.id.skip);
            TextView watchNow = dialogView.findViewById(R.id.watch_now);
            final AlertDialog alertDialog = dialog.create();
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
            alertDialog.show();

            alertDialog.setCancelable(false);
            skip.setOnClickListener(view -> {
                alertDialog.dismiss();
                if (leftTime != 0) {
                    myCountDownTimer1 = new MyCountDownTimer(leftTime, Constant.COUNT_DOWN_TIMER);
                    myCountDownTimer1.start();
                }
            });
            watchNow.setOnClickListener(view -> {

                alertDialog.dismiss();
            });

        }
    }






    public class MyCountDownTimer extends CountDownTimer {

        public MyCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            leftTime = millisUntilFinished;
            int progress = (int) (millisUntilFinished / Constant.COUNT_DOWN_TIMER);
            pwOne.setCurrentProgress(progress);

        }

        @Override
        public void onFinish() {
            if (quextionIndex >= Constant.NO_OF_QUESTIONS_PER_LEVEL - 1) {
                levelCompleted();

            } else {
                quextionIndex++;
                wrongQuestion();
                nextQuizQuestion();
            }
        }
    }


    @Override
    public void onStart() {
        super.onStart();
        updateUi();
    }


    private void nextQuizQuestion() {
        if (quextionIndex == level.getNoOfQuestion()) {
            levelCompleted();
        } else {
            setAgain();
            if (myCountDownTimer != null) {
                myCountDownTimer.cancel();
                myCountDownTimer.start();
            } else {
                myCountDownTimer.start();
            }
            if (myCountDownTimer1 != null) {
                myCountDownTimer1.cancel();
                leftTime = 0;
            }
            leftTime = 0;
            cardView_A.setClickable(true);
            cardView_B.setClickable(true);
            cardView_C.setClickable(true);
            cardView_D.setClickable(true);
            btnOpt1.startAnimation(RightSwipe_A);
            btnOpt2.startAnimation(RightSwipe_B);
            btnOpt3.startAnimation(RightSwipe_C);
            btnOpt4.startAnimation(RightSwipe_D);
            txtQuestion.startAnimation(Fade_in);

            int temp = quextionIndex;
            txtQuestionIndex.setText(++temp + "/" + Constant.NO_OF_QUESTIONS_PER_LEVEL);
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

    public void levelCompleted() {
        Constant.TotalQuestion = Constant.NO_OF_QUESTIONS_PER_LEVEL;
        Constant.CorrectQuestions = correctQuestion;
        Constant.WrongQuestions = inCorrectQuestion;
        if (myCountDownTimer1 != null) {
            myCountDownTimer1.cancel();
        }
        if (myCountDownTimer != null) {
            myCountDownTimer.cancel();
        }
        editor = settings.edit();
        if (correctQuestion >= 6) {
            editor.putBoolean(SettingsPreferences.IS_LAST_LEVEL_COMPLETED, true);
        } else {
            editor.putBoolean(SettingsPreferences.IS_LAST_LEVEL_COMPLETED, false);
        }
        int level_coin = 6;
        if (correctQuestion >= 6 && correctQuestion <= 7) {
            coin = coin + 1;
            level_coin = 1;
            Constant.level_coin = level_coin;
        } else if (correctQuestion >= 7 && correctQuestion <= 8) {
            coin = coin + 2;
            level_coin = 2;
            Constant.level_coin = level_coin;
        } else if (correctQuestion >= 8 && correctQuestion <= 9) {
            coin = coin + 3;
            level_coin = 3;
            Constant.level_coin = level_coin;
        } else if (correctQuestion == 10) {
            coin = coin + 4;
            level_coin = 4;
            Constant.level_coin = level_coin;
        }
        SettingsPreferences.setPoint(mcontex, coin);
        coin_count.setText("" + coin);
        editor.apply();
        saveScore();
        getActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragmentComplete)
                .commit();
        blankAllValue();


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

            if (myCountDownTimer1 != null) {
                myCountDownTimer1.cancel();
                leftTime = 0;
            }
            int id = v.getId();
            if (id == R.id.cardView_A) {
                reviewst.add(new Review(level.getQuestion().get(quextionIndex).getQuestion(),
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
                if (myCountDownTimer != null) {
                    myCountDownTimer.cancel();

                }
            } else if (id == R.id.cardView_B) {
                reviewst.add(new Review(level.getQuestion().get(quextionIndex).getQuestion(),
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
                        layout_A.setBackgroundResource(R.drawable.right_gradient);
                        layout_C.setBackgroundResource(R.drawable.bg_gradient);
                    }

                    quextionIndex++;
                }
                if (myCountDownTimer != null) {
                    myCountDownTimer.cancel();

                }

            } else if (id == R.id.cardView_C) {
                reviewst.add(new Review(level.getQuestion().get(quextionIndex).getQuestion(),
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
                if (myCountDownTimer != null) {
                    myCountDownTimer.cancel();

                }

            } else if (id == R.id.cardView_D) {
                reviewst.add(new Review(level.getQuestion().get(quextionIndex).getQuestion(),
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

                if (myCountDownTimer != null) {
                    myCountDownTimer.cancel();

                }

            }

        } else {
            mHandler.postDelayed(mUpdateUITimerTask, 100);


        }
        mHandler.postDelayed(mUpdateUITimerTask, 1000);
        txtScore.setText("" + totalScore);
    }

    private final Runnable mUpdateUITimerTask = new Runnable() {
        public void run() {
            layout_A.setBackgroundResource(R.drawable.bg_gradient);
            layout_B.setBackgroundResource(R.drawable.bg_gradient);
            layout_C.setBackgroundResource(R.drawable.bg_gradient);
            layout_D.setBackgroundResource(R.drawable.bg_gradient);
            cardView_A.clearAnimation();
            cardView_B.clearAnimation();
            cardView_C.clearAnimation();
            cardView_D.clearAnimation();
            correctanim.setVisibility(View.GONE);
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
        txtTrueQuestion.setText(" " + correctQuestion + " ");
        totalScore = totalScore + 5;
        count_question_completed = count_question_completed + 5;
        score = score + 5;
        txtScore.setText("" + totalScore);
        int rightAns = SettingsPreferences.getRightAns(mcontex);
        rightAns++;
        SettingsPreferences.setRightAns(mcontex, rightAns);
        SettingsPreferences.setScore(mcontex, totalScore);
        SettingsPreferences.setCountQuestionCompleted(mcontex, count_question_completed);
    }

    private void wrongQuestion() {
        setAgain();
        playWrongSound();
        saveScore();
        inCorrectQuestion++;
        totalScore = totalScore - 2;
        count_question_completed = count_question_completed - 2;
        score = score - 2;
        txtFalseQuestion.setText(" " + inCorrectQuestion + " ");
        txtScore.setText("" + totalScore);
    }

    private void saveScore() {
        editor = settings.edit();
        SettingsPreferences.setCountQuestionCompleted(mcontex, count_question_completed);
        editor.putInt(SettingsPreferences.TOTAL_SCORE, totalScore);
        editor.putInt(SettingsPreferences.LAST_LEVEL_SCORE, score);
        editor.putInt(SettingsPreferences.COUNT_QUESTION_COMPLETED, count_question_completed);
        editor.apply();
    }

    public void rightSound() {
        if (SettingsPreferences.getSoundEnableDisable(mcontex)) {
            Constant.setrightAnssound(mcontex);
        }
        if (SettingsPreferences.getVibration(mcontex)) {
            Constant.vibrate(mcontex, Constant.VIBRATION_DURATION);
        }
    }

    private void playWrongSound() {
        if (SettingsPreferences.getSoundEnableDisable(mcontex)) {
            Constant.setwronAnssound(mcontex);
        }
        if (SettingsPreferences.getVibration(mcontex)) {
            Constant.vibrate(mcontex, Constant.VIBRATION_DURATION);
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

        correctanim = v.findViewById(R.id.correctanim);
        levelNo = Constant.RequestlevelNo;
        txtTrueQuestion = v.findViewById(R.id.txtTrueQuestion);
        txtFalseQuestion = v.findViewById(R.id.txtFalseQuestion);
        txtQuestion = v.findViewById(R.id.txtQuestion);
        layout_A = v.findViewById(R.id.a_layout);
        layout_B = v.findViewById(R.id.b_layout);
        layout_C = v.findViewById(R.id.c_layout);
        layout_D = v.findViewById(R.id.d_layout);
        txtScore = v.findViewById(R.id.txtScore);
        txtQuestionIndex = v.findViewById(R.id.txt_question);
        coin_count = v.findViewById(R.id.coin_count);
        TextView txtLevel = v.findViewById(R.id.txtLevel);
        btnOpt1 = v.findViewById(R.id.btnOpt1);
        btnOpt2 = v.findViewById(R.id.btnOpt2);
        btnOpt3 = v.findViewById(R.id.btnOpt3);
        btnOpt4 = v.findViewById(R.id.btnOpt4);
        cardView_A = v.findViewById(R.id.cardView_A);
        cardView_B = v.findViewById(R.id.cardView_B);
        cardView_C = v.findViewById(R.id.cardView_C);
        cardView_D = v.findViewById(R.id.cardView_D);

        skip_quation = v.findViewById(R.id.skip_quation);
        resettimer = v.findViewById(R.id.reset_timer);
        audience_poll = v.findViewById(R.id.audience_poll);
        progressBarTwo_A = v.findViewById(R.id.progress_A);
        progressBarTwo_B = v.findViewById(R.id.progress_B);
        progressBarTwo_C = v.findViewById(R.id.progress_C);
        progressBarTwo_D = v.findViewById(R.id.progress_D);
        progressBarTwo_A.SetAttributes(Color.parseColor(Constant.PROGRESS_COLOR), Color.parseColor(Constant.DOT_COLOR), Color.WHITE, 10);
        progressBarTwo_B.SetAttributes(Color.parseColor(Constant.PROGRESS_COLOR), Color.parseColor(Constant.DOT_COLOR), Color.WHITE, 10);
        progressBarTwo_C.SetAttributes(Color.parseColor(Constant.PROGRESS_COLOR), Color.parseColor(Constant.DOT_COLOR), Color.WHITE, 10);
        progressBarTwo_D.SetAttributes(Color.parseColor(Constant.PROGRESS_COLOR), Color.parseColor(Constant.DOT_COLOR), Color.WHITE, 10);

        coin_count.setText("" + coin);

        audience_poll.setOnClickListener(view -> {
            if (SettingsPreferences.getSoundEnableDisable(mcontex)) {
                Constant.backSoundonclick(mcontex);
            }
            if (SettingsPreferences.getVibration(mcontex)) {
                Constant.vibrate(mcontex, Constant.VIBRATION_DURATION);
            }
            if (coin >= 4) {
                btnposition = 0;
                coin = coin - 4;
                coin_count.setText("" + coin);
                fifty_fifty.cancelAnimation();
                skip_quation.cancelAnimation();
                audience_poll.cancelAnimation();
                resettimer.cancelAnimation();
                skip_quation.setProgress(0.3f);
                fifty_fifty.setProgress(0.2f);
                audience_poll.setProgress(0.5f);
                resettimer.setProgress(0.0f);
                if (coin >= 4) {
                    fifty_fifty.playAnimation();
                    skip_quation.playAnimation();
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
                ShowRewarded(mcontex);
            }
        });
        resettimer.setOnClickListener(v -> {
            if (SettingsPreferences.getSoundEnableDisable(mcontex)) {
                Constant.backSoundonclick(mcontex);
            }
            if (SettingsPreferences.getVibration(mcontex)) {
                Constant.vibrate(mcontex, Constant.VIBRATION_DURATION);
            }
            if (coin >= 4) {
                coin = coin - 4;
                coin_count.setText("" + coin);
                fifty_fifty.cancelAnimation();
                skip_quation.cancelAnimation();
                audience_poll.cancelAnimation();
                resettimer.cancelAnimation();
                skip_quation.setProgress(0.3f);
                fifty_fifty.setProgress(0.2f);
                audience_poll.setProgress(0.5f);
                resettimer.setProgress(0.0f);
                if (coin >= 4) {
                    fifty_fifty.playAnimation();
                    skip_quation.playAnimation();
                    audience_poll.playAnimation();
                    resettimer.playAnimation();
                }


                if (myCountDownTimer1 != null) {
                    myCountDownTimer1.cancel();
                    leftTime = 0;
                }
                if (myCountDownTimer != null) {
                    myCountDownTimer.cancel();
                    myCountDownTimer.start();
                } else {
                    myCountDownTimer.start();
                }
            } else {
                ShowRewarded(getActivity());

            }
        });
        skip_quation.setOnClickListener(v -> {
            if (SettingsPreferences.getSoundEnableDisable(getActivity())) {
                Constant.backSoundonclick(getActivity());
            }
            if (SettingsPreferences.getVibration(getActivity())) {
                Constant.vibrate(getActivity(), Constant.VIBRATION_DURATION);
            }
            if (coin >= 4) {
                coin = coin - 4;
                coin_count.setText("" + coin);
                layout_A.setBackgroundResource(R.drawable.bg_gradient);
                layout_B.setBackgroundResource(R.drawable.bg_gradient);
                layout_C.setBackgroundResource(R.drawable.bg_gradient);
                layout_D.setBackgroundResource(R.drawable.bg_gradient);
                fifty_fifty.cancelAnimation();
                skip_quation.cancelAnimation();
                audience_poll.cancelAnimation();
                resettimer.cancelAnimation();
                skip_quation.setProgress(0.3f);
                fifty_fifty.setProgress(0.2f);
                audience_poll.setProgress(0.5f);
                resettimer.setProgress(0.0f);
                addScore();
                quextionIndex++;
                Handler mHandler = new Handler();
                mHandler.postDelayed(new Runnable() {
                    public void run() {
                        nextQuizQuestion();
                    }
                }, 1000);
                if (coin >= 4) {
                    fifty_fifty.playAnimation();
                    skip_quation.playAnimation();
                    audience_poll.playAnimation();
                    resettimer.playAnimation();
                }
            } else {
                ShowRewarded(getActivity());
            }
        });
        fifty_fifty.setOnClickListener(v -> {
            if (SettingsPreferences.getSoundEnableDisable(mcontex)) {
                Constant.backSoundonclick(mcontex);
            }
            if (SettingsPreferences.getVibration(mcontex)) {
                Constant.vibrate(mcontex, Constant.VIBRATION_DURATION);
            }
            if (coin >= 4) {
                btnposition = 0;


                coin = coin - 4;
                coin_count.setText("" + coin);
                fifty_fifty.cancelAnimation();
                skip_quation.cancelAnimation();
                audience_poll.cancelAnimation();
                resettimer.cancelAnimation();
                skip_quation.setProgress(0.3f);
                fifty_fifty.setProgress(0.2f);
                audience_poll.setProgress(0.5f);
                resettimer.setProgress(0.0f);
                if (coin >= 4) {
                    fifty_fifty.playAnimation();
                    skip_quation.playAnimation();
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
        txtFalseQuestion.setText("0");
        animation = AnimationUtils.loadAnimation(getActivity(), R.anim.right_ans_anim); // Change alpha from fully visible
        animation.setDuration(500); // duration - half a second
        animation.setInterpolator(new LinearInterpolator()); // do not alter
        animation.setRepeatCount(Animation.INFINITE); // Repeat animation
        animation.setRepeatMode(Animation.REVERSE); // Reverse animation at the
        totalScore = SettingsPreferences.getScore(mcontex);
        count_question_completed = SettingsPreferences.getCountQuestionCompleted(mcontex);
        coin = SettingsPreferences.getPoint(mcontex);
        fifty_fifty.setProgress(0.2f);
        skip_quation.setProgress(0.3f);
        audience_poll.setProgress(0.5f);
        resettimer.setProgress(0.0f);
        txtScore.setText("" + totalScore);
        coin_count.setText("" + coin);

        txtLevel.setText("Nivel" + " : " + Constant.RequestlevelNo);

        loadingLayout = v.findViewById(R.id.loadingLayout);

        loadGameAsync();
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
    public void onDestroyView() {
        blankAllValue();
        super.onDestroyView();
    }

    @Override
    public void onResume() {
        if (leftTime != 0) {
            myCountDownTimer1 = new MyCountDownTimer(leftTime, Constant.COUNT_DOWN_TIMER);
            myCountDownTimer1.start();
        }
        if (coin >= 4) {
            fifty_fifty.playAnimation();
            skip_quation.playAnimation();
            audience_poll.playAnimation();
            resettimer.playAnimation();
        }
        super.onResume();
        updateUi();

    /*  if (myCountDownTimer != null) {
          myCountDownTimer.cancel();
          myCountDownTimer.start();
*/
        coin_count.setText("" + coin);

    }

    @Override
    public void onPause() {
        if (myCountDownTimer != null) {
            myCountDownTimer.cancel();
        }
        if (myCountDownTimer1 != null) {
            myCountDownTimer1.cancel();
        }
        super.onPause();
    }

    void updateUi() {
        if (getActivity() == null)
            return;
    }

    private void loadGameAsync() {

    loadingLayout.setVisibility(View.VISIBLE);

    Executors.newSingleThreadExecutor().execute(() -> {

        QuizLevel tempLevel;

        if (levelNo <= 30) {
            tempLevel = new QuizLevel(Constant.RequestlevelNo,
                    SettingsPreferences.getSchoolGrade(mcontex),
                    Constant.NO_OF_QUESTIONS_PER_LEVEL,
                    dbHelper);
            tempLevel.setQuestionGuj();
        } else {
            tempLevel = new QuizLevel(SettingsPreferences.getSchoolGrade(mcontex),
                    Constant.NO_OF_QUESTIONS_PER_LEVEL,
                    dbHelper);
            tempLevel.setQuestionRandom();
        }

        requireActivity().runOnUiThread(() -> {
            level = tempLevel;
            if (level.getSchoolGrade() <= 2) {
                myCountDownTimer = new MyCountDownTimer(40000, Constant.COUNT_DOWN_TIMER);
            } else {
                myCountDownTimer = new MyCountDownTimer(Constant.TIME_PER_QUESTION, Constant.COUNT_DOWN_TIMER);
            }
            loadingLayout.setVisibility(View.GONE);
            nextQuizQuestion();
        });
    });
}

}
