package com.logicturtle.hackathon.Activity;


//every activity will extend this activity..........except HomeActivity

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.logicturtle.hackathon.Model.MentorLightTextView;
import com.logicturtle.hackathon.R;


abstract public class MentorActivity extends MentorToolbarCustomise {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResourceID());
        LightTextView = (MentorLightTextView) findViewById(R.id.toolbar_title_regular);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        handleToolbar();
        setToolbarTitle();
        displayBackButton();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    protected void displayBackButton() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
        }
    }


}
