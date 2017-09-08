package hackathonayush.mentor.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

/**
 * Created by user on 02-Sep-17.
 */

public class MentorDetailFragment extends MentorFragment {

    public MentorDetailFragment(){

    }

    @Override
    protected int getLayoutResId() {
        return 0;
    }

    @Override
    protected String setToolbarTitle() {
        return null;
    }

    public static MentorDetailFragment getNewInstance(){
        MentorDetailFragment mentorDetailFragment=new MentorDetailFragment();
        return mentorDetailFragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
