package com.andrea.reactkotlin.react

import android.app.Application
import com.andrea.reactkotlin.BuildConfig
import com.facebook.react.ReactInstanceManager
import com.facebook.react.common.LifecycleState
import com.facebook.react.shell.MainReactPackage


/**
 * Created by andrea on 2/12/17.
 */
object InstanceManager {

    lateinit var manager: ReactInstanceManager

    fun init(application: Application) {
        manager = ReactInstanceManager.builder()
                .setApplication(application)
                .setBundleAssetName("index.android.bundle")
                .setJSMainModuleName("index.android")
                .addPackage(MainReactPackage())
                .setUseDeveloperSupport(BuildConfig.DEBUG)
                .setInitialLifecycleState(LifecycleState.RESUMED)
                .build()
    }
}