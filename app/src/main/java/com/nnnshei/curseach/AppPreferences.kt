package com.nnnshei.curseach

import android.content.SharedPreferences

class AppPreferences(private val preferences: SharedPreferences) :
    IAppPreferences {

    private val NICKNAME = Pair("nickname", "")

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    override var nickname: String
        get() = preferences.getString(NICKNAME.first, NICKNAME.second) ?: ""
        set(value) = preferences.edit { it.putString(NICKNAME.first, value) }
}