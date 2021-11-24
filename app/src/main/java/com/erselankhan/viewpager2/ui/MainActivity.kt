package com.erselankhan.viewpager2.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.erselankhan.viewpager2.R
import com.erselankhan.viewpager2.ui.adapter.ViewPagerAdapter
import com.erselankhan.viewpager2.ui.fragments.FirstFragment
import com.erselankhan.viewpager2.ui.fragments.ForthFragment
import com.erselankhan.viewpager2.ui.fragments.SecondFragment
import com.erselankhan.viewpager2.ui.fragments.ThirdFragment
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var viewPagerAdapter: ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.pager)

        // The pager adapter, which provides the pages to the view pager widget.
        val fragments =
            mutableListOf(
                FirstFragment(),
                SecondFragment(),
                ThirdFragment()
            )

        viewPager.offscreenPageLimit = 3
        viewPagerAdapter = ViewPagerAdapter(supportFragmentManager, fragments, lifecycle)
        viewPager.adapter = viewPagerAdapter

        refreshSecondFragmentText()
    }

    private fun refreshSecondFragmentText() {
        Handler(Looper.getMainLooper()).postDelayed({
            viewPagerAdapter.refreshFragment(1, ForthFragment())
        }, 5000)
    }
}