package com.andrea.reactkotlin

import com.squareup.leakcanary.LeakCanary
import timber.log.Timber


/**
 * Created by andrea on 2/12/17.
 */
class RKApplicationDebug : RKApplication() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        LeakCanary.install(this)
    }
}