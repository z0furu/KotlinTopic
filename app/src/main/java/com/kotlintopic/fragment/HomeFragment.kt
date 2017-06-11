package com.kotlintopic.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kotlintopic.R
import kotlinx.android.synthetic.main.fragment_home.*


/**
 *
 */
class HomeFragment : Fragment() {

    companion object {
        private val NAME = "name"
        val TAG:String = HomeFragment::class.java.simpleName

        fun newInstance(name: String): HomeFragment {
            val fragment = HomeFragment()
            val args = Bundle()
            args.putString(NAME, name)
            fragment.arguments = args
            return fragment
        }
    }

    /**
     * Google Account Name
     */
    private var mName: String? = null


    /**
     * Fragment View
     */
    private var mView : View? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            mName = arguments.getString(NAME)
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mView =  inflater!!.inflate(R.layout.fragment_home, container, false)


        return mView
    }

    override fun onStart() {
        super.onStart()
        initView()
    }

    private fun initView() {
       txt_account.text = mName
    }


}
