package com.punchlines.punchline.tabs;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.punchlines.R;
import com.punchlines.punchline.daily.DailyPunchlineFragment;
import com.punchlines.punchline.random.RandomPunchlineFragment;

public class TabsPager extends FragmentPagerAdapter {
    private Context context;

    public TabsPager(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (Tab.Daily.ordinal() == position)
            return new DailyPunchlineFragment();
        else if (Tab.Random.ordinal() == position)
            return new RandomPunchlineFragment();

        throw new IllegalArgumentException("Tab index is out of range " + position);
    }

    @Override
    public int getCount() {
        return Tab.values().length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (Tab.Daily.ordinal() == position)
            return context.getResources().getString(R.string.daily);
        else if (Tab.Random.ordinal() == position)
            return context.getResources().getString(R.string.random);

        throw new IllegalArgumentException("Tab index is out of range " + position);
    }

}