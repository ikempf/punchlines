package com.punchlines.punchline.home.tabs

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

import com.punchlines.R
import com.punchlines.punchline.home.daily.DailyPunchlineFragment
import com.punchlines.punchline.home.random.RandomPunchlineFragment

class HomeTabPager(fm: FragmentManager, private val context: Context) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment =
        when(position) {
            HomeTab.Daily.ordinal -> DailyPunchlineFragment()
            HomeTab.Random.ordinal -> RandomPunchlineFragment()
            else -> outOfRangeError(position)
        }

    override fun getCount(): Int =
        HomeTab.values().size

    override fun getPageTitle(position: Int): CharSequence  =
        when(position) {
            HomeTab.Daily.ordinal -> context.resources.getString(R.string.daily)
            HomeTab.Random.ordinal -> context.resources.getString(R.string.random)
            else -> outOfRangeError(position)
        }

    private fun outOfRangeError(position: Int): Nothing =
        throw IllegalArgumentException("HomeTab index is out of range " + position)

}