package com.andrea.reactkotlin.kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import com.andrea.reactkotlin.R
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        reactButton.setOnClickListener {
            Timber.i("Click")
        }
    }
}