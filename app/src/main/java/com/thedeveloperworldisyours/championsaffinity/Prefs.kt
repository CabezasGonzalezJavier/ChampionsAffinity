package com.thedeveloperworldisyours.championsaffinity

import android.content.Context
import android.content.SharedPreferences

/**
 * Created by javiergonzalezcabezas on 5/8/18.
 */
class Prefs(context: Context) {
    val PREFS_FILENAME = "com.teamtreehouse.colorsarefun.prefs"
    val VOTE_READY = "ready"
    val prefs: SharedPreferences = context.getSharedPreferences(PREFS_FILENAME, 0)

    var toDoVote: Boolean
        get() = prefs.getBoolean(VOTE_READY, false)
        set(value) = prefs.edit().putBoolean(VOTE_READY, value).apply()
}