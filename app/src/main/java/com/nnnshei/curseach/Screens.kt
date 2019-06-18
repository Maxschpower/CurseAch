package com.nnnshei.curseach

import android.content.Context
import com.nnnshei.curseach.view.main.MainActivity
import ru.terrakok.cicerone.android.support.SupportAppScreen

object Screens {

    object Main : SupportAppScreen() {
        override fun getActivityIntent(context: Context?) = MainActivity.newInstance(context)
    }

}