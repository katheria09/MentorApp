package hackathonayush.mentor.Fragments;

import android.support.v4.app.Fragment;

import hackathonayush.mentor.R;

/**
 * Created by as on 07-Sep-17.
 */

public class NoDataFragment extends MentorFragment {
    @Override
    protected int getLayoutResId() {
        return R.layout.nodata_fragment;
    }

    @Override
    protected String setToolbarTitle() {
        return null;
    }

    public static Fragment getNewInstance() {
        NoDataFragment noDataFragment = new NoDataFragment();
        return noDataFragment;
    }

}
