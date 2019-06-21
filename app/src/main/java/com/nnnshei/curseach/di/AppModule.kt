package com.nnnshei.curseach.di

import com.google.firebase.database.FirebaseDatabase
import com.nnnshei.curseach.AppPreferences
import com.nnnshei.curseach.IAppPreferences
import com.nnnshei.curseach.model.FirebaseRepository
import com.nnnshei.curseach.model.db.DbRepository
import com.nnnshei.curseach.model.db.IRemoteDatabase
import com.nnnshei.curseach.model.service.Api
import com.nnnshei.curseach.presentation.login.LoginPresenter
import com.nnnshei.curseach.presentation.room.RoomPresenter
import com.nnnshei.curseach.presentation.rooms.RoomsPresenter
import com.nnnshei.curseach.util.APP_SETTINGS_NAME
import com.nnnshei.curseach.util.ISchedulers
import com.nnnshei.curseach.util.MODE
import com.nnnshei.curseach.util.Schedulers
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import ru.terrakok.cicerone.Cicerone

val appModule = module {
    val cicerone = Cicerone.create()
    single { cicerone.router }
    single { cicerone.navigatorHolder }
    single { FirebaseDatabase.getInstance() }
    factory<IRemoteDatabase> { DbRepository(get()) }
    single<Api> { FirebaseRepository(get()) }
    factory<ISchedulers> { Schedulers() }
    single<IAppPreferences> {
        AppPreferences(
            androidApplication().getSharedPreferences(
                APP_SETTINGS_NAME,
                MODE
            )
        )
    }
    factory { LoginPresenter(get(), get(), get(), get()) }
    factory { RoomsPresenter(get(), get(), get(), get()) }
    factory { RoomPresenter(get(), get(), get(), get()) }
}