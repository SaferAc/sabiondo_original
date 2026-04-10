package com.saferapps.sabiondo.helper;
import android.content.Context;
import android.content.SharedPreferences;
import com.saferapps.sabiondo.model.User;
import java.util.Date;

public class SessionHandler {
    private static final String PREF_NAME= "SessionHandler";
    private static final String KEY_UID= "uId";
    private static final String KEY_USERNAME= "userName";
    private static final String KEY_PROFILEPIC= "profilepic";
    private static final String KEY_SCHOOLNAME="schoolName";
    private static final String KEY_SCHOOLEVEL= "schoolLevel";
    private static final String KEY_SCHOOLGRADE= "schoolGrade";
    private static final String KEY_ROLE= "role";
    private static final String KEY_TOTALSCORE= "totalScore";
    private static final String KEY_EXPIRES = "expires";
    private static final String KEY_EMPTY = "";
    static boolean looged = false;


    private Context mContext;
    private SharedPreferences.Editor mEditor;
    private SharedPreferences mPreferences;

    public SessionHandler(Context mContext) {
        this.mContext = mContext;
        mPreferences = mContext.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        this.mEditor = mPreferences.edit();
    }

    public void loginUser(String username, String uId,String role) {
        mEditor.putString(KEY_USERNAME, username);
        mEditor.putString(KEY_UID, uId);
        mEditor.putString(KEY_ROLE, role);
        Date date = new Date();
        looged = true;
        //Set user session for next 7 days
        long millis = date.getTime() + (24 * 60 * 60 * 1000);
        mEditor.putLong(KEY_EXPIRES, millis);
        mEditor.commit();
    }
    /**
     * Checks whether user is logged in
     *
     * @return
     */
    public boolean isLoggedIn() {
        Date currentDate = new Date();

        long millis = mPreferences.getLong(KEY_EXPIRES, 0);

        if (millis == 0) {
            return false;
        }
        Date expiryDate = new Date(millis);
        return currentDate.before(expiryDate);
    }

    public User getUserDetails() {
        //Check if user is logged in first
        if (!isLoggedIn()) {
            return null;
        }
        User user = new User();
        user.setUserName(mPreferences.getString(KEY_USERNAME, KEY_EMPTY));
        user.setuId(mPreferences.getString(KEY_UID,KEY_EMPTY));
        user.setSchoolName(mPreferences.getString(KEY_SCHOOLNAME,KEY_EMPTY));
        user.setSchoolLevel(mPreferences.getString(KEY_SCHOOLEVEL,KEY_EMPTY));
        user.setSchoolGrade(mPreferences.getString(KEY_SCHOOLGRADE,KEY_EMPTY));
        user.setRole(mPreferences.getString(KEY_ROLE,KEY_EMPTY));
        user.setProfilePic(mPreferences.getString(KEY_PROFILEPIC, KEY_EMPTY));
        user.setTotalScore(mPreferences.getInt(KEY_TOTALSCORE,0));
        user.setSessionExpiryDate(new Date(mPreferences.getLong(KEY_EXPIRES, 0)));
        return user;
    }

    public void logoutUser(){
        mEditor.clear();
        mEditor.commit();
    }


}
