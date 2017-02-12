package com.andrea.reactkotlin.kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.andrea.reactkotlin.R
import com.andrea.reactkotlin.react.ReactActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        reactButton.setOnClickListener {
            ReactActivity.launchActivity(this)
        }
    }
}
