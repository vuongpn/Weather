package com.example.darkyskydemo.mainscreen

import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import android.widget.Toast
import com.example.darkyskydemo.R
import com.example.darkyskydemo.model.Weather
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
    private lateinit var tv9: TextView
    private lateinit var tv10: TextView
    private lateinit var layout: SwipeRefreshLayout
    private var presenter: MainPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mainscreen)
        initUI()
        presenter = MainPresenter(this)
        presenter!!.requestData()
    }

    private fun initUI() {
        tv1 = findViewById(R.id.forecastCurrentTemperatureTxt)
        tv2 = findViewById(R.id.humidiyTxt)
        tv3 = findViewById(R.id.dewPointTxt)
        tv4 = findViewById(R.id.pressureTtxt)
        tv5 = findViewById(R.id.windSpeedTxt)
        tv6 = findViewById(R.id.uvIndexTxt)
        tv7 = findViewById(R.id.chanceOfRainTtxt)
        tv8 = findViewById(R.id.forecastSummaryTxt)
        tv9 = findViewById(R.id.localityNameTxt)
        tv10 = findViewById(R.id.localityTimeTxt)
        layout = findViewById(R.id.swiperefresh)
    }

    override fun onFailure(t: Throwable) {
        Toast.makeText(this, "error", Toast.LENGTH_LONG).show()
    }

    override fun onSucess(weather: Weather) {
        val celcius = ((weather.currently!!.temperature!! - 32) / 1.8)
            .toInt().toString() + "°C"
        val date = Date(weather.currently!!.time!! * 1000)
        tv1.text = celcius
        tv2.text = weather.currently!!.humidity.toString()
        tv3.text = weather.currently!!.dewPoint.toString()
        tv4.text = weather.currently!!.pressure.toString()
        tv5.text = weather.currently!!.windSpeed.toString()
        tv6.text = weather.currently!!.uvIndex.toString()
        tv7.text = weather.currently!!.cloudCover!!
            .toDouble().toString()
        tv8.text = weather.currently!!.summary
        tv9.text = weather.timezone
        tv10.text = date.toString()
        layout.setOnRefreshListener {
            presenter!!.requestData()
            if(layout.isRefreshing()){
                layout.isRefreshing = false
            }
        }
    }

}
