package com.example.darkyskydemo.mainscreen

import com.example.darkyskydemo.model.Weather

class MainPresenter internal constructor(private var view: MainContract.View) : MainContract.Presenter,
    MainContract.Model.OnFinishedListener {


    private val model: MainContract.Model

    init {
        model = MainModel()
    }

    override fun onSuccess(weather: Weather) {
        view.onSucess(weather)

    }

    override fun onFailure(t: Throwable) {
        view.onFailure(t)
    }

    override fun requestData() {
        model.getData(this)
    }
    override fun requestLocation() {
        model.getLocation(this)
    }

}