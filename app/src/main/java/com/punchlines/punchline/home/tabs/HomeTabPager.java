package com.punchlines.punchline.home.tabs;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.punchlines.R;
import com.punchlines.punchline.home.daily.DailyPunchlineFragment;
import com.punchlines.punchline.home.random.RandomPunchlineFragment;

public class HomeTabPager extends FragmentPagerAdapter {
    private Context context;

    public HomeTabPager(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (HomeTab.Daily.ordinal() == position)
            return new DailyPunchlineFragment();
        else if (HomeTab.Random.ordinal() == position)
            return new RandomPunchlineFragment();

        throw new IllegalArgumentException("HomeTab index is out of range " + position);
    }

    @Override
    public int getCount() {
        return HomeTab.values().length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (HomeTab.Daily.ordinal() == position)
            return context.getResources().getString(R.string.daily);
        else if (HomeTab.Random.ordinal() == position)
            return context.getResources().getString(R.string.random);

        throw new IllegalArgumentException("HomeTab index is out of range " + position);
    }

}