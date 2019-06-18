package com.example.darkyskydemo.mainscreen

import android.content.Context
import android.location.LocationManager
import android.support.v4.content.ContextCompat.getSystemService
import com.example.darkyskydemo.model.Weather
import com.example.darkyskydemo.network.ApiClient
import com.example.darkyskydemo.network.ApiClient.API_KEY
import com.example.darkyskydemo.network.ApiClient.latitude
import com.example.darkyskydemo.network.ApiClient.longtitude
import com.example.darkyskydemo.network.ApiInterface
import com.google.android.gms.location.LocationServices
import com.mapbox.api.geocoding.v5.MapboxGeocoding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainModel : MainContract.Model {

    override fun getData(onFinishedListener: MainContract.Model.OnFinishedListener) {

        val apiService = ApiClient.client!!.create(ApiInterface::class.java)

        apiService.getForecastData(API_KEY, latitude, longtitude).enqueue(object : Callback<Weather> {
            override fun onFailure(call: Call<Weather>, t: Throwable) {
                onFinishedListener.onFailure(t)
            }

            override fun onResponse(call: Call<Weather>, response: Response<Weather>) {
                assert(response.body() != null)
                val weather = response.body()
                onFinishedListener.onSuccess(weather!!)
            }

        })
    }

    override fun getLocation() {

    }

}