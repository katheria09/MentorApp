package com.logicturtle.hackathon.Model;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 */


//use this view for complete app.........

public class MentorMediumTextView extends AppCompatTextView {
    private static final String MEDIUM_FONT = "fonts/Ubuntu-Medium.ttf";

    public MentorMediumTextView(Context context) {
        super(context);
    }

    public MentorMediumTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MentorMediumTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setTypeface(Typeface tf) {
        super.setTypeface(tf.createFromAsset(getContext().getAssets(), MEDIUM_FONT));
    }


}
