package com.ams.attendance_tracker.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.ams.attendance_tracker.activities.HomeActivity;
import com.ams.attendance_tracker.activities.LoginActivity;

import java.util.HashMap;

public class UserManager {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Context _context;

    private static final String PREF_NAME = "UserTokenPref";
    private static final String IS_LOGIN = "IsLoggedIn";

    private static final String KEY_USERNAME = "userName";
    private static final String KEY_FIRST_NAME = "firstName";
    private static final String KEY_LAST_NAME = "firstName";
    private static final String KEY_TOKEN = "accessToken";
    private static final String KEY_EMAIL = "emailId";
    private static final String KEY_DEPARTMENT = "department";

    @SuppressLint("CommitPrefEdits")
    public UserManager(Context context){
        this._context = context;
        sharedPreferences = _context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public String getAuthToken() {
        if (sharedPreferences.contains(KEY_TOKEN)){
            return sharedPreferences.getString(KEY_TOKEN, null);
        }
        return null;
    }

    public void setAuthToken(String token){
        if (!sharedPreferences.contains(KEY_TOKEN)){
            editor.putBoolean(IS_LOGIN, true);
            editor.putString(KEY_TOKEN, token);
            editor.commit();
        }
    }

    public HashMap<String, String> getUserDetails() {
        HashMap<String, String> user = new HashMap<String, String>();

        user.put(KEY_USERNAME, sharedPreferences.getString(KEY_USERNAME, null));
        user.put(KEY_TOKEN, sharedPreferences.getString(KEY_TOKEN, null));
        user.put(KEY_EMAIL, sharedPreferences.getString(KEY_EMAIL, null));
        user.put(KEY_DEPARTMENT, sharedPreferences.getString(KEY_DEPARTMENT, null));
        return user;
    }

    public void setUserDetails(String userName, String firstName, String lastName, String email, String department){
        if (this.isLoggedIn()){
            editor.putString(KEY_USERNAME, userName);
            editor.putString(KEY_EMAIL, email);
            editor.putString(KEY_FIRST_NAME, firstName);
            editor.putString(KEY_LAST_NAME, lastName);
            editor.putString(KEY_DEPARTMENT, department);
            editor.commit();
        }

    }

    public boolean isLoggedIn(){
        return sharedPreferences.getBoolean(IS_LOGIN, false);
    }

    public void checkLoginState(){
        if(!this.isLoggedIn()){
            Intent intent = new Intent(_context, LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            _context.startActivity(intent);
        }
        else{
            Intent intent = new Intent(_context, HomeActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            _context.startActivity(intent);
        }
    }


    public void logoutUser() {
        editor.clear();
        editor.commit();

        Intent intent = new Intent(_context, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        _context.startActivity(intent);
    }

}
