package com.kotlintopic

import android.app.Activity
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.PopupWindow
import android.widget.TextView

/**
 * 功能
 */

class ProgressWindow(a: Activity, private val parentView: View) : PopupWindow() {
    private var isReadyToDismiss = false
    private var messageText: TextView? = null


    init {
        setPopupWindow(a)
    }


    private fun setPopupWindow(activity: Activity) {
        val view = activity.layoutInflater.inflate(R.layout.window_progress, null)
        messageText = view.findViewById(R.id.message_text) as TextView

        contentView = view

        height = ViewGroup.LayoutParams.MATCH_PARENT
        width = ViewGroup.LayoutParams.MATCH_PARENT
        isFocusable = true
        isTouchable = true
        isOutsideTouchable = false

        setBackgroundDrawable(BitmapDrawable(activity.resources, Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888)))
    }

    fun show() {
        messageText!!.visibility = View.GONE
        showAtLocation(parentView, Gravity.NO_GRAVITY, 0, 0)
    }

    fun showMessage(message: String) {
        messageText!!.text = message
        messageText!!.visibility = View.VISIBLE
        showAtLocation(parentView, Gravity.NO_GRAVITY, 0, 0)
    }

    /**
     * 為了不讓back鍵去關閉window，所以多這一層
     */
    fun dismissWindow() {
        isReadyToDismiss = true
        dismiss()
    }

    override fun dismiss() {
        if (isReadyToDismiss) {
            super.dismiss()
            isReadyToDismiss = false
        }
    }
}
