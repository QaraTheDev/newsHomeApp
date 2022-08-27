package com.nerdpros.newshome

import android.app.Application
import timber.log.Timber

/**
 * @Author: Angatia Benson
 * @Date: 26/08/2022
 * Copyright (c) 2022 Bantechnis
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        application = this
        Timber.plant(Timber.DebugTree())
    }

    companion object {
        lateinit var application: Application
            private set
    }
}