package com.kotlintopic.fragment


import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.kotlintopic.R
import com.kotlintopic.adapter.AirQualityAdapter
import com.kotlintopic.moudle.AirQuality
import com.lzy.okgo.OkGo
import com.lzy.okgo.callback.StringCallback
import com.lzy.okgo.cache.CacheMode
import com.lzy.okgo.model.Response
import okhttp3.Call
import java.util.*


/**
 *
 */
class DashboardFragment : Fragment() {

    private lateinit var mView : View
    private lateinit var myRecyclerView : RecyclerView
    private lateinit var myRefresh : SwipeRefreshLayout

    private var airQualityList : List<AirQuality>? = null


    companion object {

        val TAG: String = DashboardFragment::class.java.simpleName

        fun getInstance() : DashboardFragment {
            val fragment = DashboardFragment()
            return fragment
        }
    }

    override fun onCreateView(inflater: android.view.LayoutInflater?, container: android.view.ViewGroup?, savedInstanceState: android.os.Bundle?): android.view.View? {
        mView = inflater!!.inflate(com.kotlintopic.R.layout.fragment_dashboard, container, false)

        bindView()
        initParam()
        return mView
    }

    /**
     * 綁定View
     */
    private fun bindView() {
        myRecyclerView = mView.findViewById(R.id.recyclerView) as RecyclerView
        myRefresh = mView.findViewById(R.id.swipeRefresh) as SwipeRefreshLayout
    }

    /**
     * 初始化設定
     */
    private fun initParam() {

        getAirData()
    }

    /**
     * 取得資料
     */
    fun getAirData() {
        OkGo.get("http://opendata.epa.gov.tw/ws/Data/REWXQA/?%24orderby=SiteName&%24skip=0&%24top=500&format=json")
                .tag(this)
                .execute(object : StringCallback() {
                    override fun onSuccess(p0: String?, p1: Call?, p2: okhttp3.Response?) {
                        //TODO What is object
                        //http://www.kotlincn.net/docs/reference/object-declarations.html
                        val collectionType = object : TypeToken<List<AirQuality>>() {}.type
                        airQualityList = Gson().fromJson(p0,collectionType)
                        val airQualityAdapter :AirQualityAdapter = AirQualityAdapter(airQualityList!!)
                        myRecyclerView.layoutManager = LinearLayoutManager(activity)
                        myRecyclerView.adapter = airQualityAdapter
                    }
                })
    }

}
