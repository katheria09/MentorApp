package com.logicturtle.hackathon.Model;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

/**
 */

public class MentorButton extends AppCompatButton {
    private static final String MEDIUM_FONT = "fonts/Ubuntu-Medium.ttf";

    public MentorButton(Context context) {
        super(context);
    }

    public MentorButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MentorButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setTypeface(Typeface tf) {
        super.setTypeface(tf.createFromAsset(getContext().getAssets(), MEDIUM_FONT));
    }
}
