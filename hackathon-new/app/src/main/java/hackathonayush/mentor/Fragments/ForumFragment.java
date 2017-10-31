package hackathonayush.mentor.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.astuetz.PagerSlidingTabStrip;

import hackathonayush.mentor.Adapter.ViewPagerAdapter;
import hackathonayush.mentor.R;

/**
 * Created by as on 06-Sep-17.
 */

public class ForumFragment extends MentorFragment {
    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_viewpager;
    }

    @Override
    protected String setToolbarTitle() {
        return null;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ViewPager viewpager = view.findViewById(R.id.viewpager);
        viewpager.setAdapter(new ViewPagerAdapter(getChildFragmentManager()));

        PagerSlidingTabStrip tabsStrip = view.findViewById(R.id.tabs);
        tabsStrip.setViewPager(viewpager);
    }

    public static Fragment getNewInstance() {
        Fragment fragment = new ForumFragment();
        return fragment;
    }
}

