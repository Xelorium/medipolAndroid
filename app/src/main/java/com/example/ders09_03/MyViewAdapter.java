package com.example.ders09_03;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MyViewAdapter extends FragmentPagerAdapter {

    private Fragment[] fragments = {new FragmentUlke(), new FragmentCorona()};

    public MyViewAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return fragments[0];
            case 1:
                return fragments[1];
                default:
                    return fragments[0];
        }
    }

    @Override
    public int getCount() {
        return fragments.length;
    }
}
