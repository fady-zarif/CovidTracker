package com.fadyz.CovidTracker.Network

import com.fadyz.CovidTracker.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


private val sLogLevel = if (BuildConfig.DEBUG)
    HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
private const val baseUrl = "https://corona-virus-stats.herokuapp.com/api/v1/cases/"

fun getRetrofitClient() = retrofitClient(baseUrl, okHttpClient(false))
private fun getLogInterceptor() = HttpLoggingInterceptor().apply { level = sLogLevel }

private fun okHttpClient(addAuthHeader: Boolean) = OkHttpClient.Builder()
        .addInterceptor(getLogInterceptor())
        .apply { setTimeOutToOkHttpClient(this) }
        .addInterceptor(headersInterceptor(addAuthHeader)).build()

private fun retrofitClient(baseUrl: String, httpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

private fun headersInterceptor(addAuthHeader: Boolean) = Interceptor { chain ->
    chain.proceed(
            chain.request().newBuilder()
                    .addHeader("Content-Type", "application/json")
                    .also {
                        when {  //todo
                            addAuthHeader -> {
                            }
                        }
                    }.build()
    )
}

private fun setTimeOutToOkHttpClient(okHttpClientBuilder: OkHttpClient.Builder) =
        okHttpClientBuilder.apply {
            readTimeout(30L, TimeUnit.SECONDS)
            connectTimeout(30L, TimeUnit.SECONDS)
            writeTimeout(30L, TimeUnit.SECONDS)
        }
