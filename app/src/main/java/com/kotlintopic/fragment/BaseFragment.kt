package com.kotlintopic.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import com.kotlintopic.ProgressWindow



/**
 * 功能
 */

abstract class BaseFragment : Fragment() {

    private var progressWindow : ProgressWindow? = null

    fun showWindow(mView: View) {
        if (progressWindow == null) {
            progressWindow = ProgressWindow(activity, mView)
            mView.post { progressWindow!!.show() }
        }
    }

    fun dismissWindow() {
        if (progressWindow!!.isShowing) {
            progressWindow!!.dismissWindow()
            progressWindow = null
        }
    }


}
