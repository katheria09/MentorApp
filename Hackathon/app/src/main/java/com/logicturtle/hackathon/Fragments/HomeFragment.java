package com.logicturtle.hackathon.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;

import at.favre.lib.dali.Dali;
import butterknife.BindView;
import com.logicturtle.hackathon.R;


public class HomeFragment extends MentorFragment {

    @BindView(R.id.large_imageview)
    ImageView largeImageView;


    DrawerLayout drawerLayout;

    public HomeFragment() {

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_home;
    }

    @Override
    protected String setToolbarTitle() {
        return null;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        drawerLayout = view.findViewById(R.id.drawer);
        Dali.create(getContext()).load(R.drawable.shraddha_kapoor).blurRadius(20).downScale(4).into(largeImageView);
        drawerLayout.openDrawer(Gravity.END);
    }

    public static HomeFragment getNewInstance(){
        HomeFragment homeFragment=new HomeFragment();
        return homeFragment;
    }
}
