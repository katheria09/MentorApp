package hackathonayush.mentor.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import hackathonayush.mentor.Fragments.SignupFragment;
import hackathonayush.mentor.Fragments.TrendingQuestionsFragment;
import hackathonayush.mentor.Fragments.YourQuestionFragment;

/**
 * Created by as on 06-Sep-17.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    final int PAGE_COUNT = 2;
    private String tabTitles[] = new String[]{"Trending Question", "Your Question"};

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }


    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment;
        if (position == 0)
            fragment = new TrendingQuestionsFragment();
        else
            fragment = YourQuestionFragment.getNewInstance();
        return fragment;
    }

}
