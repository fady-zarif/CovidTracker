package com.fadyz.CovidTracker.viewModels

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.fadyz.CovidTracker.CovidRepository
import com.fadyz.CovidTracker.Models.CountryModel
import com.fadyz.CovidTracker.Models.StatisticsData
import com.fadyz.CovidTracker.base.BaseViewModel.BaseViewModel


const val MAP_LIMIT_KEY = "limit"

class MainActivityViewModel(application: Application, private val covidRepo: CovidRepository) : BaseViewModel(application) {
    private var pageNum: Int = 1
    private var dataMutableLiveData = MutableLiveData<ArrayList<CountryModel>>()
    private val statiscsLiveData = MutableLiveData<StatisticsData>()
    fun getServerData() {
        showLoadingViewLiveData.value = true
        covidRepo.getRemoteDataFromServer(getQueryMap(), {
            dataMutableLiveData.value = it
            showLoadingViewLiveData.value = false
        }, {
            showErrorLiveData.value = it
            showLoadingViewLiveData.value = false
        })
    }

    fun getGeneralStatus() {
        showLoadingViewLiveData.value = true
        covidRepo.getRemoteGeneralStatus({
            statiscsLiveData.value = it.data
            showLoadingViewLiveData.value = false
        }, {
            showErrorLiveData.value = it
            showLoadingViewLiveData.value = false
        })
    }

    fun getCountriesLiveData(): LiveData<ArrayList<CountryModel>> = dataMutableLiveData
    fun getStatiscsLiveData(): LiveData<StatisticsData> = statiscsLiveData
    // todo change this static
    private fun getQueryMap(): MutableMap<String, String> = mutableMapOf(MAP_LIMIT_KEY to "40", "page" to getPageNum())
    fun addPageNum() {
        pageNum++
        getServerData()
    }

    fun resetPageNum() {
        pageNum = 0
    }

    private fun getPageNum(): String = pageNum.toString()


}