package com.example.darkyskydemo.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Alert {

    @SerializedName("title")
    @Expose
    var title: String? = null
    @SerializedName("regions")
    @Expose
    var regions: List<String>? = null
    @SerializedName("severity")
    @Expose
    var severity: String? = null
    @SerializedName("time")
    @Expose
    var time: Int? = null
    @SerializedName("expires")
    @Expose
    var expires: Int? = null
    @SerializedName("description")
    @Expose
    var description: String? = null
    @SerializedName("uri")
    @Expose
    var uri: String? = null

}