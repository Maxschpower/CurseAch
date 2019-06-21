package com.nnnshei.curseach.presentation.login

import com.arellomobile.mvp.InjectViewState
import com.nnnshei.curseach.IAppPreferences
import com.nnnshei.curseach.Screens
import com.nnnshei.curseach.model.service.Api
import com.nnnshei.curseach.presentation.BasePresenter
import com.nnnshei.curseach.util.ISchedulers
import ru.terrakok.cicerone.Router

@InjectViewState
class LoginPresenter(
    private val router: Router,
    private val preferences: IAppPreferences,
    private val api: Api,
    private val scheduler: ISchedulers
) : BasePresenter<LoginView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        if (preferences.nickname.isNotBlank())
            router.newRootScreen(Screens.Main)
    }

    fun onLoginClicked(nick: String) {
        api.createUser(nick)
            .observeOn(scheduler.ui())
            .subscribeOn(scheduler.io())
            .subscribe {
                preferences.nickname = nick
                router.newRootScreen(Screens.Main)
            }
            .untilDestroy()
    }

}