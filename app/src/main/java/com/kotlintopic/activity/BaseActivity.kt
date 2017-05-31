package com.kotlintopic.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * 功能
 */
abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    abstract fun initParam()

}