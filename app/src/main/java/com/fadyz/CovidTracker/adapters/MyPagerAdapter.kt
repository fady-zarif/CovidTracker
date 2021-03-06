package com.fadyz.CovidTracker.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.fadyz.CovidTracker.R
import com.fadyz.CovidTracker.activities.ANALYTICS_FRAGMENT
import com.fadyz.CovidTracker.activities.COUNTRIES_FRAGMENT
import com.fadyz.CovidTracker.fragments.AnalyticsFragment
import com.fadyz.CovidTracker.fragments.CountriesFragment

class MyPagerAdapter(fragment: FragmentActivity) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return getListFragment().size
    }


    override fun createFragment(position: Int): Fragment {
        return getListFragment()[position]

    }

    companion object {
        fun getCorrespondedFragment(menuId: Int): Int {
            return mutableMapOf(
                    R.id.home_bottom_navigation_countries to COUNTRIES_FRAGMENT,
                    R.id.home_bottom_navigation_analytics to ANALYTICS_FRAGMENT
            )[menuId]!!
        }

        fun getListFragment(): MutableList<Fragment> {
            return mutableListOf(AnalyticsFragment(), CountriesFragment())
        }
    }
}
