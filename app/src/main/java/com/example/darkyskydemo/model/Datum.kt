package com.example.darkyskydemo.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Datum {

    @SerializedName("time")
    @Expose
    var time: Int? = null
    @SerializedName("precipIntensity")
    @Expose
    var precipIntensity: Int? = null
    @SerializedName("precipProbability")
    @Expose
    var precipProbability: Int? = null

}