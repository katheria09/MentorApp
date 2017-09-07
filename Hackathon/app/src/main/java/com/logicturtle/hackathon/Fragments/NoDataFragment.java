package com.logicturtle.hackathon.Fragments;

import android.support.v4.app.Fragment;

import com.logicturtle.hackathon.R;


public class NoDataFragment extends MentorFragment {
    @Override
    protected int getLayoutResId() {
        return R.layout.nodata_fragment;
    }

    @Override
    protected String setToolbarTitle() {
        return null;
    }

    public static Fragment getNewInstance() {
        NoDataFragment noDataFragment = new NoDataFragment();
        return noDataFragment;
    }

}