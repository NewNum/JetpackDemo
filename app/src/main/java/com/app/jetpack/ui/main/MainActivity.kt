package com.app.jetpack.ui.main

import android.view.LayoutInflater
import com.app.baselib.base.activity.BaseActivity
import com.app.jetpack.R
import com.app.baselib.base.activity.BaseViewBindingActivity
import com.app.jetpack.databinding.ActivityMainBinding
import com.app.jetpack.ui.gallery.GalleryFragment
import com.app.jetpack.ui.home.HomeFragment
import com.app.jetpack.ui.slideshow.SlideshowFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : BaseActivity() {
    private val fragments by lazy {
        listOf(
            HomeFragment(),
            GalleryFragment(),
            SlideshowFragment()
        )
    }

    override fun onViewCreate() {

        supportFragmentManager.beginTransaction()
            .add(R.id.fl_container,fragments[2])
            .hide(fragments[2])
            .add(R.id.fl_container,fragments[1])
            .hide(fragments[1])
            .add(R.id.fl_container,fragments[0])
            .commitNow()
        findViewById<BottomNavigationView>(R.id.main_bottom_nav)?.setOnNavigationItemSelectedListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fl_container,
                    fragments[
                            when (it.itemId) {
                                R.id.nav_home -> {
                                    0
                                }
                                R.id.nav_gallery -> {
                                    1
                                }
                                R.id.nav_slideshow -> {
                                    2
                                }
                                else -> {
                                    0
                                }
                            }
                    ]
                )
                .commitNowAllowingStateLoss()
            true
        }
    }


    override fun layoutId(): Int {
        return R.layout.activity_main
    }
}
