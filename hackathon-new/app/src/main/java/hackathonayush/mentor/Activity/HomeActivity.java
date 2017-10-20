package hackathonayush.mentor.Activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hackathonayush.mentor.Fragments.ForumFragment;
import hackathonayush.mentor.Fragments.GetMentorFragment;
import hackathonayush.mentor.Fragments.HomeFragment;
import hackathonayush.mentor.Fragments.InviteFragment;
import hackathonayush.mentor.Fragments.LoginFragment;
import hackathonayush.mentor.Fragments.ProfileFragment;
import hackathonayush.mentor.Fragments.ViewPagerFragment;
import hackathonayush.mentor.R;
import hackathonayush.mentor.Utils.SharedPrefs;
import nl.psdcompany.duonavigationdrawer.views.DuoDrawerLayout;
import nl.psdcompany.duonavigationdrawer.widgets.DuoDrawerToggle;


public class HomeActivity extends MentorToolbarCustomise {
    private ViewHolder mViewHolder;
    private String title = "Home", title1;
    FragmentManager fragmentManager;






    @Override
    protected int getLayoutResourceID() {
        return R.layout.activity_home;
    }

    @Override
    protected String setTitleForToolbar() {
        return title;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        fragmentManager = getSupportFragmentManager();
        ScrollView scrollView = (ScrollView) findViewById(R.id.scroll_view);
        scrollView.setVerticalScrollbarPosition(View.SCROLLBAR_POSITION_LEFT);
        mViewHolder = new ViewHolder();
        goToFragment(HomeFragment.getNewInstance(), false, R.id.container);
        Toolbar();
        handleDrawer();
        title = getToolbarTitle(R.id.home);
        restoreViewsColor(R.id.linear_lout);
        setToolbarTitle();
        changeTintColor(R.id.home);
    }

    private void Toolbar() {
        setSupportActionBar(mViewHolder.mToolbar);
    }

    private void handleDrawer() {
        DuoDrawerToggle duoDrawerToggle = new DuoDrawerToggle(this,
                mViewHolder.mDuoDrawerLayout,
                mViewHolder.mToolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        mViewHolder.mDuoDrawerLayout.setDrawerListener(duoDrawerToggle);
        duoDrawerToggle.syncState();
    }


    public static Intent getNewInstance(Context context) {
        Intent intent = new Intent(context, HomeActivity.class);
        return intent;

    }


    @OnClick(R.id.home)
    public void home() {
        replaceFragment(HomeFragment.getNewInstance(), false, R.id.container);
        title = getToolbarTitle(R.id.home);
        restoreViewsColor(R.id.linear_lout);
        setToolbarTitle();
        changeTintColor(R.id.home);
        closeDrawer();
    }

    @OnClick(R.id.my_profile)
    public void profile() {
        title = getToolbarTitle(R.id.my_profile);
        restoreViewsColor(R.id.linear_lout);
        setToolbarTitle();
        changeTintColor(R.id.my_profile);
        closeDrawer();
        replaceFragment(ProfileFragment.getNewInstance(SharedPrefs.getID(this)),false,R.id.container);


    }

    @OnClick(R.id.members)
    public void members() {
        title = getToolbarTitle(R.id.members);
        restoreViewsColor(R.id.linear_lout);
        setToolbarTitle();
        changeTintColor(R.id.members);
        closeDrawer();
        replaceFragment(GetMentorFragment.getNewInstance(),false,R.id.container);

    }

    @OnClick(R.id.invites)
    public void invites() {
        replaceFragment(InviteFragment.getNewInstance(), false, R.id.container);
        title = getToolbarTitle(R.id.invites);
        restoreViewsColor(R.id.linear_lout);
        setToolbarTitle();
        changeTintColor(R.id.invites);
        closeDrawer();
    }

//    @OnClick(R.id.notification)
//    public void notification() {
//        title = getToolbarTitle(R.id.notification);
//        restoreViewsColor(R.id.linear_lout);
//        setToolbarTitle();
//        changeTintColor(R.id.notification);
//        closeDrawer();
//    }

    @OnClick(R.id.share)
    public void share() {
        title = getToolbarTitle(R.id.share);
        restoreViewsColor(R.id.linear_lout);
        setToolbarTitle();
        changeTintColor(R.id.share);
        closeDrawer();
    }




    @OnClick(R.id.logout)
    public void delete_account() {
        title = getToolbarTitle(R.id.logout);
        restoreViewsColor(R.id.linear_lout);
        setToolbarTitle();
        changeTintColor(R.id.logout);
        closeDrawer();
    }

    private void goToFragment(Fragment fragment, boolean addToBackStack, int container) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        if (addToBackStack) {
            transaction.addToBackStack(null);
        }
        if (fragmentManager.findFragmentById(R.id.container) == null) {
            transaction.add(container, fragment).commit();
        }
    }

    private void replaceFragment(Fragment fragment, boolean addToBackStack, int container) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        if (addToBackStack) {
            transaction.addToBackStack(null);
        }
        if (fragmentManager.findFragmentById(R.id.container) != null) {
            transaction.replace(container, fragment).commit();
        }
    }

    private void closeDrawer() {
        mViewHolder.mDuoDrawerLayout.closeDrawer();
    }


    private void changeTintColor(int resID) {
        View view;
        LinearLayout linearLayout = (LinearLayout) findViewById(resID);
        for (int i = 0; i < linearLayout.getChildCount(); i++) {
            view = linearLayout.getChildAt(i);
            if (view instanceof TextView) {
                int a = ((TextView) view).getCurrentTextColor();
                String hexColor = String.format("#%06X", (0xFFFFFF & a));
                Log.d("ayush","hex: "+hexColor);

                if (hexColor.equals("#000000")) {
                    ((TextView) view).setTextColor(getResources().getColor(R.color.select));
                }

            }
            if (view instanceof ImageView) {
                ((ImageView) view).setColorFilter(ContextCompat.getColor(view.getContext(), R.color.select));
            }
        }
    }

    private String getToolbarTitle(int resID) {

        LinearLayout linearLayout = (LinearLayout) findViewById(resID);
        for (int i = 0; i < linearLayout.getChildCount(); i++) {
            View view = linearLayout.getChildAt(i);
            if (view instanceof TextView) {
                title1 = ((TextView) view).getText().toString();
            }
        }
        return title1;
    }

    private void restoreViewsColor(int resID) {
        LinearLayout llout = (LinearLayout) findViewById(resID);
        int a = llout.getChildCount();
        for (int i = 0; i < a; i++) {
            View v = llout.getChildAt(i);
            if (v instanceof LinearLayout) {
                for (int j = 0; j < ((LinearLayout) v).getChildCount(); j++) {
                    View view = ((LinearLayout) v).getChildAt(j);
                    if (view instanceof TextView) {
                        String text = ((TextView) view).getText().toString();
                        if (!text.equals(title)) {
                            ((TextView) view).setTextColor(Color.parseColor("#000000"));
                        }
                    }
                    if (view instanceof ImageView) {
                        ((ImageView) view).setColorFilter(ContextCompat.getColor(view.getContext(), R.color.black));
                    }

                }
            }
        }
    }


    private class ViewHolder {
        private DuoDrawerLayout mDuoDrawerLayout;
        private Toolbar mToolbar;

        ViewHolder() {
            mDuoDrawerLayout = (DuoDrawerLayout) findViewById(R.id.drawer);
            mToolbar = (Toolbar) findViewById(R.id.toolbar);
        }
    }

}
