package com.example.darkyskydemo.secondscreen

import com.example.darkyskydemo.model.Weather
import com.example.darkyskydemo.network.ApiClient
import com.example.darkyskydemo.network.ApiClient.API_KEY
import com.example.darkyskydemo.network.ApiClient.latitude
import com.example.darkyskydemo.network.ApiClient.longtitude
import com.example.darkyskydemo.network.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DailyModel:DailyContract.Model {
    override fun getData(OnFinishedListener: DailyContract.Model.OnFinishedListener) {
       val apiService=ApiClient.client!!.create(ApiInterface::class.java)

        apiService.getForecastData(API_KEY, latitude, longtitude).enqueue(object : Callback<Weather>{
            override fun onFailure(call: Call<Weather>, t: Throwable) {
               OnFinishedListener.onFailure(t)
            }

            override fun onResponse(call: Call<Weather>, response: Response<Weather>) {
               val dailyList= response.body()!!.daily!!.data
                OnFinishedListener.onSuccess(dailyList!!)
            }
        })
    }
}