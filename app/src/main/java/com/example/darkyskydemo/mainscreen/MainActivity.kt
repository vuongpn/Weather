package com.example.darkyskydemo.mainscreen

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.location.Location
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.darkyskydemo.R
import com.example.darkyskydemo.databinding.MainscreenBinding
import com.example.darkyskydemo.model.Weather
import com.example.darkyskydemo.network.ApiClient.lat
import com.example.darkyskydemo.network.ApiClient.long
import com.example.darkyskydemo.secondscreen.DailyActivity
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity(), MainContract.View {

    private lateinit var tv1: TextView
    private lateinit var tv2: TextView
    private lateinit var tv3: TextView
    private lateinit var tv4: TextView
    private lateinit var tv5: TextView
    private lateinit var tv6: TextView
    private lateinit var tv7: TextView
    private lateinit var tv8: TextView
    private lateinit var tv10: TextView
    private lateinit var layout: SwipeRefreshLayout
    private lateinit var image: ImageView
    private lateinit var currentimg: ImageView
    lateinit var binding:MainscreenBinding
    private var presenter: MainPresenter? = null
    companion object {
        lateinit  var appContext: Context
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this, R.layout.mainscreen)
        initUI()
        appContext = applicationContext
        presenter = MainPresenter(this)
        presenter!!.requestData()
    }

    @SuppressLint("MissingPermission")
    private fun initUI() {
        tv1 = findViewById(R.id.forecastCurrentTemperatureTxt)
        tv2 = findViewById(R.id.humidiyTxt)
        tv3 = findViewById(R.id.dewPointTxt)
        tv4 = findViewById(R.id.pressureTtxt)
        tv5 = findViewById(R.id.windSpeedTxt)
        tv6 = findViewById(R.id.uvIndexTxt)
        tv7 = findViewById(R.id.chanceOfRainTtxt)
        tv8 = findViewById(R.id.forecastSummaryTxt)
        tv10 = findViewById(R.id.localityTimeTxt)
        layout = findViewById(R.id.swiperefresh)
        image = findViewById(R.id.forecastIcon)
        currentimg = findViewById(R.id.img)
        currentimg.setOnClickListener {
           presenter!!.requestLocation()
        }
    }

    override fun onFailure(t: Throwable) {
        Toast.makeText(this, "Error", Toast.LENGTH_LONG).show()
    }

    override fun onSucess(weather: Weather) {
        val celcius = ((weather.currently!!.temperature!! - 32) / 1.8)
            .toInt().toString() +
                resources.getString(R.string.doC)
        val date = Date(weather.currently!!.time!! * 1000)
        tv1.text = celcius
        tv1.setOnClickListener {
            val i = Intent(this, DailyActivity::class.java)
            startActivity(i)
        }
        tv2.text = weather.currently!!.humidity.toString()
        tv3.text = weather.currently!!.dewPoint.toString()
        tv4.text = weather.currently!!.pressure.toString()
        tv5.text = weather.currently!!.windSpeed.toString()
        tv6.text = weather.currently!!.uvIndex.toString()
        tv7.text = weather.currently!!.cloudCover!!
            .toDouble().toString()
        tv8.text = weather.currently!!.summary
        binding.localityNameTxt.text=weather.timezone
        val dateFormat = SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.US)
        val formattedDate = dateFormat.format(date)
        tv10.text = formattedDate
        layout.setOnRefreshListener {
            presenter!!.requestData()
            if (layout.isRefreshing) {
                layout.isRefreshing = false
            }
        }
        setImage()
    }

    private fun setImage() {
        if (tv8.text.toString().contains("Rain")) {
            image.setImageResource(R.drawable.rain_icon)
        }
        if (tv8.text.toString().contains("Sun")) {
            image.setImageResource(R.drawable.clear_day_icon)
        }
        if (tv8.text.toString().contains("Cloud")) {
            image.setImageResource(R.drawable.cloudy_icon)
        }
        if (tv8.text.toString().contains("Overcast")) {
            image.setImageResource(R.drawable.cloudy_icon)
        }
        if (tv8.text.toString().contains("Clear")) {
            image.setImageResource(R.drawable.clear_day_icon)
        }
    }

}
