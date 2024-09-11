package com.alphaomardiallo.a100_days_of_code

import android.app.Application
import com.alphaomardiallo.a100_days_of_code.di.moduleList
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber
import timber.log.Timber.Forest.plant

class App100Doc: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@App100Doc)
            modules(moduleList())
        }

        if (BuildConfig.DEBUG) {
            plant(Timber.DebugTree())
        }
    }
}
