package com.example.mobileapplication11.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.mobileapplication11.R
import com.example.mobileapplication11.adapters.MainViewPagerAdapter
import com.example.mobileapplication11.databinding.FragmentMainBinding
import com.example.mobileapplication11.home.HomeFragment
import com.example.mobileapplication11.home.homePosts.HomePostsFragment
import com.example.mobileapplication11.fragments.SearchFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private lateinit var viewPager: ViewPager2

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewPager()
        setupBottomNavigation()
    }

    private fun setupViewPager() {
        viewPager = binding.mainViewPager


        val fragments = listOf(
            HomePostsFragment.newInstance(),
            SearchFragment.newInstance("ExampleParameterOne", "ExampleParameterTwo"),
            HomeFragment.newInstance()
        )

        val adapter = MainViewPagerAdapter(this, fragments)
        viewPager.adapter = adapter


        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.bottomNavigationMenu.menu.getItem(position).isChecked = true
            }
        })
    }

    private fun setupBottomNavigation() {
        binding.bottomNavigationMenu.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.home -> viewPager.currentItem = 0
                R.id.search -> viewPager.currentItem = 1
                R.id.add -> {

                    viewPager.currentItem = 2
                }
                else -> false
            }
            true
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }
}
