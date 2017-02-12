package com.andrea.reactkotlin.react

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.support.v7.app.AppCompatActivity
import android.view.KeyEvent
import com.facebook.react.ReactRootView
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler


class ReactActivity : AppCompatActivity(), DefaultHardwareBackBtnHandler {

    companion object {
        fun launchActivity(context: Context) {
            context.startActivity(Intent(context, ReactActivity::class.java))
        }
    }

    private val OVERLAY_PERMISSION_REQ_CODE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val reactRootView = ReactRootView(this)
        reactRootView.startReactApplication(InstanceManager.manager, "HelloWorld", null)
        setContentView(reactRootView)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!Settings.canDrawOverlays(this)) {
                startActivityForResult(Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                        Uri.parse("package:" + packageName)), OVERLAY_PERMISSION_REQ_CODE)
            }
        }
    }

    override fun invokeDefaultOnBackPressed() {
        super.onBackPressed()
    }

    override fun onPause() {
        super.onPause()
        InstanceManager.manager.onHostPause(this)
    }

    override fun onResume() {
        super.onResume()
        InstanceManager.manager.onHostResume(this, this)
    }

    override fun onDestroy() {
        super.onDestroy()
        InstanceManager.manager.onHostDestroy(this)
    }

    override fun onBackPressed() {
        InstanceManager.manager.onBackPressed()
    }

    override fun onKeyUp(keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode == KeyEvent.KEYCODE_MENU) {
            InstanceManager.manager.showDevOptionsDialog()
            return true
        }
        return super.onKeyUp(keyCode, event)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        if (requestCode == OVERLAY_PERMISSION_REQ_CODE) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (!Settings.canDrawOverlays(this)) {
                    // SYSTEM_ALERT_WINDOW permission not granted...
                }
            }
        }
    }
}
