package com.logicturtle.hackathon.Fragments;

import android.support.v4.app.Fragment;

import com.logicturtle.hackathon.R;



public class ViewPagerFragment extends MentorFragment {
    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_viewpager;
    }

    @Override
    protected String setToolbarTitle() {
        return null;
    }

    public static Fragment getNewInstance() {
        ViewPagerFragment viewPagerFragment = new ViewPagerFragment();
        return viewPagerFragment;
    }
}
