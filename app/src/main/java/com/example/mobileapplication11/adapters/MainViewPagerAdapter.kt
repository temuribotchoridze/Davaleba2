package com.example.mobileapplication11.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.mobileapplication11.fragments.SearchFragment

class MainViewPagerAdapter(fragment: Fragment, private val fragments: List<Fragment>) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment {
        val fragment = fragments[position]


        if (fragment is SearchFragment) {

            return SearchFragment.newInstance("ExampleParam1", "ExampleParam2")
        }


        return fragment
    }
}
