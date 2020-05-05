package com.fadyz.CovidTracker.Network

import com.fadyz.CovidTracker.Models.Response
import com.fadyz.CovidTracker.Models.StatisticsResponse
import io.reactivex.Single


import retrofit2.http.GET
import retrofit2.http.QueryMap

interface RemoteApi {
    @GET("countries-search")
    fun getCountriesData(@QueryMap map: MutableMap<String, String>): Single<Response>

    @GET("general-stats")
    fun getStatistics(): Single<StatisticsResponse>
}