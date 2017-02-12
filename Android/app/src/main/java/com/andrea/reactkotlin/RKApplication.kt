package com.andrea.reactkotlin

import android.app.Application
import com.andrea.reactkotlin.react.InstanceManager

/**
 * Created by andrea on 2/12/17.
 */
open class RKApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        InstanceManager.init(this)
    }
}