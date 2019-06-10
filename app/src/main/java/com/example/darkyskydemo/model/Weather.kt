package com.example.darkyskydemo.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Weather {

    @SerializedName("latitude")
    @Expose
    var latitude: Double? = null
    @SerializedName("longitude")
    @Expose
    var longitude: Double? = null
    @SerializedName("timezone")
    @Expose
    var timezone: String? = null
    @SerializedName("currently")
    @Expose
    var currently: Currently? = null
    @SerializedName("minutely")
    @Expose
    var minutely: Minutely? = null
    @SerializedName("hourly")
    @Expose
    var hourly: Hourly? = null
    @SerializedName("daily")
    @Expose
    var daily: Daily? = null
    @SerializedName("alerts")
    @Expose
    var alerts: List<Alert>? = null
    @SerializedName("flags")
    @Expose
    var flags: Flags? = null
    @SerializedName("offset")
    @Expose
    var offset: Int? = null

}