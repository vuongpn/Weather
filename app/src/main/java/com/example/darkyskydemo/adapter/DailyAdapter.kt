package com.example.darkyskydemo.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.darkyskydemo.R
import com.example.darkyskydemo.model.Datum__
import java.util.*

class DailyAdapter:RecyclerView.Adapter<DailyAdapter.MyViewHolder>() {
    private val dailyList=ArrayList<Datum__>()

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
        val itemView=LayoutInflater.from(p0.context).inflate(R.layout.dailycard,p0,false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
       return dailyList.size
    }

    override fun onBindViewHolder(p0: MyViewHolder, p1: Int) {
       val days=dailyList[p1]
        p0.bindData(days)

    }

    fun setDay(daily:List<Datum__>){
        dailyList.clear()
        dailyList.addAll(daily)
        notifyDataSetChanged()
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
       private val tempMax:TextView=itemView.findViewById(R.id.tv_temperature_max)
        private val tempMin:TextView=itemView.findViewById(R.id.tv_temperature_min)
        private val summary:TextView=itemView.findViewById(R.id.tv_summary)
        private val time:TextView=itemView.findViewById(R.id.tv_time)
        fun bindData(days:Datum__){
            val date=Date(days.time!! *1000)
            tempMin.text= days.temperatureMin.toString()
            tempMax.text=days.temperatureMax.toString()
            summary.text=days.summary
            time.text=date.toString()
        }
    }
}