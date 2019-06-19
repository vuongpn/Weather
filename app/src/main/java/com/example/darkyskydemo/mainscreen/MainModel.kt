package com.example.darkyskydemo.mainscreen

import android.annotation.SuppressLint
import android.location.Location
import android.widget.Toast
import com.example.darkyskydemo.model.Weather
import com.example.darkyskydemo.network.ApiClient
import com.example.darkyskydemo.network.ApiClient.API_KEY
import com.example.darkyskydemo.network.ApiClient.lat
import com.example.darkyskydemo.network.ApiClient.long
import com.example.darkyskydemo.network.ApiInterface
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainModel : MainContract.Model {
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private val context=MainActivity.appContext
    override fun getData(onFinishedListener: MainContract.Model.OnFinishedListener) {

        val apiService = ApiClient.client!!.create(ApiInterface::class.java)

        apiService.getForecastData(API_KEY, lat, long).enqueue(object : Callback<Weather> {
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

    @SuppressLint("MissingPermission")
    override fun getLocation(onFinishedListener: MainContract.Model.OnFinishedListener) {
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)
        fusedLocationClient.lastLocation
            .addOnSuccessListener { location: Location? ->
                val LATITUDE = location?.latitude
                val LONGTITUDE = location?.longitude
                val apiLocation=ApiClient.client!!.create(ApiInterface::class.java)
                Toast.makeText(context, "$lat,$long", Toast.LENGTH_LONG).show()
             apiLocation.getForecastData(API_KEY, LATITUDE, LONGTITUDE).enqueue(object:Callback<Weather>{
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

    }

}