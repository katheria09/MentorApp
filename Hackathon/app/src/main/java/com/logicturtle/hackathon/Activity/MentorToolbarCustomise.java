package com.logicturtle.hackathon.Activity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;

import com.logicturtle.hackathon.Model.MentorLightTextView;
import com.logicturtle.hackathon.R;


abstract public class MentorToolbarCustomise extends AppCompatActivity {

    public Toolbar toolbar;
    public MentorLightTextView LightTextView;

    abstract protected int getLayoutResourceID();

    abstract protected String setTitleForToolbar();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResourceID());
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
                | WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE
                | WindowManager.LayoutParams.SOFT_INPUT_STATE_UNCHANGED);
        LightTextView = (MentorLightTextView) findViewById(R.id.toolbar_title_regular);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        handleToolbar();
        setToolbarTitle();
    }


    protected void handleToolbar() {
        setSupportActionBar(toolbar);
    }

    protected void setToolbarTitle() {
        if (LightTextView != null) {
            LightTextView.setText(setTitleForToolbar());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_overflow, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }


}
