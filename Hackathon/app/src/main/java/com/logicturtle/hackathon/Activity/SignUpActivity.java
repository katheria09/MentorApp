package com.logicturtle.hackathon.Activity;

import android.support.v4.app.Fragment;

import com.logicturtle.hackathon.Fragments.GetMentorFragment;
import com.logicturtle.hackathon.R;

/**
 * Created by kunwar on 7/9/17.
 */

public class SignUpActivity extends MentorSingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return GetMentorFragment.getNewInstance();
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
