package com.fadyz.CovidTracker.Network

val retrofit = getRetrofitClient()
val remoteApi: RemoteApi = retrofit.create(RemoteApi::class.java)