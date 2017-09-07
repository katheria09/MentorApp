package com.logicturtle.hackathon.Activity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;

import com.logicturtle.hackathon.Model.MentorLightTextView;
import com.logicturtle.hackathon.R;


abstract public class MentorSingleFragmentActivity extends MentorActivity {

    protected abstract Fragment createFragment();

    protected abstract int getContainerID();

    protected abstract boolean visibleToolBar();

    private int container;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getLayoutResourceID() == 0) {
            container=R.id.container;
            setContentView(R.layout.activity_main);
        }
        else {
            container=getContainerID();
            setContentView(getLayoutResourceID());
        }
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
                | WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE
                | WindowManager.LayoutParams.SOFT_INPUT_STATE_UNCHANGED);
        a2doodhLightTextView = (MentorLightTextView) findViewById(R.id.toolbar_title_regular);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setVisibility(View.GONE);
        if (visibleToolBar()) {
            toolbar.setVisibility(View.VISIBLE);
            handleToolbar();
            setToolbarTitle();
        }
        displayBackButton();
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(getContainerID());
        if (fragment == null) {
            fragment = createFragment();
            fm.beginTransaction()
                    .add(container, fragment)
                    .commit();
        }
    }


}
