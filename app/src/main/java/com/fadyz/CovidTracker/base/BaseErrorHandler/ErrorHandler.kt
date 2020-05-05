package com.fadyz.CovidTracker.base.BaseErrorHandler

interface ErrorHandler {
    var errorMsgStringRes: Int
    var errorMsgString: String
    var throwable: Throwable?
}