package com.logicturtle.hackathon.Model;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatRadioButton;
import android.util.AttributeSet;

/**
 */

public class MentorRadioButton extends AppCompatRadioButton {

    private static final String LIGHT_FONT = "fonts/Ubuntu-Light.ttf";

    public MentorRadioButton(Context context) {
        super(context);
    }

    public MentorRadioButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MentorRadioButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public void setTypeface(Typeface tf) {
        super.setTypeface(tf.createFromAsset(getContext().getAssets(), LIGHT_FONT));
    }


}
