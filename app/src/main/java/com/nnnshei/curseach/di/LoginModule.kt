package com.nnnshei.curseach.di

import org.koin.dsl.module
import ru.terrakok.cicerone.Cicerone

val loginModule = module {
    val cicerone = Cicerone.create()
    single { cicerone.router }
    single { cicerone.navigatorHolder }

}