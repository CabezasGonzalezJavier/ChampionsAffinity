package com.thedeveloperworldisyours.championsaffinity

import android.app.Application

/**
 * Created by javiergonzalezcabezas on 5/8/18.
 */
class App : Application() {
    companion object {
        var prefs: Prefs? = null
    }

    override fun onCreate() {
        prefs = Prefs(applicationContext)
        super.onCreate()
    }
}