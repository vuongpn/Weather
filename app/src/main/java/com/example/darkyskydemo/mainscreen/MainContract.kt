package com.example.darkyskydemo.mainscreen

import com.example.darkyskydemo.model.Weather

interface MainContract {

    interface View {
        fun onFailure(t: Throwable)
        fun onSucess(weather: Weather)
    }

    interface Model {
        interface OnFinishedListener {
            fun onSuccess(weather: Weather)
            fun onFailure(t: Throwable)
        }

        fun getData(onFinishedListener: OnFinishedListener)
        fun getDailyData()
    }

    interface Presenter {
        fun onSuccess(weather: Weather)
        fun onFailure(t: Throwable)
        fun requestData()
    }
}