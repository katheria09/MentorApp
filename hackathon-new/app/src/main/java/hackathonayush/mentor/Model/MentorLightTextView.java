package hackathonayush.mentor.Model;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * Created by user on 13-Jun-17.
 */

public class MentorLightTextView extends AppCompatTextView {

    //use this view for complete app.........


    private static final String LIGHT_FONT = "fonts/Ubuntu-Light.ttf";

    public MentorLightTextView(Context context) {
        super(context);
    }

    public MentorLightTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MentorLightTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setTypeface(Typeface tf) {
        super.setTypeface(tf.createFromAsset(getContext().getAssets(), LIGHT_FONT));
    }

}