package com.saferapps.sabiondo.fragment;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

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
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;


import com.saferapps.sabiondo.Constant;
import com.saferapps.sabiondo.R;
import com.saferapps.sabiondo.helper.CheckNetworkConnection;
import com.saferapps.sabiondo.helper.CircularProgressIndicator;
import com.saferapps.sabiondo.helper.CircularProgressIndicator2;
import com.saferapps.sabiondo.helper.SettingsPreferences;
import com.saferapps.sabiondo.model.Question;
import com.saferapps.sabiondo.model.Quiz;
import com.saferapps.sabiondo.model.Quizplay;
import com.saferapps.sabiondo.model.Review;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class FragmentComunityQuiz extends Fragment implements View.OnClickListener {
    private static int levelNo = 1;
    private FragmentCompleteComunity fragmentComplete;
    private CardView cardView_A, cardView_B, cardView_C, cardView_D;
    private int schoolGrade, inCorrectQuestion = 0, quextionIndex = 0, btnposition = 0, totalScore = 0, count_question_completed = 0, score = 0, coin = 6, correctQuestion = 0, total_questions;
    private LottieAnimationView fifty_fifty, skip_quation, audience_poll, resettimer, correctanim;
    private final Handler mHandler = new Handler();
    private SharedPreferences settings;
    private static MyNewCountDownTimer myCountDownTimer;
    private CircularProgressIndicator pwOne;
    private static SharedPreferences.Editor editor;
    private Animation animation;
    private MyNewCountDownTimer myCountDownTimer1;
    private CircularProgressIndicator2 progressBarTwo_A, progressBarTwo_B, progressBarTwo_C, progressBarTwo_D;
    private Animation RightSwipe_A, RightSwipe_B, RightSwipe_C, RightSwipe_D, Fade_in, fifty_fifty_anim;
    private RelativeLayout layout_A, layout_B, layout_C, layout_D;
    private long leftTime = 0;
    private Context mContext;
    private Quiz quiz;

    public static ArrayList<Review> reviewscq = new ArrayList<>();
    private Quizplay quizplay;
    private List<Question> questionList = new ArrayList<>();
    private TextView txtQuestionIndex, txtQuestion, btnOpt1, btnOpt2, btnOpt3, btnOpt4, txtScore, txtTrueQuestion, txtFalseQuestion, coin_count;
    private View v;
    private long time;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.activity_comunity_quiz, container, false);

        fragmentComplete = new FragmentCompleteComunity();
        final int[] CLICKABLES = new int[]{R.id.cardView_Acm, R.id.cardView_Bcm, R.id.cardView_Ccm, R.id.cardView_Dcm};
        for (int i : CLICKABLES) {
            v.findViewById(i).setOnClickListener(this);
        }
        mContext = getContext();
        fifty_fifty = v.findViewById(R.id.fifty_fiftycm);
        RightSwipe_A = AnimationUtils.loadAnimation(mContext, R.anim.anim_right_a);
        RightSwipe_B = AnimationUtils.loadAnimation(mContext, R.anim.anim_right_b);
        RightSwipe_C = AnimationUtils.loadAnimation(mContext, R.anim.anim_right_c);
        RightSwipe_D = AnimationUtils.loadAnimation(mContext, R.anim.anim_right_d);
        Fade_in = AnimationUtils.loadAnimation(mContext, R.anim.fade_out);
        fifty_fifty_anim = AnimationUtils.loadAnimation(mContext, R.anim.fifty_fifty);
        settings = mContext.getSharedPreferences(SettingsPreferences.SETTING_Quiz_PREF, 0);
        schoolGrade = SettingsPreferences.getSchoolGrade(mContext);
        Bundle b = getArguments();
        quiz = (Quiz) (b != null ? b.getSerializable("quiz") : null);
        assert quiz != null;
        questionList = quiz.getQuestion_list();
        total_questions = questionList.size();
        time = quiz.getTime() * 1000;







        pwOne = v.findViewById(R.id.progressBarTwocm);
        pwOne.setMaxProgress(Constant.CIRCULAR_MAX_PROGRESS);
        pwOne.setCurrentProgress(Constant.CIRCULAR_MAX_PROGRESS);


        v.setFocusableInTouchMode(true);
        v.requestFocus();
        v.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    if (keyCode == KeyEvent.KEYCODE_BACK) {
                        if (myCountDownTimer1 != null) {
                            myCountDownTimer1.cancel();
                        }
                        if (myCountDownTimer != null) {
                            myCountDownTimer.cancel();
                        }
                        ListQuizzFragment listQuizzFragment = new ListQuizzFragment();
                        getFragmentManager().beginTransaction().replace(R.id.fragment_container, listQuizzFragment).commit();
                        return true;
                    }
                }
                return false;
            }
        });


        reviewscq.clear();
        resetAllValue();
        RelativeLayout relativeLayout = v.findViewById(R.id.wave_layoutcm);
        AnimationDrawable animationDrawable = (AnimationDrawable) relativeLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2500);
        animationDrawable.setExitFadeDuration(5000);
        animationDrawable.start();


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
            Toast.makeText(mContext, "No hay conexion a internet", Toast.LENGTH_SHORT).show();
            if (leftTime != 0) {
                myCountDownTimer1 = new MyNewCountDownTimer(leftTime, Constant.COUNT_DOWN_TIMER);
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
                    myCountDownTimer1 = new MyNewCountDownTimer(leftTime, Constant.COUNT_DOWN_TIMER);
                    myCountDownTimer1.start();
                }
            });
            watchNow.setOnClickListener(view -> {

                alertDialog.dismiss();
            });

        }
    }



    @Override
    public void onClick(View v) {
        if (quextionIndex < total_questions) {
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
            if (id == R.id.cardView_Acm) {
                reviewscq.add(new Review(quizplay.getQuestion(),
                        quizplay.getTrueAns(),
                        btnOpt1.getText().toString(),
                        quizplay.getOptions()));
                if (quizplay.getFeedback() != null) {
                    reviewscq.get(quextionIndex).setFeedback(quizplay.getFeedback());
                }


                if (btnOpt1.getText().toString().trim().equalsIgnoreCase(quizplay.getTrueAns().trim())) {
                    quextionIndex++;
                    addScore();
                    layout_A.setBackgroundResource(R.drawable.right_gradient);
                    cardView_A.startAnimation(animation);
                    layout_B.setBackgroundResource(R.drawable.bg_gradient);
                    layout_C.setBackgroundResource(R.drawable.bg_gradient);
                    layout_D.setBackgroundResource(R.drawable.bg_gradient);

                } else if (!btnOpt1.getText().toString().trim().equalsIgnoreCase(quizplay.getTrueAns().trim())) {

                    layout_A.setBackgroundResource(R.drawable.wrong_gradient);
                    wrongQuestion();
                    String trueAns = quizplay.getTrueAns().trim();
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

            } else if (id == R.id.cardView_Bcm) {
                reviewscq.add(new Review(quizplay.getQuestion(),
                        quizplay.getTrueAns(),
                        btnOpt2.getText().toString(),
                        quizplay.getOptions()));
                if (quizplay.getFeedback() != null) {
                    reviewscq.get(quextionIndex).setFeedback(quizplay.getFeedback());
                }
                if (btnOpt2.getText().toString().trim().equalsIgnoreCase(quizplay.getTrueAns().trim())) {
                    quextionIndex++;
                    addScore();
                    layout_B.setBackgroundResource(R.drawable.right_gradient);
                    cardView_B.startAnimation(animation);
                    layout_A.setBackgroundResource(R.drawable.bg_gradient);
                    layout_C.setBackgroundResource(R.drawable.bg_gradient);
                    layout_D.setBackgroundResource(R.drawable.bg_gradient);

                } else if (!btnOpt2.getText().toString().trim().equalsIgnoreCase(quizplay.getTrueAns().trim())) {

                    String trueAns = quizplay.getTrueAns().trim();
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
                if (myCountDownTimer != null) {
                    myCountDownTimer.cancel();

                }

            } else if (id == R.id.cardView_Ccm) {
                reviewscq.add(new Review(quizplay.getQuestion(),
                        quizplay.getTrueAns(),
                        btnOpt3.getText().toString(),
                        quizplay.getOptions()));
                if (quizplay.getFeedback() != null) {
                    reviewscq.get(quextionIndex).setFeedback(quizplay.getFeedback());
                }
                if (btnOpt3.getText().toString().trim().equalsIgnoreCase(quizplay.getTrueAns().trim())) {
                    quextionIndex++;
                    addScore();
                    layout_C.setBackgroundResource(R.drawable.right_gradient);
                    cardView_C.startAnimation(animation);
                    layout_A.setBackgroundResource(R.drawable.bg_gradient);
                    layout_B.setBackgroundResource(R.drawable.bg_gradient);
                    layout_D.setBackgroundResource(R.drawable.bg_gradient);


                } else if (!btnOpt3.getText().toString().trim().equalsIgnoreCase(quizplay.getTrueAns().trim())) {
                    layout_C.setBackgroundResource(R.drawable.wrong_gradient);
                    String trueAns = quizplay.getTrueAns().trim();

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

            } else if (id == R.id.cardView_Dcm) {
                reviewscq.add(new Review(quizplay.getQuestion(),
                        quizplay.getTrueAns(),
                        btnOpt4.getText().toString(),
                        quizplay.getOptions()));
                if (quizplay.getFeedback() != null) {
                    reviewscq.get(quextionIndex).setFeedback(quizplay.getFeedback());
                }

                if (btnOpt4.getText().toString().trim().equalsIgnoreCase(quizplay.getTrueAns().trim())) {
                    layout_D.setBackgroundResource(R.drawable.right_gradient);
                    cardView_D.startAnimation(animation);
                    quextionIndex++;
                    layout_A.setBackgroundResource(R.drawable.bg_gradient);
                    layout_B.setBackgroundResource(R.drawable.bg_gradient);
                    layout_C.setBackgroundResource(R.drawable.bg_gradient);
                    addScore();

                } else if (!btnOpt4.getText().toString().trim().equalsIgnoreCase(quizplay.getTrueAns().trim())) {
                    layout_D.setBackgroundResource(R.drawable.wrong_gradient);
                    wrongQuestion();
                    String trueAns = quizplay.getTrueAns().trim();

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

    public class MyNewCountDownTimer extends CountDownTimer {

        public MyNewCountDownTimer(long millisInFuture, long countDownInterval) {
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
            quextionIndex++;
            wrongQuestion();
            nextQuizQuestion();

        }
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
            if (FragmentComunityQuiz.class != null) {
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
        int rightAns = SettingsPreferences.getRightAns(mContext);
        rightAns++;
        SettingsPreferences.setRightAns(mContext, rightAns);
        SettingsPreferences.setScore(mContext, totalScore);
        SettingsPreferences.setCountQuestionCompleted(mContext, count_question_completed);
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

    private void saveScore() {
        editor = settings.edit();
        SettingsPreferences.setCountQuestionCompleted(mContext, count_question_completed);
        editor.putInt(SettingsPreferences.TOTAL_SCORE, totalScore);
        editor.putInt(SettingsPreferences.LAST_LEVEL_SCORE, score);
        editor.putInt(SettingsPreferences.COUNT_QUESTION_COMPLETED, count_question_completed);
        editor.apply();
    }

    public void levelCompleted() {
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
        SettingsPreferences.setPoint(mContext, coin);
        coin_count.setText("" + coin);
        editor.apply();
        saveScore();
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragmentComplete)
                .commit();
        blankAllValue();

    }

    private void blankAllValue() {
        quextionIndex = 0;
        totalScore = 0;
        count_question_completed = 0;
        score = 0;
        correctQuestion = 0;
        inCorrectQuestion = 0;

    }


    private void nextQuizQuestion() {
        if (quextionIndex >= total_questions) {
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
            if (quextionIndex < total_questions) {
                int temp = quextionIndex;
                txtQuestionIndex.setText(++temp + "/" + total_questions);
                quizplay = getplay(questionList.get(quextionIndex));
                txtQuestion.setText(quizplay.getQuestion());
                ArrayList<String> options = new ArrayList<>();
                options.addAll(quizplay.getOptions());
                Collections.shuffle(options);
                btnOpt1.setText("" + options.get(0).trim());
                btnOpt2.setText("" + options.get(1).trim());
                btnOpt3.setText("" + options.get(2).trim());
                btnOpt4.setText("" + options.get(3).trim());

            }
        }

    }

    private void resetAllValue() {

        correctanim = v.findViewById(R.id.correctanimcm);
        levelNo = Constant.RequestlevelNo;
        txtTrueQuestion = v.findViewById(R.id.txtTrueQuestioncm);
        txtFalseQuestion = v.findViewById(R.id.txtFalseQuestioncm);
        txtQuestion = v.findViewById(R.id.txtQuestioncm);
        layout_A = v.findViewById(R.id.a_layoutcm);
        layout_B = v.findViewById(R.id.b_layoutcm);
        layout_C = v.findViewById(R.id.c_layoutcm);
        layout_D = v.findViewById(R.id.d_layoutcm);
        txtScore = v.findViewById(R.id.txtScorecm);
        txtQuestionIndex = v.findViewById(R.id.txt_questioncm);
        coin_count = v.findViewById(R.id.coin_countcm);
        TextView txtLevel = v.findViewById(R.id.txtLevelcm);
        btnOpt1 = v.findViewById(R.id.btnOpt1cm);
        btnOpt2 = v.findViewById(R.id.btnOpt2cm);
        btnOpt3 = v.findViewById(R.id.btnOpt3cm);
        btnOpt4 = v.findViewById(R.id.btnOpt4cm);
        cardView_A = v.findViewById(R.id.cardView_Acm);
        cardView_B = v.findViewById(R.id.cardView_Bcm);
        cardView_C = v.findViewById(R.id.cardView_Ccm);
        cardView_D = v.findViewById(R.id.cardView_Dcm);

        skip_quation = v.findViewById(R.id.skip_quationcm);
        resettimer = v.findViewById(R.id.reset_timercm);
        audience_poll = v.findViewById(R.id.audience_pollcm);
        progressBarTwo_A = v.findViewById(R.id.progress_Acm);
        progressBarTwo_B = v.findViewById(R.id.progress_Bcm);
        progressBarTwo_C = v.findViewById(R.id.progress_Ccm);
        progressBarTwo_D = v.findViewById(R.id.progress_Dcm);
        progressBarTwo_A.SetAttributes(Color.parseColor(Constant.PROGRESS_COLOR), Color.parseColor(Constant.DOT_COLOR), Color.WHITE, 10);
        progressBarTwo_B.SetAttributes(Color.parseColor(Constant.PROGRESS_COLOR), Color.parseColor(Constant.DOT_COLOR), Color.WHITE, 10);
        progressBarTwo_C.SetAttributes(Color.parseColor(Constant.PROGRESS_COLOR), Color.parseColor(Constant.DOT_COLOR), Color.WHITE, 10);
        progressBarTwo_D.SetAttributes(Color.parseColor(Constant.PROGRESS_COLOR), Color.parseColor(Constant.DOT_COLOR), Color.WHITE, 10);

        coin_count.setText("" + coin);

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


                if (btnOpt1.getText().toString().trim().equalsIgnoreCase(quizplay.getTrueAns().trim())) {

                    btnposition = 1;
                }

                if (btnOpt2.getText().toString().trim().equalsIgnoreCase(quizplay.getTrueAns().trim())) {

                    btnposition = 2;
                }

                if (btnOpt3.getText().toString().trim().equalsIgnoreCase(quizplay.getTrueAns().trim())) {

                    btnposition = 3;
                }

                if (btnOpt4.getText().toString().trim().equalsIgnoreCase(quizplay.getTrueAns().trim())) {
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
                ShowRewarded(mContext);

            }
        });
        skip_quation.setOnClickListener(v -> {
            if (SettingsPreferences.getSoundEnableDisable(mContext)) {
                Constant.backSoundonclick(mContext);
            }
            if (SettingsPreferences.getVibration(mContext)) {
                Constant.vibrate(mContext, Constant.VIBRATION_DURATION);
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
                quextionIndex++;
                addScore();
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
                ShowRewarded(mContext);
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

                if (btnOpt1.getText().toString().trim().equalsIgnoreCase(quizplay.getTrueAns().trim())) {
                    btnposition = 1;
                }

                if (btnOpt2.getText().toString().trim().equalsIgnoreCase(quizplay.getTrueAns().trim())) {
                    btnposition = 2;
                }

                if (btnOpt3.getText().toString().trim().equalsIgnoreCase(quizplay.getTrueAns().trim())) {
                    btnposition = 3;
                }

                if (btnOpt4.getText().toString().trim().equalsIgnoreCase(quizplay.getTrueAns().trim())) {
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
                ShowRewarded(mContext);
            }
        });

        txtTrueQuestion.setText("0");
        txtFalseQuestion.setText("0");
        animation = AnimationUtils.loadAnimation(mContext, R.anim.right_ans_anim); // Change alpha from fully visible
        animation.setDuration(500); // duration - half a second
        animation.setInterpolator(new LinearInterpolator()); // do not alter
        animation.setRepeatCount(Animation.INFINITE); // Repeat animation
        animation.setRepeatMode(Animation.REVERSE); // Reverse animation at the
        totalScore = SettingsPreferences.getScore(mContext);
        count_question_completed = SettingsPreferences.getCountQuestionCompleted(mContext);
        coin = SettingsPreferences.getPoint(mContext);
        fifty_fifty.setProgress(0.2f);
        skip_quation.setProgress(0.3f);
        audience_poll.setProgress(0.5f);
        resettimer.setProgress(0.0f);
        txtScore.setText("" + totalScore);
        myCountDownTimer = new MyNewCountDownTimer(time, Constant.COUNT_DOWN_TIMER);
        nextQuizQuestion();
    }

    private Quizplay getplay(Question question) {
        Quizplay quizplay;
        quizplay = new Quizplay(question.getQuestion_text());
        String opA = question.getOption_a();
        String opB = question.getOption_b();
        String opC = question.getOption_c();
        String opD = question.getOption_d();
        String feedback = question.getFeedback();
        quizplay.addOption(opA);
        quizplay.addOption(opB);
        quizplay.addOption(opC);
        quizplay.addOption(opD);
        quizplay.setFeedback(feedback);
        String rightAns = question.getRight_ans();
        if (rightAns.equalsIgnoreCase("A")) {
            quizplay.setTrueAns(opA);
        } else if (rightAns.equalsIgnoreCase("B")) {
            quizplay.setTrueAns(opB);
        } else if (rightAns.equalsIgnoreCase("C")) {
            quizplay.setTrueAns(opC);
        } else {
            quizplay.setTrueAns(opD);
        }
        return quizplay;
    }

    @Override
    public void onResume() {
        if (leftTime != 0) {
            myCountDownTimer1 = new MyNewCountDownTimer(leftTime, Constant.COUNT_DOWN_TIMER);
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


}
