package com.nnnshei.curseach.di

import com.google.firebase.database.FirebaseDatabase
import com.nnnshei.curseach.AppPreferences
import com.nnnshei.curseach.IAppPreferences
import com.nnnshei.curseach.presentation.login.LoginPresenter
import com.nnnshei.curseach.util.APP_SETTINGS_NAME
import com.nnnshei.curseach.util.MODE
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import ru.terrakok.cicerone.Cicerone

val appModule = module {
    val cicerone = Cicerone.create()
    single { cicerone.router }
    single { cicerone.navigatorHolder }
    single<IAppPreferences> {
        AppPreferences(
            androidApplication().getSharedPreferences(
                APP_SETTINGS_NAME,
                MODE
            )
        )
    }
    single { FirebaseDatabase.getInstance().reference }
    factory { LoginPresenter(get(), get()) }
}