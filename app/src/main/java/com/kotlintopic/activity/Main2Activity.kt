package com.kotlintopic.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.FragmentTransaction
import com.kotlintopic.AppConstant
import com.kotlintopic.R
import com.kotlintopic.fragment.DashboardFragment
import com.kotlintopic.fragment.HomeFragment

class Main2Activity : BaseActivity() {

    companion object {
        /**
         * 跳頁
         */
        fun IntentWithBundle(mContext : Context, account : String) : Intent {
            val bundle = android.os.Bundle()
            bundle.putString("account", account)
            val intent = Intent(mContext, Main2Activity::class.java)
            intent.putExtras(bundle)

            return intent
        }
    }


    private var dashboardFragment : DashboardFragment? = null
    private var homeFragment : HomeFragment? = null
    private var tabPosition = 0



    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.kotlintopic.R.layout.activity_main2)
        initParam()
        initFragment(savedInstanceState)

    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState!!.putInt(AppConstant.CurrentTabPosition, tabPosition)
    }

    override fun initParam() {
        val navigation = findViewById(com.kotlintopic.R.id.navigation) as BottomNavigationView
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    /**
     * 初始化 Fragment
     */
    private fun initFragment(savedInstanceState: Bundle?) {
        val trans : FragmentTransaction = supportFragmentManager.beginTransaction()
        var fragmentCurrentPosition = 0
        if (savedInstanceState != null) {
            homeFragment = supportFragmentManager.findFragmentByTag(HomeFragment.TAG) as HomeFragment?
            dashboardFragment = supportFragmentManager.findFragmentByTag(DashboardFragment.TAG) as DashboardFragment?
            fragmentCurrentPosition = savedInstanceState.getInt(AppConstant.CurrentTabPosition)
        } else {
            dashboardFragment = DashboardFragment.getInstance()
            homeFragment = HomeFragment.newInstance(intent.getStringExtra("account"))

            trans.add(R.id.main2Frame, homeFragment, HomeFragment.TAG)
            trans.add(R.id.main2Frame, dashboardFragment, DashboardFragment.TAG)
        }
        trans.commit()
        switchToFragment(fragmentCurrentPosition)
    }

    private fun switchToFragment(fragmentCurrentPosition: Int) {
        tabPosition = fragmentCurrentPosition
        val trans : FragmentTransaction = supportFragmentManager.beginTransaction()
        trans.hide(homeFragment)
        trans.hide(dashboardFragment)

        when (tabPosition) {
            0 -> {
                trans.show(homeFragment)
            }
            1 -> {
                trans.show(dashboardFragment)
            }
        }
        trans.commitAllowingStateLoss()
    }


    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                switchToFragment(0)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                switchToFragment(1)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }


}
