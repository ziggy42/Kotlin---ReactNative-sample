package com.andrea.reactkotlin.kotlin

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.andrea.reactkotlin.react.InstanceManager
import com.facebook.react.ReactRootView
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler

/**
 * Created by andrea on 2/12/17.
 */
class ReactNativeFragment : Fragment(), DefaultHardwareBackBtnHandler {

    companion object {
        fun newInstance(): ReactNativeFragment = ReactNativeFragment()
    }

    private val OVERLAY_PERMISSION_REQ_CODE = 1

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val reactRootView = ReactRootView(activity)
        reactRootView.startReactApplication(InstanceManager.manager, "HelloWorld", null)
        return reactRootView
    }

    override fun invokeDefaultOnBackPressed() {
        activity.onBackPressed()
    }

    override fun onPause() {
        super.onPause()
        InstanceManager.manager.onHostPause(activity)
    }

    override fun onResume() {
        super.onResume()
        InstanceManager.manager.onHostResume(activity, this)
    }

    override fun onDestroy() {
        super.onDestroy()
        InstanceManager.manager.onHostDestroy(activity)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        if (requestCode == OVERLAY_PERMISSION_REQ_CODE) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (!Settings.canDrawOverlays(activity)) {
                    // SYSTEM_ALERT_WINDOW permission not granted...
                }
            }
        }
    }
}