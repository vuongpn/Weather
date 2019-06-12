package com.example.darkyskydemo.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Datum__{

    @SerializedName("time")
    @Expose
    var time: Long? = null
    @SerializedName("summary")
    @Expose
    var summary: String? = null
    @SerializedName("temperatureMin")
    @Expose
    var temperatureMin: Double? = null
    @SerializedName("temperatureMax")
    @Expose
    var temperatureMax: Double? = null
}