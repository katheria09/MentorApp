package com.logicturtle.hackathon.Model;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 */


//use this view for complete app.........

public class MentorBoldTextView extends AppCompatTextView {
    private static final String BOLD_FONT = "fonts/Ubuntu-Bold.ttf";

    public MentorBoldTextView(Context context) {
        super(context);
    }

    public MentorBoldTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MentorBoldTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setTypeface(Typeface tf) {
        super.setTypeface(tf.createFromAsset(getContext().getAssets(), BOLD_FONT));
    }
}
