package com.example.darkyskydemo.network

import com.example.darkyskydemo.model.Weather
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {

    @GET("forecast/{key}/{latitude},{longtitude}")
    fun getForecastData(
        @Path("key") key: String,
        @Path("latitude") latitude: Double,
        @Path("longtitude") longtitude: Double
    ): Call<Weather>
}