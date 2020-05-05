package com.fadyz.CovidTracker

import com.fadyz.CovidTracker.Models.CountryModel
import com.fadyz.CovidTracker.Models.StatisticsResponse
import com.fadyz.CovidTracker.Network.RemoteApi

import com.fadyz.CovidTracker.base.BaseErrorHandler.ErrorHandler
import com.fadyz.CovidTracker.base.BaseErrorHandler.ErrorHandlerImpl

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlin.collections.ArrayList


class RemoteDataSourceImp(private val remoteApi: RemoteApi) {


    //todo create method that has lamda fun for error and response  will be called from the repo to get the data from api and w
    fun getRemoteDataFromServer(map: MutableMap<String, String>, onSuccess: (ArrayList<CountryModel>) -> Unit, onError: (ErrorHandler) -> Unit): Disposable {
        return remoteApi.getCountriesData(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(
                        {
                            onSuccess(it.data.rows)
                        },
                        {
                            onError(ErrorHandlerImpl(it))
                        }
                )
    }



    fun getRemoteStatistics(onSuccess: (StatisticsResponse) -> Unit, onError: (ErrorHandler) -> Unit): Disposable {
        return remoteApi.getStatistics().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            onSuccess(it)
                        },
                        {
                            onError(ErrorHandlerImpl(it))
                        })
    }
}