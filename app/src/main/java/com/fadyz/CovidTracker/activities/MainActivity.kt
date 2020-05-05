package com.fadyz.CovidTracker.activities

import android.os.Bundle
import android.view.animation.OvershootInterpolator
import android.view.animation.ScaleAnimation
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.viewpager2.widget.ViewPager2
import com.fadyz.CovidTracker.R
import com.fadyz.CovidTracker.adapters.MyPagerAdapter
import com.fadyz.CovidTracker.base.BaseActivity.BaseActivity
import com.fadyz.CovidTracker.viewModels.MainActivityViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel


const val ANALYTICS_FRAGMENT = 0
const val COUNTRIES_FRAGMENT = 1
const val FRAGMENT_TOTAL = 2

class MainActivity : BaseActivity() {

    private val mainActivityViewModel: MainActivityViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myViewPager.adapter = MyPagerAdapter(this)
        myViewPager.offscreenPageLimit = ViewPager2.OFFSCREEN_PAGE_LIMIT_DEFAULT
        myViewPager.currentItem = ANALYTICS_FRAGMENT
        myViewPager.isUserInputEnabled = false
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setIcon(R.drawable.ic_virus)


        fabBtn.setOnClickListener {
            fabBtn.customAnim()
            when (myViewPager.currentItem) {
                COUNTRIES_FRAGMENT -> mainActivityViewModel.getServerData()
                ANALYTICS_FRAGMENT -> mainActivityViewModel.getGeneralStatus()
            }
        }

        bottom_navigation_home_activity.setOnNavigationItemSelectedListener { menuItem ->
            myViewPager.currentItem = MyPagerAdapter.getCorrespondedFragment(menuItem.itemId)
            true
        }
    }

    private fun FragmentManager.inTransaction(action: FragmentTransaction.() -> Unit) {
        val fragmentTransaction = this.beginTransaction()
        fragmentTransaction.action()
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
}

fun FloatingActionButton.customAnim(): Unit {
    val anim = ScaleAnimation(0F, 1F, 0F, 1F)
    anim.fillBefore = true
    anim.fillAfter = true
    anim.isFillEnabled = true
    anim.duration = 500
    anim.interpolator = OvershootInterpolator()
    this.startAnimation(anim)
}