package hackathonayush.mentor.Activity;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import hackathonayush.mentor.Fragments.ForumFragment;
import hackathonayush.mentor.Fragments.LoginFragment;
import hackathonayush.mentor.R;

public class LoginActivity extends MentorSingleFragmentActivity {


    @Override
    protected Fragment createFragment() {
        return LoginFragment.getNewInstance();
    }

    @Override
    protected int getContainerID() {
        return R.id.container;
    }

    @Override
    protected boolean visibleToolBar() {
        return false;
    }

    @Override
    protected int getLayoutResourceID() {
        return R.layout.activity_main;
    }

    @Override
    protected String setTitleForToolbar() {
        return null;
    }
}
