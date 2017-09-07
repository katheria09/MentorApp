package com.logicturtle.hackathon.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.logicturtle.hackathon.R;


public class TermsAndConditionsFragment extends MentorFragment {
    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_terms;
    }

    @Override
    protected String setToolbarTitle() {
        return null;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
