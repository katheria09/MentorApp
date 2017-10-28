package hackathonayush.mentor.Model;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * Created by user on 13-Jun-17.
 */

//use this view for complete app.........


public class MentorRegularTextView extends AppCompatTextView {

    private static final String REGULAR_FONT="fonts/Ubuntu-Regular.ttf";

    public MentorRegularTextView(Context context) {
        super(context);
    }

    public MentorRegularTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MentorRegularTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setTypeface(Typeface tf) {
        super.setTypeface(tf.createFromAsset(getContext().getAssets(),REGULAR_FONT));

    }
}
