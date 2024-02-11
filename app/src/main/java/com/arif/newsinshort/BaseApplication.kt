package com.arif.newsinshort

import android.app.Application
import com.arif.newsinshort.di.DataTagInjection
import com.facebook.stetho.Stetho
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject
import javax.inject.Named

@HiltAndroidApp
class BaseApplication : Application() {

    @JvmField
    @field:[Inject Named(DataTagInjection.IS_DEBUG_MODE)]
    var debugMode: Boolean = false
    override fun onCreate() {
        super.onCreate()
        if (debugMode) {
            Stetho.initializeWithDefaults(this)
        }
    }

    companion object {
        const val TAG = "NewsApplication"
        lateinit var instance: BaseApplication
    }
}