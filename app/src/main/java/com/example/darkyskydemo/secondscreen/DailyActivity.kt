package com.example.darkyskydemo.secondscreen

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.example.darkyskydemo.R
import com.example.darkyskydemo.adapter.DailyAdapter
import com.example.darkyskydemo.model.Datum__

class DailyActivity : AppCompatActivity(),DailyContract.View{

    private lateinit var presenter:DailyPresenter
    private lateinit var adapter:DailyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daily)
        initUI()
        presenter= DailyPresenter(this)
        presenter.requestData()
    }

    fun initUI(){
        val rv=findViewById<RecyclerView>(R.id.rv_daily)
        adapter= DailyAdapter()
        rv.layoutManager=LinearLayoutManager(this)
        rv.adapter=adapter
    }

    override fun onSuccess(dailyList: List<Datum__>) {
        adapter.setDay(dailyList)
    }
    override fun onFailure(t: Throwable) {
       Toast.makeText(this,"Error",Toast.LENGTH_LONG).show()
    }

}
