package com.andrea.reactkotlin.kotlin

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.KeyEvent
import com.andrea.reactkotlin.R
import com.andrea.reactkotlin.react.InstanceManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupToolbar()

        navigationView.setNavigationItemSelectedListener {
            pushFragment(if (it.itemId == R.id.action_native) NativeFragment.newInstance() else
                ReactNativeFragment.newInstance())
            drawer.closeDrawer(Gravity.START)
            true
        }

        pushFragment(ReactNativeFragment.newInstance())
    }

    private fun pushFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.content, fragment).commit()
    }

    private fun setupToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp)
        toolbar.setNavigationOnClickListener { drawer.openDrawer(Gravity.START) }
    }

    override fun onKeyUp(keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode == KeyEvent.KEYCODE_MENU) {
            InstanceManager.manager.showDevOptionsDialog()
            return true
        }
        return super.onKeyUp(keyCode, event)
    }
}
