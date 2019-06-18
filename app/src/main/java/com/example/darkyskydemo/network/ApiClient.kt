package com.example.darkyskydemo.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    const val API_KEY = "c80337143656a0bd04d334e09dd5d5d7"
    const val lat =37.8267
    const val long =-122.4233
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