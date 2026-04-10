package com.saferapps.sabiondo.activity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.bumptech.glide.Glide;
import com.github.javiersantos.appupdater.AppUpdater;
import com.github.javiersantos.appupdater.enums.Display;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.games.AchievementsClient;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.LeaderboardsClient;
import com.google.android.gms.games.PlayersClient;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.saferapps.sabiondo.Constant;
import com.saferapps.sabiondo.R;
import com.saferapps.sabiondo.fragment.FragmentMainMenu;
import com.saferapps.sabiondo.fragment.StadisticsFragment;
import com.saferapps.sabiondo.helper.SessionHandler;
import com.saferapps.sabiondo.helper.SettingsPreferences;
import com.saferapps.sabiondo.model.User;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {


    private DrawerLayout drawer;
    private final Handler mHandler = new Handler();
    private final AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.2F);
    private static final int RC_SIGN_IN = 9001;

    private static int navItemIndex = 0;
    private static final String TAG_HOME = "Inicio";
    private static final String TAG_STATICS = "Estadisticas";
    private static final String TAG_SETTINGS = "Ajustes";
    private static final String TAG_INSTRUCTIONS = "Instrucciones";
    private static String CURRENT_TAG = TAG_HOME;
    private FirebaseAuth mAuth;
    private static final String TAG = "Sabiondo";
    private SessionHandler session;
    private NavigationView navigationView;
    private CircleImageView imgProfile;
    private TextView txtName;
    private String uName, profilePic;
    private Uri profile;
    private GoogleSignInClient mGoogleSignInClient;
    private GoogleSignInAccount signedInAccount;
    private AchievementsClient mAchievementsClient;
    private LeaderboardsClient mLeaderboardsClient;
    private PlayersClient mPlayersClient;
    private Context mContext;
    private final AccomplishmentsOutbox mOutbox = new AccomplishmentsOutbox();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mGoogleSignInClient = GoogleSignIn.getClient(this,
                new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_GAMES_SIGN_IN).build());

        mContext = getApplicationContext();
        FirebaseApp.initializeApp(this);
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = mAuth.getCurrentUser();
        session = new SessionHandler(mContext);
        setContentView(R.layout.activity_menu_home);
        drawer = findViewById(R.id.drawerLayout);
        FirebaseAnalytics mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        mAuth = FirebaseAuth.getInstance();
        User user = session.getUserDetails();
        uName = user.getUserName();
        profilePic = user.getProfilePic();
        profile = Uri.parse(profilePic);
        navigationView = findViewById(R.id.nav_view);
        View navHeader = navigationView.getHeaderView(0);
        txtName = navHeader.findViewById(R.id.name);
        imgProfile = navHeader.findViewById(R.id.img_profile);
        loadNavHeader();
        setUpNavigationView();
        if (savedInstanceState == null) {
            navItemIndex = 0;
            CURRENT_TAG = TAG_HOME;
            loadHomeFragment();
        }
        AppUpdater appUpdater = new AppUpdater(this);
        appUpdater.setDisplay(Display.DIALOG)
                .start();

        drawer.openDrawer(Gravity.LEFT);
        Handler mHandler = new Handler();
        mHandler.postDelayed(new Runnable() {
            public void run() {
                drawer.closeDrawers();
                Toast.makeText(MainActivity.this, "Desliza para abrir", Toast.LENGTH_SHORT).show();
            }
        }, 1000);

        getSupportFragmentManager().registerFragmentLifecycleCallbacks(
                new FragmentManager.FragmentLifecycleCallbacks() {
                    @Override
                    public void onFragmentResumed(@NonNull FragmentManager fm, @NonNull Fragment f) {
                        super.onFragmentResumed(fm, f);
                        Log.d("FRAGMENT_VIEW", "Pantalla visible -> " + f.getClass().getSimpleName());
                    }
                }, true
        );
    }




    private void setUpNavigationView() {
        // This method will trigger on item Click of navigation menu
        navigationView.setNavigationItemSelectedListener(menuItem -> {
            //Check to see which item was being clicked and perform appropriate action
            int id = menuItem.getItemId();
            if (id == R.id.nav_home) {
                navigationView.startAnimation(buttonClick);
                navItemIndex = 0;
                CURRENT_TAG = TAG_HOME;
                drawer.closeDrawers();
            } else if (id == R.id.nav_link) {
                navigationView.startAnimation(buttonClick);
                signInSilently();
                drawer.closeDrawers();
            } else if (id == R.id.nav_stadistics) {
                navigationView.startAnimation(buttonClick);
                if (SettingsPreferences.getSoundEnableDisable(mContext)) {
                    Constant.backSoundonclick(mContext);
                }
                if (SettingsPreferences.getVibration(mContext)) {
                    Constant.vibrate(mContext, Constant.VIBRATION_DURATION);
                }
                navItemIndex = 1;
                CURRENT_TAG = TAG_STATICS;
                drawer.closeDrawers();
            } else if (id == R.id.nav_settings) {
                navigationView.startAnimation(buttonClick);
                if (SettingsPreferences.getSoundEnableDisable(mContext)) {
                    Constant.backSoundonclick(mContext);
                }
                if (SettingsPreferences.getVibration(mContext)) {
                    Constant.vibrate(mContext, Constant.VIBRATION_DURATION);
                }
                navItemIndex = 2;
                CURRENT_TAG = TAG_SETTINGS;
                drawer.closeDrawers();
            } else if (id == R.id.nav_help) {
                navigationView.startAnimation(buttonClick);
                if (SettingsPreferences.getSoundEnableDisable(mContext)) {
                    Constant.backSoundonclick(mContext);
                }
                if (SettingsPreferences.getVibration(mContext)) {
                    Constant.vibrate(mContext, Constant.VIBRATION_DURATION);
                }
                navItemIndex = 3;
                CURRENT_TAG = TAG_INSTRUCTIONS;
                drawer.closeDrawers();
            } else if (id == R.id.nav_logout) {
                navigationView.startAnimation(buttonClick);
                if (SettingsPreferences.getSoundEnableDisable(mContext)) {
                    Constant.backSoundonclick(mContext);
                }
                if (SettingsPreferences.getVibration(mContext)) {
                    Constant.vibrate(mContext, Constant.VIBRATION_DURATION);
                }
                navigationView.startAnimation(buttonClick);
                session.logoutUser();
                signOut();
                Intent closeintent = new Intent(mContext, LoginActivity.class);
                startActivity(closeintent);

                finish();
            } else if (id == R.id.nav_about_us) {
                navigationView.startAnimation(buttonClick);
                if (SettingsPreferences.getSoundEnableDisable(mContext)) {
                    Constant.backSoundonclick(mContext);
                }
                if (SettingsPreferences.getVibration(mContext)) {
                    Constant.vibrate(mContext, Constant.VIBRATION_DURATION);
                }
                Intent facebookIntent = new Intent(Intent.ACTION_VIEW);
                String facebookUrl = getFacebookPageURL(mContext);
                facebookIntent.setData(Uri.parse(facebookUrl));
                startActivity(facebookIntent);
            } else if (id == R.id.nav_privacy_policy) {
                navigationView.startAnimation(buttonClick);
                if (SettingsPreferences.getSoundEnableDisable(mContext)) {
                    Constant.backSoundonclick(mContext);
                }
                if (SettingsPreferences.getVibration(mContext)) {
                    Constant.vibrate(mContext, Constant.VIBRATION_DURATION);
                }
                Intent browserIntent2 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://cutt.ly/8yF2Ul7"));
                startActivity(browserIntent2);
                drawer.closeDrawers();
            } else {
                navItemIndex = 0;
            }

            //Checking if the item is in checked state or not, if not make it in checked state
            menuItem.setChecked(!menuItem.isChecked());
            menuItem.setChecked(true);
            loadHomeFragment();

            return true;
        });


    }

    private void loadHomeFragment() {
        // selecting appropriate nav menu item
        selectNavMenu();

        if (getSupportFragmentManager().findFragmentByTag(CURRENT_TAG) != null) {

            drawer.closeDrawers();

            // show or hide the fab button
            return;
        }

        // Sometimes, when fragment has huge data, screen seems hanging
        // when switching between navigation menus
        // So using runnable, the fragment is loaded with cross fade effect
        // This effect can be seen in GMail app


        Runnable mPendingRunnable = () -> {
            // update the main content by replacing fragments
            Fragment fragment = getHomeFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.setCustomAnimations(android.R.anim.slide_in_left,
                    android.R.anim.slide_out_right);
            fragmentTransaction.replace(R.id.fragment_container, fragment, CURRENT_TAG);
            fragmentTransaction.commitAllowingStateLoss();
        };

        // If mPendingRunnable is not null, then add to the message queue
        mHandler.post(mPendingRunnable);


        //Closing drawer on item click
        drawer.closeDrawers();

    }

    private void selectNavMenu() {
        navigationView.getMenu().getItem(navItemIndex).setChecked(true);
    }

    private Fragment getHomeFragment() {
        FragmentMainMenu fragmentMainMenu;
        fragmentMainMenu = new FragmentMainMenu();
        switch (navItemIndex) {

            case 1:
                //Estadisticas fragment
                return new StadisticsFragment();
            case 2:
                // Ajustes fragment
                return new SettingsFragment();
            case 3:
                // Instruction fragment
                return new InstructionFragment();
            case 0:

            default:
                return fragmentMainMenu;
        }
    }

    private void loadNavHeader() {
        txtName.setText(uName.trim());
        if (!profilePic.isEmpty()) {
            Glide.with(this)
                    .asBitmap()
                    .dontAnimate()
                    .load(profile)
                    .into(imgProfile);
        }
    }



    public String getFacebookPageURL(Context mContext) {
        PackageManager packageManager = mContext.getPackageManager();
        String FACEBOOK_URL = "https://www.facebook.com/Sabiondo-108416387501167";
        try {
            int versionCode = packageManager.getPackageInfo("com.facebook.katana", 0).versionCode;
            if (versionCode >= 3002850) { //newer versions of fb app
                return "fb://facewebmodal/f?href=" + FACEBOOK_URL;
            } else { //older versions of fb app
                String FACEBOOK_PAGE_ID = "Sabiondo-108416387501167";
                return "fb://page/" + FACEBOOK_PAGE_ID;
            }
        } catch (PackageManager.NameNotFoundException e) {
            return FACEBOOK_URL; //normal web url
        }
    }


    private void onConnected(GoogleSignInAccount googleSignInAccount) {
        Log.d(TAG, "onConnected(): connected to Google APIs");

        mAchievementsClient = Games.getAchievementsClient(this, googleSignInAccount);
        mLeaderboardsClient = Games.getLeaderboardsClient(this, googleSignInAccount);
        mPlayersClient = Games.getPlayersClient(this, googleSignInAccount);

        // Set the greeting appropriately on main menu
        mPlayersClient.getCurrentPlayer()
                .addOnCompleteListener(task -> {
                    String displayName;
                    if (task.isSuccessful()) {
                        displayName = task.getResult().getDisplayName();
                        checkForAchievements();
                    } else {
                        Exception e = task.getException();
                        handleException(e, getString(R.string.players_exception));
                        displayName = "???";
                    }
                    Toast.makeText(MainActivity.this, "Bienvenido "+displayName, Toast.LENGTH_SHORT).show();
                });


        // if we have accomplishments to push, push them
        if (!mOutbox.isEmpty()) {
            pushAccomplishments();
            Toast.makeText(this, "Enviando progreso....",
                    Toast.LENGTH_LONG).show();
        }
    }









    private void onDisconnected() {
        Log.d(TAG, "onDisconnected()");
        //nameView.setText("Bienvenido, inicia sesión");
        mAchievementsClient = null;
        mLeaderboardsClient = null;
        mPlayersClient = null;
        mAuth.signOut();
    }





    private void pushAccomplishments() {
        if (!isSignedIn()) {
            // can't push to the cloud, try again later
            return;
        }

        if (mOutbox.achievement_nivel_1) {
            mAchievementsClient.unlock(getString(R.string.achievement_nivel_1));
            mOutbox.achievement_nivel_1 = false;
        }
        if (mOutbox.achievement_nivel_2) {
            mAchievementsClient.unlock(getString(R.string.achievement_nivel_2));
            mOutbox.achievement_nivel_2 = false;
        }
        if (mOutbox.achievement_nivel_3) {
            mAchievementsClient.unlock(getString(R.string.achievement_nivel_3));
            mOutbox.achievement_nivel_3 = false;
        }
        if (mOutbox.achievement_nivel_4) {
            mAchievementsClient.unlock(getString(R.string.achievement_nivel_4));
            mOutbox.achievement_nivel_4 = false;
        }
        if (mOutbox.achievement_nivel_5) {
            mAchievementsClient.unlock(getString(R.string.achievement_nivel_5));
            mOutbox.achievement_nivel_5 = false;
        }
        if (mOutbox.achievement_nivel_6) {
            mAchievementsClient.unlock(getString(R.string.achievement_nivel_6));
            mOutbox.achievement_nivel_6 = false;
        }
        if (mOutbox.achievement_nivel_7) {
            mAchievementsClient.unlock(getString(R.string.achievement_nivel_7));
            mOutbox.achievement_nivel_7 = false;
        }
        if (mOutbox.achievement_nivel_8) {
            mAchievementsClient.unlock(getString(R.string.achievement_nivel_8));
            mOutbox.achievement_nivel_8 = false;
        }
        if (mOutbox.achievement_nivel_9) {
            mAchievementsClient.unlock(getString(R.string.achievement_nivel_9));
            mOutbox.achievement_nivel_9 = false;
        }
        if (mOutbox.achievement_nivel_10) {
            mAchievementsClient.unlock(getString(R.string.achievement_nivel_10));
            mOutbox.achievement_nivel_10 = false;
        }
        if (mOutbox.achievement_nivel_11) {
            mAchievementsClient.unlock(getString(R.string.achievement_nivel_11));
            mOutbox.achievement_nivel_11 = false;
        }
        if (mOutbox.achievement_nivel_12) {
            mAchievementsClient.unlock(getString(R.string.achievement_nivel_12));
            mOutbox.achievement_nivel_12 = false;
        }
        if (mOutbox.achievement_nivel_13) {
            mAchievementsClient.unlock(getString(R.string.achievement_nivel_13));
            mOutbox.achievement_nivel_13 = false;
        }
        if (mOutbox.achievement_nivel_14) {
            mAchievementsClient.unlock(getString(R.string.achievement_nivel_14));
            mOutbox.achievement_nivel_14 = false;
        }
        if (mOutbox.achievement_nivel_15) {
            mAchievementsClient.unlock(getString(R.string.achievement_nivel_15));
            mOutbox.achievement_nivel_15 = false;
        }
        if (mOutbox.achievement_nivel_16) {
            mAchievementsClient.unlock(getString(R.string.achievement_nivel_16));
            mOutbox.achievement_nivel_16 = false;
        }
        if (mOutbox.achievement_nivel_17) {
            mAchievementsClient.unlock(getString(R.string.achievement_nivel_17));
            mOutbox.achievement_nivel_17 = false;
        }
        if (mOutbox.achievement_nivel_18) {
            mAchievementsClient.unlock(getString(R.string.achievement_nivel_18));
            mOutbox.achievement_nivel_18 = false;
        }
        if (mOutbox.achievement_nivel_19) {
            mAchievementsClient.unlock(getString(R.string.achievement_nivel_19));
            mOutbox.achievement_nivel_19 = false;
        }
        if (mOutbox.achievement_nivel_20) {
            mAchievementsClient.unlock(getString(R.string.achievement_nivel_20));
            mOutbox.achievement_nivel_20 = false;
        }
        if (mOutbox.achievement_nivel_21) {
            mAchievementsClient.unlock(getString(R.string.achievement_nivel_21));
            mOutbox.achievement_nivel_21 = false;
        }
        if (mOutbox.achievement_nivel_22) {
            mAchievementsClient.unlock(getString(R.string.achievement_nivel_22));
            mOutbox.achievement_nivel_22 = false;
        }
        if (mOutbox.achievement_nivel_23) {
            mAchievementsClient.unlock(getString(R.string.achievement_nivel_23));
            mOutbox.achievement_nivel_23 = false;
        }
        if (mOutbox.achievement_nivel_24) {
            mAchievementsClient.unlock(getString(R.string.achievement_nivel_24));
            mOutbox.achievement_nivel_24 = false;
        }
        if (mOutbox.achievement_nivel_25) {
            mAchievementsClient.unlock(getString(R.string.achievement_nivel_25));
            mOutbox.achievement_nivel_25 = false;
        }
        if (mOutbox.achievement_curioso) {
            mAchievementsClient.unlock(getString(R.string.achievement_curioso));
            mOutbox.achievement_curioso = false;
        }

        if (mOutbox.achievement_aprendiz) {
            mAchievementsClient.unlock(getString(R.string.achievement_aprendiz));
            mOutbox.achievement_aprendiz = false;
        }
        if (mOutbox.achievement_perspicaz) {
            mAchievementsClient.unlock(getString(R.string.achievement_perspicaz));
            mOutbox.achievement_perspicaz = false;
        }
        if (mOutbox.achievement_sagaz) {
            mAchievementsClient.unlock(getString(R.string.achievement_sagaz));
            mOutbox.achievement_sagaz = false;
        }
        if (mOutbox.achievement_ingenio) {
            mAchievementsClient.unlock(getString(R.string.achievement_ingenio));
            mOutbox.achievement_ingenio = false;
        }
        if (mOutbox.achievement_disciplina) {
            mAchievementsClient.unlock(getString(R.string.achievement_disciplina));
            mOutbox.achievement_disciplina = false;
        }
        if (mOutbox.achievement_inteligencia) {
            mAchievementsClient.unlock(getString(R.string.achievement_inteligencia));
            mOutbox.achievement_inteligencia = false;
        }
        if (mOutbox.achievement_sabiondo) {
            mAchievementsClient.unlock(getString(R.string.achievement_sabiondo));
            mOutbox.achievement_sabiondo = false;
        }
        //Change this number to only submit scores higher than x
       /* if (mOutbox.mClickScore > 0) {
            mLeaderboardsClient.submitScore(getResources().getString(R.string.leaderboard_sabiondos),
                    mOutbox.mClickScore);
            mOutbox.mClickScore = -1;
        }*/

    }



    private void checkForAchievements() {

        if (!isSignedIn()) {
            return;
        }
        int schoolGrade = SettingsPreferences.getSchoolGrade(mContext);
        int levelNo = SettingsPreferences.getNoCompletedLevel(mContext, schoolGrade);

        if (levelNo == 1) {
            mOutbox.achievement_nivel_1 = true;
            achievementToast("Nivel 1 Completo");
            pushAccomplishments();
        }
        if (levelNo == 2) {
            mOutbox.achievement_nivel_1 = true;
            mOutbox.achievement_nivel_2 = true;
            achievementToast("Nivel 2 Completo");
            pushAccomplishments();
        }
        if (levelNo == 3) {
            mOutbox.achievement_nivel_1 = true;
            mOutbox.achievement_nivel_2 = true;
            mOutbox.achievement_nivel_3 = true;
            achievementToast("Nivel 3 Completo");
            pushAccomplishments();
        }
        if (levelNo == 4) {
            mOutbox.achievement_nivel_1 = true;
            mOutbox.achievement_nivel_2 = true;
            mOutbox.achievement_nivel_3 = true;
            mOutbox.achievement_nivel_4 = true;
            achievementToast("Nivel 4 Completo");
            pushAccomplishments();

        }
        if (levelNo == 5) {
            mOutbox.achievement_nivel_1 = true;
            mOutbox.achievement_nivel_2 = true;
            mOutbox.achievement_nivel_3 = true;
            mOutbox.achievement_nivel_4 = true;
            mOutbox.achievement_nivel_5 = true;
            achievementToast("Nivel 5 Completo");
            pushAccomplishments();

        }
        if (levelNo == 6) {
            mOutbox.achievement_nivel_1 = true;
            mOutbox.achievement_nivel_2 = true;
            mOutbox.achievement_nivel_3 = true;
            mOutbox.achievement_nivel_4 = true;
            mOutbox.achievement_nivel_5 = true;
            mOutbox.achievement_nivel_6 = true;
            achievementToast("Nivel 6 Completo");
            pushAccomplishments();

        }
        if (levelNo == 7) {
            mOutbox.achievement_nivel_1 = true;
            mOutbox.achievement_nivel_2 = true;
            mOutbox.achievement_nivel_3 = true;
            mOutbox.achievement_nivel_4 = true;
            mOutbox.achievement_nivel_5 = true;
            mOutbox.achievement_nivel_6 = true;
            mOutbox.achievement_nivel_7 = true;
            achievementToast("Nivel 7 Completo");
            pushAccomplishments();

        }
        if (levelNo == 8) {
            mOutbox.achievement_nivel_1 = true;
            mOutbox.achievement_nivel_2 = true;
            mOutbox.achievement_nivel_3 = true;
            mOutbox.achievement_nivel_4 = true;
            mOutbox.achievement_nivel_5 = true;
            mOutbox.achievement_nivel_6 = true;
            mOutbox.achievement_nivel_7 = true;
            mOutbox.achievement_nivel_8 = true;
            achievementToast("Nivel 8 Completo");
            pushAccomplishments();

        }
        if (levelNo == 9) {
            mOutbox.achievement_nivel_1 = true;
            mOutbox.achievement_nivel_2 = true;
            mOutbox.achievement_nivel_3 = true;
            mOutbox.achievement_nivel_4 = true;
            mOutbox.achievement_nivel_5 = true;
            mOutbox.achievement_nivel_6 = true;
            mOutbox.achievement_nivel_7 = true;
            mOutbox.achievement_nivel_8 = true;
            mOutbox.achievement_nivel_9 = true;
            achievementToast("Nivel 9 Completo");
            pushAccomplishments();

        }
        if (levelNo == 10) {
            mOutbox.achievement_nivel_1 = true;
            mOutbox.achievement_nivel_2 = true;
            mOutbox.achievement_nivel_3 = true;
            mOutbox.achievement_nivel_4 = true;
            mOutbox.achievement_nivel_5 = true;
            mOutbox.achievement_nivel_6 = true;
            mOutbox.achievement_nivel_7 = true;
            mOutbox.achievement_nivel_8 = true;
            mOutbox.achievement_nivel_9 = true;
            mOutbox.achievement_nivel_10 = true;
            achievementToast("Nivel 10 Completo");
            pushAccomplishments();

        }
        if (levelNo == 11) {
            mOutbox.achievement_nivel_1 = true;
            mOutbox.achievement_nivel_2 = true;
            mOutbox.achievement_nivel_3 = true;
            mOutbox.achievement_nivel_4 = true;
            mOutbox.achievement_nivel_5 = true;
            mOutbox.achievement_nivel_6 = true;
            mOutbox.achievement_nivel_7 = true;
            mOutbox.achievement_nivel_8 = true;
            mOutbox.achievement_nivel_9 = true;
            mOutbox.achievement_nivel_10 = true;
            mOutbox.achievement_nivel_11 = true;
            achievementToast("Nivel 11 Completo");
            pushAccomplishments();

        }
        if (levelNo == 12) {
            mOutbox.achievement_nivel_1 = true;
            mOutbox.achievement_nivel_2 = true;
            mOutbox.achievement_nivel_3 = true;
            mOutbox.achievement_nivel_4 = true;
            mOutbox.achievement_nivel_5 = true;
            mOutbox.achievement_nivel_6 = true;
            mOutbox.achievement_nivel_7 = true;
            mOutbox.achievement_nivel_8 = true;
            mOutbox.achievement_nivel_9 = true;
            mOutbox.achievement_nivel_10 = true;
            mOutbox.achievement_nivel_11 = true;
            mOutbox.achievement_nivel_12 = true;
            achievementToast("Nivel 12 Completo");
            pushAccomplishments();

        }
        if (levelNo == 13) {
            mOutbox.achievement_nivel_1 = true;
            mOutbox.achievement_nivel_2 = true;
            mOutbox.achievement_nivel_3 = true;
            mOutbox.achievement_nivel_4 = true;
            mOutbox.achievement_nivel_5 = true;
            mOutbox.achievement_nivel_6 = true;
            mOutbox.achievement_nivel_7 = true;
            mOutbox.achievement_nivel_8 = true;
            mOutbox.achievement_nivel_9 = true;
            mOutbox.achievement_nivel_10 = true;
            mOutbox.achievement_nivel_11 = true;
            mOutbox.achievement_nivel_12 = true;
            mOutbox.achievement_nivel_13 = true;
            achievementToast("Nivel 12 Completo");
            pushAccomplishments();

        }
        if (levelNo == 14) {
            mOutbox.achievement_nivel_1 = true;
            mOutbox.achievement_nivel_2 = true;
            mOutbox.achievement_nivel_3 = true;
            mOutbox.achievement_nivel_4 = true;
            mOutbox.achievement_nivel_5 = true;
            mOutbox.achievement_nivel_6 = true;
            mOutbox.achievement_nivel_7 = true;
            mOutbox.achievement_nivel_8 = true;
            mOutbox.achievement_nivel_9 = true;
            mOutbox.achievement_nivel_10 = true;
            mOutbox.achievement_nivel_11 = true;
            mOutbox.achievement_nivel_12 = true;
            mOutbox.achievement_nivel_13 = true;
            mOutbox.achievement_nivel_14 = true;
            achievementToast("Nivel 14 Completo");
            pushAccomplishments();

        }
        if (levelNo == 15) {
            mOutbox.achievement_nivel_1 = true;
            mOutbox.achievement_nivel_2 = true;
            mOutbox.achievement_nivel_3 = true;
            mOutbox.achievement_nivel_4 = true;
            mOutbox.achievement_nivel_5 = true;
            mOutbox.achievement_nivel_6 = true;
            mOutbox.achievement_nivel_7 = true;
            mOutbox.achievement_nivel_8 = true;
            mOutbox.achievement_nivel_9 = true;
            mOutbox.achievement_nivel_10 = true;
            mOutbox.achievement_nivel_11 = true;
            mOutbox.achievement_nivel_12 = true;
            mOutbox.achievement_nivel_13 = true;
            mOutbox.achievement_nivel_14 = true;
            mOutbox.achievement_nivel_15 = true;
            achievementToast("Nivel 15 Completo");
            pushAccomplishments();

        }
        if (levelNo == 16) {
            mOutbox.achievement_nivel_1 = true;
            mOutbox.achievement_nivel_2 = true;
            mOutbox.achievement_nivel_3 = true;
            mOutbox.achievement_nivel_4 = true;
            mOutbox.achievement_nivel_5 = true;
            mOutbox.achievement_nivel_6 = true;
            mOutbox.achievement_nivel_7 = true;
            mOutbox.achievement_nivel_8 = true;
            mOutbox.achievement_nivel_9 = true;
            mOutbox.achievement_nivel_10 = true;
            mOutbox.achievement_nivel_11 = true;
            mOutbox.achievement_nivel_12 = true;
            mOutbox.achievement_nivel_13 = true;
            mOutbox.achievement_nivel_14 = true;
            mOutbox.achievement_nivel_15 = true;
            mOutbox.achievement_nivel_16 = true;
            achievementToast("Nivel 16 Completo");
            pushAccomplishments();

        }
        if (levelNo == 17) {
            mOutbox.achievement_nivel_1 = true;
            mOutbox.achievement_nivel_2 = true;
            mOutbox.achievement_nivel_3 = true;
            mOutbox.achievement_nivel_4 = true;
            mOutbox.achievement_nivel_5 = true;
            mOutbox.achievement_nivel_6 = true;
            mOutbox.achievement_nivel_7 = true;
            mOutbox.achievement_nivel_8 = true;
            mOutbox.achievement_nivel_9 = true;
            mOutbox.achievement_nivel_10 = true;
            mOutbox.achievement_nivel_11 = true;
            mOutbox.achievement_nivel_12 = true;
            mOutbox.achievement_nivel_13 = true;
            mOutbox.achievement_nivel_14 = true;
            mOutbox.achievement_nivel_15 = true;
            mOutbox.achievement_nivel_16 = true;
            mOutbox.achievement_nivel_17 = true;
            achievementToast("Nivel 18 Completo");
            pushAccomplishments();

        }
        if (levelNo == 18) {
            mOutbox.achievement_nivel_1 = true;
            mOutbox.achievement_nivel_2 = true;
            mOutbox.achievement_nivel_3 = true;
            mOutbox.achievement_nivel_4 = true;
            mOutbox.achievement_nivel_5 = true;
            mOutbox.achievement_nivel_6 = true;
            mOutbox.achievement_nivel_7 = true;
            mOutbox.achievement_nivel_8 = true;
            mOutbox.achievement_nivel_9 = true;
            mOutbox.achievement_nivel_10 = true;
            mOutbox.achievement_nivel_11 = true;
            mOutbox.achievement_nivel_12 = true;
            mOutbox.achievement_nivel_13 = true;
            mOutbox.achievement_nivel_14 = true;
            mOutbox.achievement_nivel_15 = true;
            mOutbox.achievement_nivel_16 = true;
            mOutbox.achievement_nivel_17 = true;
            mOutbox.achievement_nivel_18 = true;
            achievementToast("Nivel 18 Completo");
            pushAccomplishments();

        }
        if (levelNo == 19) {
            mOutbox.achievement_nivel_1 = true;
            mOutbox.achievement_nivel_2 = true;
            mOutbox.achievement_nivel_3 = true;
            mOutbox.achievement_nivel_4 = true;
            mOutbox.achievement_nivel_5 = true;
            mOutbox.achievement_nivel_6 = true;
            mOutbox.achievement_nivel_7 = true;
            mOutbox.achievement_nivel_8 = true;
            mOutbox.achievement_nivel_9 = true;
            mOutbox.achievement_nivel_10 = true;
            mOutbox.achievement_nivel_11 = true;
            mOutbox.achievement_nivel_12 = true;
            mOutbox.achievement_nivel_13 = true;
            mOutbox.achievement_nivel_14 = true;
            mOutbox.achievement_nivel_15 = true;
            mOutbox.achievement_nivel_16 = true;
            mOutbox.achievement_nivel_17 = true;
            mOutbox.achievement_nivel_18 = true;
            mOutbox.achievement_nivel_19 = true;
            achievementToast("Nivel 19 Completo");
            pushAccomplishments();

        }
        if (levelNo == 20) {
            mOutbox.achievement_nivel_1 = true;
            mOutbox.achievement_nivel_2 = true;
            mOutbox.achievement_nivel_3 = true;
            mOutbox.achievement_nivel_4 = true;
            mOutbox.achievement_nivel_5 = true;
            mOutbox.achievement_nivel_6 = true;
            mOutbox.achievement_nivel_7 = true;
            mOutbox.achievement_nivel_8 = true;
            mOutbox.achievement_nivel_9 = true;
            mOutbox.achievement_nivel_10 = true;
            mOutbox.achievement_nivel_11 = true;
            mOutbox.achievement_nivel_12 = true;
            mOutbox.achievement_nivel_13 = true;
            mOutbox.achievement_nivel_14 = true;
            mOutbox.achievement_nivel_15 = true;
            mOutbox.achievement_nivel_16 = true;
            mOutbox.achievement_nivel_17 = true;
            mOutbox.achievement_nivel_18 = true;
            mOutbox.achievement_nivel_19 = true;
            mOutbox.achievement_nivel_20 = true;
            achievementToast("Nivel 20 Completo");
            pushAccomplishments();

        }
        if (levelNo == 21) {
            mOutbox.achievement_nivel_1 = true;
            mOutbox.achievement_nivel_2 = true;
            mOutbox.achievement_nivel_3 = true;
            mOutbox.achievement_nivel_4 = true;
            mOutbox.achievement_nivel_5 = true;
            mOutbox.achievement_nivel_6 = true;
            mOutbox.achievement_nivel_7 = true;
            mOutbox.achievement_nivel_8 = true;
            mOutbox.achievement_nivel_9 = true;
            mOutbox.achievement_nivel_10 = true;
            mOutbox.achievement_nivel_11 = true;
            mOutbox.achievement_nivel_12 = true;
            mOutbox.achievement_nivel_13 = true;
            mOutbox.achievement_nivel_14 = true;
            mOutbox.achievement_nivel_15 = true;
            mOutbox.achievement_nivel_16 = true;
            mOutbox.achievement_nivel_17 = true;
            mOutbox.achievement_nivel_18 = true;
            mOutbox.achievement_nivel_19 = true;
            mOutbox.achievement_nivel_20 = true;
            mOutbox.achievement_nivel_21 = true;
            achievementToast("Nivel 21 Completo");
            pushAccomplishments();

        }
        if (levelNo == 22) {
            mOutbox.achievement_nivel_1 = true;
            mOutbox.achievement_nivel_2 = true;
            mOutbox.achievement_nivel_3 = true;
            mOutbox.achievement_nivel_4 = true;
            mOutbox.achievement_nivel_5 = true;
            mOutbox.achievement_nivel_6 = true;
            mOutbox.achievement_nivel_7 = true;
            mOutbox.achievement_nivel_8 = true;
            mOutbox.achievement_nivel_9 = true;
            mOutbox.achievement_nivel_10 = true;
            mOutbox.achievement_nivel_11 = true;
            mOutbox.achievement_nivel_12 = true;
            mOutbox.achievement_nivel_13 = true;
            mOutbox.achievement_nivel_14 = true;
            mOutbox.achievement_nivel_15 = true;
            mOutbox.achievement_nivel_16 = true;
            mOutbox.achievement_nivel_17 = true;
            mOutbox.achievement_nivel_18 = true;
            mOutbox.achievement_nivel_19 = true;
            mOutbox.achievement_nivel_20 = true;
            mOutbox.achievement_nivel_21 = true;
            mOutbox.achievement_nivel_22 = true;
            achievementToast("Nivel 22 Completo");
            pushAccomplishments();

        }
        if (levelNo == 23) {
            mOutbox.achievement_nivel_1 = true;
            mOutbox.achievement_nivel_2 = true;
            mOutbox.achievement_nivel_3 = true;
            mOutbox.achievement_nivel_4 = true;
            mOutbox.achievement_nivel_5 = true;
            mOutbox.achievement_nivel_6 = true;
            mOutbox.achievement_nivel_7 = true;
            mOutbox.achievement_nivel_8 = true;
            mOutbox.achievement_nivel_9 = true;
            mOutbox.achievement_nivel_10 = true;
            mOutbox.achievement_nivel_11 = true;
            mOutbox.achievement_nivel_12 = true;
            mOutbox.achievement_nivel_13 = true;
            mOutbox.achievement_nivel_14 = true;
            mOutbox.achievement_nivel_15 = true;
            mOutbox.achievement_nivel_16 = true;
            mOutbox.achievement_nivel_17 = true;
            mOutbox.achievement_nivel_18 = true;
            mOutbox.achievement_nivel_19 = true;
            mOutbox.achievement_nivel_20 = true;
            mOutbox.achievement_nivel_21 = true;
            mOutbox.achievement_nivel_22 = true;
            mOutbox.achievement_nivel_23 = true;
            achievementToast("Nivel 23 Completo");
            pushAccomplishments();

        }
        if (levelNo == 24) {
            mOutbox.achievement_nivel_1 = true;
            mOutbox.achievement_nivel_2 = true;
            mOutbox.achievement_nivel_3 = true;
            mOutbox.achievement_nivel_4 = true;
            mOutbox.achievement_nivel_5 = true;
            mOutbox.achievement_nivel_6 = true;
            mOutbox.achievement_nivel_7 = true;
            mOutbox.achievement_nivel_8 = true;
            mOutbox.achievement_nivel_9 = true;
            mOutbox.achievement_nivel_10 = true;
            mOutbox.achievement_nivel_11 = true;
            mOutbox.achievement_nivel_12 = true;
            mOutbox.achievement_nivel_13 = true;
            mOutbox.achievement_nivel_14 = true;
            mOutbox.achievement_nivel_15 = true;
            mOutbox.achievement_nivel_16 = true;
            mOutbox.achievement_nivel_17 = true;
            mOutbox.achievement_nivel_18 = true;
            mOutbox.achievement_nivel_19 = true;
            mOutbox.achievement_nivel_20 = true;
            mOutbox.achievement_nivel_21 = true;
            mOutbox.achievement_nivel_22 = true;
            mOutbox.achievement_nivel_23 = true;
            mOutbox.achievement_nivel_24 = true;
            achievementToast("Nivel 24 Completo");
            pushAccomplishments();

        }
        if (levelNo == 25) {
            mOutbox.achievement_nivel_1 = true;
            mOutbox.achievement_nivel_2 = true;
            mOutbox.achievement_nivel_3 = true;
            mOutbox.achievement_nivel_4 = true;
            mOutbox.achievement_nivel_5 = true;
            mOutbox.achievement_nivel_6 = true;
            mOutbox.achievement_nivel_7 = true;
            mOutbox.achievement_nivel_8 = true;
            mOutbox.achievement_nivel_9 = true;
            mOutbox.achievement_nivel_10 = true;
            mOutbox.achievement_nivel_11 = true;
            mOutbox.achievement_nivel_12 = true;
            mOutbox.achievement_nivel_13 = true;
            mOutbox.achievement_nivel_14 = true;
            mOutbox.achievement_nivel_15 = true;
            mOutbox.achievement_nivel_16 = true;
            mOutbox.achievement_nivel_17 = true;
            mOutbox.achievement_nivel_18 = true;
            mOutbox.achievement_nivel_19 = true;
            mOutbox.achievement_nivel_20 = true;
            mOutbox.achievement_nivel_21 = true;
            mOutbox.achievement_nivel_22 = true;
            mOutbox.achievement_nivel_23 = true;
            mOutbox.achievement_nivel_24 = true;
            mOutbox.achievement_nivel_25 = true;
            achievementToast("Nivel 25 Completo");
            pushAccomplishments();
        }
        int rightAns = SettingsPreferences.getRightAns(mContext);
        //give when right answer reached to given figure
        if (rightAns == 10) {
            mOutbox.achievement_curioso = true;
            achievementToast("10 respuestas correctas");
            pushAccomplishments();
        }
        if (rightAns == 20) {
            mOutbox.achievement_curioso = true;
            mOutbox.achievement_aprendiz = true;
            achievementToast("20 respuestas correctas");
            pushAccomplishments();
        }

        if (rightAns == 50) {
            mOutbox.achievement_curioso = true;
            mOutbox.achievement_aprendiz = true;
            mOutbox.achievement_perspicaz = true;
            achievementToast("50 respuestas correctas");
            pushAccomplishments();
        }

        if (rightAns == 100) {
            mOutbox.achievement_curioso = true;
            mOutbox.achievement_aprendiz = true;
            mOutbox.achievement_perspicaz = true;
            mOutbox.achievement_sagaz = true;
            achievementToast("100 respuestas correctas");
            pushAccomplishments();
        }

        if (rightAns == 200) {
            mOutbox.achievement_curioso = true;
            mOutbox.achievement_aprendiz = true;
            mOutbox.achievement_perspicaz = true;
            mOutbox.achievement_sagaz = true;
            mOutbox.achievement_ingenio = true;
            achievementToast("200 respuestas correctas");
            pushAccomplishments();
        }
        if (rightAns == 400) {
            mOutbox.achievement_curioso = true;
            mOutbox.achievement_aprendiz = true;
            mOutbox.achievement_perspicaz = true;
            mOutbox.achievement_sagaz = true;
            mOutbox.achievement_ingenio = true;
            mOutbox.achievement_disciplina = true;
            achievementToast("400 respuestas correctas");
            pushAccomplishments();
        }

        if (rightAns == 500) {
            mOutbox.achievement_curioso = true;
            mOutbox.achievement_aprendiz = true;
            mOutbox.achievement_perspicaz = true;
            mOutbox.achievement_sagaz = true;
            mOutbox.achievement_ingenio = true;
            mOutbox.achievement_disciplina = true;
            mOutbox.achievement_inteligencia = true;
            achievementToast("300 respuestas correctas");
            pushAccomplishments();
        }
        if (rightAns > 600) {
            mOutbox.achievement_sabiondo = true;
            achievementToast("Eres un sabiondo más de 600 respuestas correctas");
            pushAccomplishments();
        }


    }




    private void signOut() {
        Log.d(TAG, "signOut()");

        if (!isSignedIn()) {
            Log.w(TAG, "signOut() called, but was not signed in!");
            return;
        }

        mGoogleSignInClient.signOut().addOnCompleteListener(this,
                task -> {
                    boolean successful = task.isSuccessful();
                    Log.d(TAG, "signOut(): " + (successful ? "success" : "failed"));
                    Toast.makeText(mContext, "Sesión Cerrada", Toast.LENGTH_SHORT).show();
                    onDisconnected();
                });
    }


    private static class AccomplishmentsOutbox {
        boolean achievement_nivel_1 = false;
        boolean achievement_nivel_2 = false;
        boolean achievement_nivel_3 = false;
        boolean achievement_nivel_4 = false;
        boolean achievement_nivel_5 = false;
        boolean achievement_nivel_6 = false;
        boolean achievement_nivel_7 = false;
        boolean achievement_nivel_8 = false;
        boolean achievement_nivel_9 = false;
        boolean achievement_nivel_10 = false;
        boolean achievement_nivel_11 = false;
        boolean achievement_nivel_12 = false;
        boolean achievement_nivel_13 = false;
        boolean achievement_nivel_14 = false;
        boolean achievement_nivel_15 = false;
        boolean achievement_nivel_16 = false;
        boolean achievement_nivel_17 = false;
        boolean achievement_nivel_18 = false;
        boolean achievement_nivel_19 = false;
        boolean achievement_nivel_20 = false;
        boolean achievement_nivel_21 = false;
        boolean achievement_nivel_22 = false;
        boolean achievement_nivel_23 = false;
        boolean achievement_nivel_24 = false;
        boolean achievement_nivel_25 = false;
        boolean achievement_curioso = false;
        boolean achievement_aprendiz = false;
        boolean achievement_perspicaz = false;
        boolean achievement_sagaz = false;
        boolean achievement_ingenio = false;
        boolean achievement_disciplina = false;
        boolean achievement_inteligencia = false;
        boolean achievement_sabiondo = false;

        boolean isEmpty() {
            return !achievement_nivel_1 && !achievement_nivel_2 && !achievement_nivel_3 &&
                   !achievement_nivel_4 && !achievement_nivel_5 && !achievement_nivel_6 &&
                   !achievement_nivel_7 && !achievement_nivel_8 && !achievement_nivel_9 &&
                   !achievement_nivel_10 && !achievement_nivel_11 && !achievement_nivel_12 &&
                   !achievement_nivel_13 && !achievement_nivel_14 && !achievement_nivel_15 &&
                   !achievement_nivel_16 && !achievement_nivel_17 && !achievement_nivel_18 &&
                   !achievement_nivel_19 && !achievement_nivel_20 && !achievement_nivel_21 &&
                   !achievement_nivel_22 && !achievement_nivel_23 && !achievement_nivel_24 &&
                    !achievement_nivel_25 &&
                   !achievement_curioso && !achievement_aprendiz &&
                   !achievement_perspicaz && !achievement_sagaz &&
                   !achievement_ingenio && !achievement_disciplina &&
                   !achievement_inteligencia && !achievement_sabiondo;
        }

    }




    private void achievementToast(String achievement) {
        // Only show toast if not signed in. If signed in, the standard Google Play
        // toasts will appear, so we don't need to show our own.
        if (isSignedIn()) {
            Toast.makeText(mContext, getString(R.string.achievement) + ": " + achievement,
                    Toast.LENGTH_LONG).show();
        }
    }
    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawers();
            return;
        }

        // This code loads home fragment when back key is pressed
        // when user is in other fragment than home
        boolean shouldLoadHomeFragOnBackPress = true;
        if (shouldLoadHomeFragOnBackPress) {
            // checking if user is on other navigation menu
            // rather than home
            if (navItemIndex != 0) {
                navItemIndex = 0;
                CURRENT_TAG = TAG_HOME;
                loadHomeFragment();
                return;
            }
        }

        super.onBackPressed();
    }
    private void signInSilently() {
        GoogleSignInOptions signInOptions = GoogleSignInOptions.DEFAULT_GAMES_SIGN_IN;
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        if (GoogleSignIn.hasPermissions(account, signInOptions.getScopeArray())) {
            signedInAccount = account;
            onConnected(signedInAccount);
        } else {
            // Haven't been signed-in before. Try the silent sign-in first.
            GoogleSignInClient signInClient = GoogleSignIn.getClient(this, signInOptions);
            signInClient
                    .silentSignIn()
                    .addOnCompleteListener(
                            this,
                            task -> {
                                if (task.isSuccessful()) {
                                    // The signed in account is stored in the task's result.
                                    signedInAccount = task.getResult();
                                    onConnected(signedInAccount);
                                } else {
                                    startSignInIntent();
                                }
                            });
        }
    }
    private void startSignInIntent() {
        GoogleSignInClient signInClient = GoogleSignIn.getClient(this,
                GoogleSignInOptions.DEFAULT_GAMES_SIGN_IN);
        Intent intent = signInClient.getSignInIntent();
        startActivityForResult(intent, RC_SIGN_IN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            if (result.isSuccess()) {
                signedInAccount = result.getSignInAccount();
                onConnected(signedInAccount);
            } else {
                String message = result.getStatus().getStatusMessage();
                if (message == null || message.isEmpty()) {
                    message = "Hubo un error al vincular la cuenta";
                }
                new AlertDialog.Builder(this).setMessage(message)
                        .setNeutralButton(android.R.string.ok, null).show();
            }
        }

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

}
