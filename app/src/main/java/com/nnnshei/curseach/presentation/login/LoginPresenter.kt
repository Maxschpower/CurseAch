package com.nnnshei.curseach.presentation.login

import com.arellomobile.mvp.InjectViewState
import com.nnnshei.curseach.presentation.BasePresenter

@InjectViewState
class LoginPresenter : BasePresenter<LoginView>() {

    fun buttonClicked() {
        viewState.onLoginClicked()
    }

}