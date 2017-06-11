package com.kotlintopic.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.kotlintopic.R
import com.kotlintopic.moudle.AirQuality

/**
 * 功能
 */
class AirQualityAdapter(val data : List<AirQuality>) : RecyclerView.Adapter<AirQualityAdapter.MyViewHolder>() {

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(myViewHolder: MyViewHolder?, position: Int) {
        val newsContainer = data[position]
        if (myViewHolder != null) {
            myViewHolder.txtCountry.text = newsContainer.county
            myViewHolder.txtSitName.text = newsContainer.siteName
            myViewHolder.txtStatus.text = newsContainer.status
        }

    }

    override fun onCreateViewHolder(p0: ViewGroup?, p1: Int): MyViewHolder {
        val mView = LayoutInflater.from(p0!!.context).inflate(R.layout.item_air_quality, p0, false)

        return MyViewHolder(mView)
    }


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtCountry : TextView = itemView.findViewById(R.id.txtCounty) as TextView
        var txtSitName : TextView = itemView.findViewById(R.id.txtSiteName) as TextView
        var txtStatus : TextView = itemView.findViewById(R.id.txtStatus) as TextView
    }
}