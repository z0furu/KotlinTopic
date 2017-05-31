package com.kotlintopic

import android.app.Application
import com.lzy.okgo.OkGo

/**
 * 功能
 */
class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        OkGo.init(this)
    }
}