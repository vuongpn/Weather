package com.example.darkyskydemo.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Minutely {

    @SerializedName("summary")
    @Expose
    var summary: String? = null
    @SerializedName("icon")
    @Expose
    var icon: String? = null
    @SerializedName("data")
    @Expose
    var data: List<Datum>? = null

}