package com.fadyz.CovidTracker.base.BaseViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.fadyz.CovidTracker.base.BaseErrorHandler.ErrorHandler

open class BaseViewModel(application: Application) : AndroidViewModel(application) {

    val showErrorLiveData = MutableLiveData<ErrorHandler>()
    val showLoadingViewLiveData = MutableLiveData<Boolean>()
}