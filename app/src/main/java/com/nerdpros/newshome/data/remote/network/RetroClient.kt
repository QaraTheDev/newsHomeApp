package com.nerdpros.newshome.data.remote.network

import com.nerdpros.newshome.util.PrefManager
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @Author: Angatia Benson
 * @Date: 25/08/2022
 * Copyright (c) 2022 Bantechnis
 */
class RetroClient {
    companion object {
        private var mHttpLoggingInterceptor = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)

        private var mOkHttpClient = OkHttpClient
            .Builder()
            .addNetworkInterceptor(Interceptor { chain ->
                val requestBuilder = chain.request().newBuilder()
                val sessionToken = PrefManager().getSessionToken()
                requestBuilder.addHeader("Authorization", sessionToken!!)
                chain.proceed(requestBuilder.build())
            })
            .addInterceptor(mHttpLoggingInterceptor)
            .build()
        private var instance: ApiServices? = null

        fun getApi(): ApiServices {
            if (instance == null) {
                instance = Retrofit.Builder()
                    .baseUrl(Settings.BASEURL)
                    .client(mOkHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
                    .create(ApiServices::class.java)
            }
            return instance!!
        }

    }
}