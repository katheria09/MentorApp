package com.logicturtle.hackathon.Activity;

import android.support.v4.app.Fragment;

import com.logicturtle.hackathon.Fragments.SignupFragment;
import com.logicturtle.hackathon.R;



public class SignUpActivity extends MentorSingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return SignupFragment.getNewInstance();
    }

    @Override
    protected int getContainerID() {
        return R.id.container;
    }

    @Override
    protected boolean visibleToolBar() {
        return false;
    }

    @Override
    protected int getLayoutResourceID() {
        return R.layout.activity_main;
    }

    @Override
    protected String setTitleForToolbar() {
        return null;
    }
}
