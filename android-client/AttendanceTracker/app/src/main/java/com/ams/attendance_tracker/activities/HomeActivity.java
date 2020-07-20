package com.ams.attendance_tracker.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.ams.attendance_tracker.R;
import com.ams.attendance_tracker.adapters.ViewPageAdapter;
import com.ams.attendance_tracker.utils.UserManager;

public class HomeActivity extends AppCompatActivity {

    FragmentPagerAdapter fragmentPagerAdapter;
    ViewPager viewPager;

    UserManager userManager;
    String mUserName, mAuthToken,mFirstName, mLastName, mEmailAddress, mDepartment;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.homeViewPager);

        fragmentPagerAdapter = new ViewPageAdapter(getSupportFragmentManager(), 1);
        viewPager.setAdapter(fragmentPagerAdapter);
        viewPager.setCurrentItem(1);
        userManager = new UserManager(this);

        mAuthToken = userManager.getAuthToken();

    }


}