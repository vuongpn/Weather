package com.example.darkyskydemo.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    const val API_KEY = "984d7457ecd1924ea3401a96fc276b39"
    const val latitude = 37.8267
    const val longtitude = -122.4233
    private val BASE_URL = "https://api.darksky.net/"
    private var retrofit: Retrofit? = null

    val client: Retrofit?
        get() {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit
        }
}