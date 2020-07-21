package com.ams.attendance_tracker.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.ams.attendance_tracker.R;
import com.ams.attendance_tracker.utils.UserManager;

public class DashBoardFragment extends Fragment implements  View.OnClickListener{

    private Button mLogoutButton;
    UserManager userManager;
    public static DashBoardFragment newInstance(){
        return new DashBoardFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_dashboard, container, false);
        mLogoutButton = (Button) rootView.findViewById(R.id.logoutButton);
        mLogoutButton.setOnClickListener(this);
        userManager = new UserManager(getActivity());
        return rootView;
    }

    @Override
    public void onClick(View view) {
        if (userManager.isLoggedIn()){
            userManager.logoutUser();
        }
    }
}
