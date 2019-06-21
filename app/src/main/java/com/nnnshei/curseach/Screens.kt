package com.nnnshei.curseach

import android.content.Context
import androidx.fragment.app.Fragment
import com.nnnshei.curseach.view.activity.main.MainActivity
import com.nnnshei.curseach.view.fragment.RoomsFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

object Screens {

    object Main : SupportAppScreen() {
        override fun getActivityIntent(context: Context?) = MainActivity.newInstance(context)
    }

    object Rooms : SupportAppScreen() {
        override fun getFragment() = RoomsFragment.newInstance()
    }

}