package com.saferapps.sabiondo.fragment;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.airbnb.lottie.LottieAnimationView;
import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.GoogleSignIn;

import com.google.android.gms.common.api.ApiException;

import com.google.android.gms.games.Games;
import com.google.android.gms.tasks.OnSuccessListener;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.saferapps.sabiondo.Constant;
import com.saferapps.sabiondo.R;
import com.saferapps.sabiondo.activity.SetGradeActivity;
import com.saferapps.sabiondo.helper.SettingsPreferences;

import java.util.List;

import static android.app.Activity.RESULT_OK;


public class FragmentMainMenu extends Fragment{


    private ImageView logo, leaderbord1, achivments1;
    private Button online;
    private Context mContext;
    private LottieAnimationView playbutton;
    private static final int PICK_LEVEL_REQUEST = 1001;
    private static final int RC_UNUSED = 401;
    private boolean change_fragment = false;
    private static final int RC_LEADERBOARD_UI = 9004;


    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        mContext = getContext();
        View view = inflater.inflate(R.layout.fragment_mainmenu, container, false);
        logo = view.findViewById(R.id.education);
        leaderbord1 = view.findViewById(R.id.leaderbord1);
        achivments1 = view.findViewById(R.id.achivments1);
        playbutton = view.findViewById(R.id.playbutton);
        online= view.findViewById(R.id.online);


        Glide.with(mContext).asGif().load(R.drawable.education).into(logo);
        Glide.with(mContext).asBitmap().load(R.drawable.podium).into(leaderbord1);
        Glide.with(mContext).asBitmap().load(R.drawable.achive).into(achivments1);

        playbutton.setOnClickListener(v -> {
            if (SettingsPreferences.getSoundEnableDisable(mContext)) {
                Constant.backSoundonclick(mContext);
            }
            if (SettingsPreferences.getVibration(mContext)) {
                Constant.vibrate(mContext, Constant.VIBRATION_DURATION);
            }
            startGame();

        });
        leaderbord1.setOnClickListener(v -> {
            if (SettingsPreferences.getSoundEnableDisable(mContext)) {
                Constant.backSoundonclick(mContext);
            }
            if (SettingsPreferences.getVibration(mContext)) {
                Constant.vibrate(mContext, Constant.VIBRATION_DURATION);
            }
            if(isSignedIn()) {
                Games.getLeaderboardsClient(getActivity(), GoogleSignIn.getLastSignedInAccount(getContext()))
                        .getLeaderboardIntent(getString(R.string.leaderboard_sabiondos))
                        .addOnSuccessListener((OnSuccessListener<Intent>) intent ->
                                startActivityForResult(intent, RC_LEADERBOARD_UI))
                        .addOnFailureListener(e -> handleException(e, getString(R.string.achievements_exception)));
            }


        });
        achivments1.setOnClickListener(v -> {
            if (SettingsPreferences.getSoundEnableDisable(mContext)) {
                Constant.backSoundonclick(mContext);
            }
            if (SettingsPreferences.getVibration(mContext)) {
                Constant.vibrate(mContext, Constant.VIBRATION_DURATION);
            }
            if(isSignedIn()) {
                Games.getAchievementsClient(getActivity(),GoogleSignIn.getLastSignedInAccount(getContext()))
                        .getAchievementsIntent()
                        .addOnSuccessListener(intent -> startActivityForResult(intent, RC_UNUSED))
                        .addOnFailureListener(e -> handleException(e, getString(R.string.achievements_exception)));
            }else{
                Toast.makeText(mContext, "Vincule su cuenta", Toast.LENGTH_SHORT).show();
            }

        });
        online.setOnClickListener(v -> {
            if (SettingsPreferences.getSoundEnableDisable(mContext)) {
                Constant.backSoundonclick(mContext);
            }
            if (SettingsPreferences.getVibration(mContext)) {
                Constant.vibrate(mContext, Constant.VIBRATION_DURATION);
            }
            Fragment fragment = new ListQuizzFragment();
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.setCustomAnimations(android.R.anim.slide_in_left,
                    android.R.anim.slide_out_right);
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.addToBackStack(null)
                    .commit();

        });

        return view;
    }
    private void startGame() {
        if (SettingsPreferences.getSoundEnableDisable(mContext)) {
            Constant.backSoundonclick(mContext);
        }
        if (SettingsPreferences.getVibration(mContext)) {
            Constant.vibrate(mContext, Constant.VIBRATION_DURATION);
        }
        pickLevel();
    }

    private void pickLevel() {
        Intent intent = new Intent(mContext, SetGradeActivity.class);
        startActivityForResult(intent, PICK_LEVEL_REQUEST);// Activity is started with requestCode 2
    }


    private boolean isSignedIn() {
        return GoogleSignIn.getLastSignedInAccount(mContext) != null;
    }



    private void handleException(Exception e, String details) {
        int status = 0;

        if (e instanceof ApiException) {
            ApiException apiException = (ApiException) e;
            status = apiException.getStatusCode();
        }

        String message = getString(R.string.status_exception_error, details, status, e);

        new AlertDialog.Builder(mContext)
                .setMessage(message)
                .setNeutralButton(android.R.string.ok, null)
                .show();
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_LEVEL_REQUEST && resultCode == RESULT_OK) {
            change_fragment = true;
        }
    }
    @Override
    public void onResume() {
        super.onResume();
        if (change_fragment) {
            change_fragment = false;
            FragmentLock fragmentlock = new FragmentLock();
            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.fragment_container, fragmentlock, "fragment");
            ft.addToBackStack("tag");
            ft.commit();
        }
    }

}