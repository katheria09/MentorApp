package hackathonayush.mentor.Fragments;

import android.support.v4.app.Fragment;

import hackathonayush.mentor.R;

/**
 * Created by as on 06-Sep-17.
 */

public class ViewPagerFragment extends MentorFragment {
    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_viewpager;
    }

    @Override
    protected String setToolbarTitle() {
        return null;
    }

    public static Fragment getNewInstance() {
        ViewPagerFragment viewPagerFragment = new ViewPagerFragment();
        return viewPagerFragment;
    }
}
