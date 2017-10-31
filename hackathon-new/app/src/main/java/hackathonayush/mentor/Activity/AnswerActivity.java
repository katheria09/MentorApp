package hackathonayush.mentor.Activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import hackathonayush.mentor.Fragments.AnswerFragment;
import hackathonayush.mentor.R;

public class AnswerActivity extends MentorSingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        Intent intent = getIntent();
        return AnswerFragment.getNewInstance(intent.getStringExtra("question"), intent.getStringExtra("id"));
    }

    @Override
    protected int getContainerID() {
        return R.id.container;
    }

    @Override
    protected boolean visibleToolBar() {
        return true;
    }

    @Override
    protected int getLayoutResourceID() {
        return R.layout.activity_main;
    }

    @Override
    protected String setTitleForToolbar() {
        return "Answers";
    }

    public static Intent getNewInstance(Context context, String question, String quesID) {
        Intent intent = new Intent(context, AnswerActivity.class);
        intent.putExtra("question", question);
        intent.putExtra("id", quesID);
        return intent;
    }

}
