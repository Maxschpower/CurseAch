package com.nnnshei.curseach.view.login

import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.nnnshei.curseach.R
import com.nnnshei.curseach.presentation.login.LoginPresenter
import com.nnnshei.curseach.presentation.login.LoginView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import org.koin.android.ext.android.get

class LoginActivity : MvpAppCompatActivity(), LoginView {

    @InjectPresenter
    lateinit var presenter: LoginPresenter

    @ProvidePresenter
    fun providePresenter() = get<LoginPresenter>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        
    }
}