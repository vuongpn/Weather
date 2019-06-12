package com.example.darkyskydemo.secondscreen

import com.example.darkyskydemo.model.Datum__

interface DailyContract {
    interface View{
        fun onSuccess(dailyList: List<Datum__>)
        fun onFailure(t:Throwable)
    }

    interface Model{
        interface OnFinishedListener{
            fun onSuccess(dailyList: List<Datum__>)
            fun onFailure(t:Throwable)
        }
        fun getData(OnFinishedListener:OnFinishedListener)
    }

    interface Presenter{
        fun onDestroy()
        fun requestData()
    }

}