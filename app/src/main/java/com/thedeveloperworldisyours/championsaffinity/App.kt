package com.thedeveloperworldisyours.championsaffinity

import android.app.Application

/**
 * Created by javiergonzalezcabezas on 5/8/18.
 */
class App : Application() {
    companion object {
        var prefs: Prefs? = null
        //lateinit var scoreComponent: AddComponent
    }

    override fun onCreate() {
        prefs = Prefs(applicationContext)
        super.onCreate()
        /*scoreComponent = DaggerAddComponent.builder()
                .appModule(AppModule(this))
                .build()*/
    }

}