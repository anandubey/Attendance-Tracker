package com.ams.attendance_tracker.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public  class ViewPageAdapter extends FragmentPagerAdapter {

    public ViewPageAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                    /*
                    CameraManager manager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);

                    try {
                        for (String cameraId : manager.getCameraIdList()) {
                            CameraCharacteristics characteristics
                                    = manager.getCameraCharacteristics(cameraId);


                            Log.d("Img", "INFO_SUPPORTED_HARDWARE_LEVEL " + characteristics.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL));
                        }
                    } catch (CameraAccessException e) {
                        e.printStackTrace();
                    }

                     */
                //return Camera2Fragment.newInstance();

            case 1:
                // return Dashboard fragment
                //return DashBoardFragment.newInstance();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
