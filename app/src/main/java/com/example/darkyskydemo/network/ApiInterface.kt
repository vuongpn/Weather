package com.example.darkyskydemo.network

import com.example.darkyskydemo.model.Weather
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {

    @GET("forecast/{key}/{lat},{long}")
    fun getForecastData(
        @Path("key") key: String,
        @Path("lat") latitude: Double?,
        @Path("long") longtitude: Double?
    ): Call<Weather>
}