package hackathonayush.mentor.Activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.widget.ImageView;

/**
 * Created by user on 02-Sep-17.
 */

public class MentorDetailActivity extends MentorSingleFragmentActivity {

    @Override
    protected int getLayoutResourceID() {
        return 0;
    }

    @Override
    protected String setTitleForToolbar() {
        return "Mentor Name";
    }

    @Override
    protected Fragment createFragment() {
        return null;
    }

    @Override
    protected int getContainerID() {
        return 0;
    }

    @Override
    protected boolean visibleToolBar() {
        return true;
    }

    public static Intent getNewInstance(Context context){
        Intent intent=new Intent(context,MentorDetailActivity.class);
        return intent;
    }
}
