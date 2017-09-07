package com.logicturtle.hackathon.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.astuetz.PagerSlidingTabStrip;
import com.logicturtle.hackathon.Adapter.ViewPagerAdapter;

import com.logicturtle.hackathon.R;


public class ForumFragment extends MentorFragment {
    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_viewpager;
    }

    @Override
    protected String setToolbarTitle() {
        return null;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ViewPager viewpager = view.findViewById(R.id.viewpager);
        viewpager.setAdapter(new ViewPagerAdapter(getChildFragmentManager()));

        PagerSlidingTabStrip tabsStrip = view.findViewById(R.id.tabs);
        tabsStrip.setViewPager(viewpager);


    }
}

