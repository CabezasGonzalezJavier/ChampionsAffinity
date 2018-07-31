package com.thedeveloperworldisyours.championsaffinity.detail

import kotlinx.android.synthetic.main.detail_fragment.*
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.thedeveloperworldisyours.championsaffinity.R

/**
 * Created by javiergonzalezcabezas on 30/7/18.
 */
class DetailFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.detail_fragment, container, false)
    }
}