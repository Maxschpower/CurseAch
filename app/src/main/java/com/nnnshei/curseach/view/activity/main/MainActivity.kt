package com.nnnshei.curseach.view.activity.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nnnshei.curseach.R
import com.nnnshei.curseach.Screens
import org.koin.android.ext.android.inject
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppNavigator

class MainActivity : AppCompatActivity() {

    private val holder: NavigatorHolder by inject()
    private val navigator: Navigator = SupportAppNavigator(this, R.id.container)
    private val router: Router by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        router.newRootScreen(Screens.Rooms)
    }

    override fun onResume() {
        super.onResume()
        holder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        holder.removeNavigator()
    }

    companion object {
        fun newInstance(context: Context?) = Intent(context, MainActivity::class.java)
    }
}