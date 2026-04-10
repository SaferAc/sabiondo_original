package com.saferapps.sabiondo;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Vibrator;


public class Constant {


    public static int NO_OF_QUESTIONS_PER_TIME_LEVEL = 200;
    public static int NO_OF_QUIZ_LEVEL = 100; //total level
    public static int NO_OF_QUESTIONS_PER_LEVEL = 10; //max que per level

    public static String PROGRESS_COLOR = "#121149"; // change progress color in play area while choose audience pole
    public static String DOT_COLOR = "#121149"; // change dot color


    public static int CIRCULAR_MAX_PROGRESS = 30; // max progress of circular progress
    public static int TIME_PER_QUESTION = 30000;  //here we set 25 second
    public static int COUNT_DOWN_TIMER = 1000; //here we set 1 second

    private static Vibrator sVibrator;
    public static int TotalQuestion = 1;
    public static int CorrectQuestions = 1;
    public static int WrongQuestions = 1;
    public static int level_coin = 0;
    public static final long VIBRATION_DURATION = 100;
    public static int RequestlevelNo = 1;




    public static void backSoundonclick(Context mContext) {
            int resourceId = R.raw.click;
            MediaPlayer mediaplayer = MediaPlayer.create(mContext, resourceId);
            mediaplayer.start();
    }

    public static void setrightAnssound(Context mContext) {
            int resourceId = R.raw.right;
            MediaPlayer mediaplayer = MediaPlayer.create(mContext, resourceId);
            mediaplayer.start();

    }

    public static void setwronAnssound(Context mContext) {
            int resourceId = R.raw.wrong;
            MediaPlayer mediaplayer = MediaPlayer.create(mContext, resourceId);
            mediaplayer.start();
    }

    public static void vibrate(Context context, long duration) {
        if (sVibrator == null) {
            sVibrator = (Vibrator) context
                    .getSystemService(Context.VIBRATOR_SERVICE);
        }
        if (sVibrator != null) {
            if (duration == 0) {
                duration = 50;
            }
            sVibrator.vibrate(duration);
        }
    }
}
