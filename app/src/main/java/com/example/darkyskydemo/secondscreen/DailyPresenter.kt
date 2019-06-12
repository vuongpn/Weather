package com.example.darkyskydemo.secondscreen

import com.example.darkyskydemo.model.Datum__

class DailyPresenter internal constructor(private var view:DailyContract.View?)
    :DailyContract.Presenter,DailyContract.Model.OnFinishedListener{

    private val model:DailyContract.Model
    init {
        model=DailyModel()
    }
    override fun onSuccess(dailyList: List<Datum__>) {
       view!!.onSuccess(dailyList)
    }

    override fun onFailure(t: Throwable) {
        view!!.onFailure(t)
    }

    override fun onDestroy() {
        this.view=null
    }

    override fun requestData() {
        model.getData(this)
    }
}