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

    @Suppress("UNCHECKED_CAST")
    private fun <T> lazyExtra(name: String, defaultValue: T): Lazy<T> {
        return lazy {
            //利用defaultValue 來判斷型別
            when(defaultValue){
                is String -> intent.getStringExtra(name) as T ?: defaultValue
                is Int -> intent.getIntExtra(name, defaultValue) as T
                is Boolean -> intent.getBooleanExtra(name, defaultValue) as T
                else -> throw IllegalArgumentException("wrong type")
            }
        }
    }


}