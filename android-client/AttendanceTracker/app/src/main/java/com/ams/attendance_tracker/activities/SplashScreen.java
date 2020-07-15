package com.ams.attendance_tracker.activities;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.ams.attendance_tracker.utils.UserManager;

public class SplashScreen extends AppCompatActivity {

    UserManager userManager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        userManager = new UserManager(this);
        userManager.checkLoginState();
        SplashScreen.this.finish();
    }
}