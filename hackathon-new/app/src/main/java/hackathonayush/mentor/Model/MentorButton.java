package hackathonayush.mentor.Model;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

/**
 * Created by user on 02-Sep-17.
 */

public class MentorButton extends AppCompatButton {
    private static final String MEDIUM_FONT="fonts/Ubuntu-Medium.ttf";

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
