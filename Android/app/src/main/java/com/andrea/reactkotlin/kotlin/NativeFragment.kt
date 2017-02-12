package com.andrea.reactkotlin.kotlin

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.andrea.reactkotlin.R

/**
 * Created by andrea on 2/12/17.
 */
class NativeFragment : Fragment() {

    companion object {
        fun newInstance(): NativeFragment = NativeFragment()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater?.inflate(R.layout.fragment_native, container, false)
        return rootView
    }
}