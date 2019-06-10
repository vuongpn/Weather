package com.example.darkyskydemo.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Flags {

    @SerializedName("sources")
    @Expose
    var sources: List<String>? = null
    @SerializedName("nearest-station")
    @Expose
    var nearestStation: Double? = null
    @SerializedName("units")
    @Expose
    var units: String? = null

}
