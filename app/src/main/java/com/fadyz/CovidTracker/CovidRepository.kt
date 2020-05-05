package com.fadyz.CovidTracker

import com.fadyz.CovidTracker.Models.CountryModel
import com.fadyz.CovidTracker.Models.StatisticsResponse
import com.fadyz.CovidTracker.base.BaseErrorHandler.ErrorHandler
import io.reactivex.disposables.Disposable

class CovidRepository(val dataSourceImp: RemoteDataSourceImp) {

    fun getRemoteDataFromServer(map: MutableMap<String, String>, onSuccess: (ArrayList<CountryModel>) -> Unit, onError: (ErrorHandler) -> Unit): Disposable {
        return dataSourceImp.getRemoteDataFromServer(map, onSuccess, onError)
    }

    fun getRemoteGeneralStatus(onSuccess: (StatisticsResponse) -> Unit, onError: (ErrorHandler) -> Unit): Disposable {
        return dataSourceImp.getRemoteStatistics(onSuccess, onError)
    }

}