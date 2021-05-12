package com.viet.exerciseui2

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class ViewPagerAdapter(fm: FragmentManager, behavior: Int) :
    FragmentStatePagerAdapter(fm, behavior) {

    override fun getCount(): Int {
        return 4
    }

    override fun getItem(position: Int): Fragment {
        when(position) {
            0 -> {
                return HomeFragment()
            }
            1 -> {
                return CoinFragment()
            }
            2 -> {
                return NewsFragment()
            }
            3 -> {
                return MenuFragment()
            }
        }
        return HomeFragment()
    }

}