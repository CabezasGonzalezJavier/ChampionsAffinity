package com.thedeveloperworldisyours.championsaffinity.detail

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.thedeveloperworldisyours.championsaffinity.R

/**
 * Created by javiergonzalezcabezas on 30/7/18.
 */
class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_activity)
        if (savedInstanceState == null) {
            changeFragment(DetailFragment())
        }
    }

    fun changeFragment(f: Fragment, cleanStack: Boolean = false) {
        val ft = supportFragmentManager.beginTransaction()
        ft.setCustomAnimations(
                R.anim.abc_fade_in, R.anim.abc_fade_out, R.anim.abc_popup_enter, R.anim.abc_popup_exit)
        ft.add(R.id.detail_activity_contentFrame, f)
        ft.commit()
    }

}