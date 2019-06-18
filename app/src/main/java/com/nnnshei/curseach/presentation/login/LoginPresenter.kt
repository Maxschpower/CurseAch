package com.nnnshei.curseach.presentation.login

import com.arellomobile.mvp.InjectViewState
import com.nnnshei.curseach.IAppPreferences
import com.nnnshei.curseach.Screens
import com.nnnshei.curseach.presentation.BasePresenter
import ru.terrakok.cicerone.Router

@InjectViewState
class LoginPresenter(
    private val router: Router,
    private val preferences: IAppPreferences
) : BasePresenter<LoginView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        if (preferences.nickname.isNotBlank())
            router.newRootScreen(Screens.Main)
    }

    fun onLoginClicked(nick: String) {
        preferences.nickname = nick
        router.newRootScreen(Screens.Main)
    }

}