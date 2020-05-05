package com.fadyz.CovidTracker.KoinDi

import com.fadyz.CovidTracker.CovidRepository
import com.fadyz.CovidTracker.viewModels.MainActivityViewModel
import com.fadyz.CovidTracker.Network.remoteApi
import com.fadyz.CovidTracker.RemoteDataSourceImp
import org.koin.android.ext.koin.androidApplication
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module


val AppModule = module {
    single { remoteApi }
    single { RemoteDataSourceImp(get()) }
    single { CovidRepository(get()) }
    viewModel { MainActivityViewModel(androidApplication(), get()) }
}