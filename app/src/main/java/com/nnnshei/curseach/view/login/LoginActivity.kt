package com.nnnshei.curseach.view.login

import android.os.Bundle
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.nnnshei.curseach.R
import com.nnnshei.curseach.presentation.login.LoginPresenter
import com.nnnshei.curseach.presentation.login.LoginView
import kotlinx.android.synthetic.main.activity_login.*
import org.koin.android.ext.android.get

class LoginActivity : MvpAppCompatActivity(), LoginView {

    @InjectPresenter
    lateinit var presenter: LoginPresenter

    @ProvidePresenter
    fun providePresenter() = get<LoginPresenter>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        button.setOnClickListener {
            presenter.buttonClicked()
        }
    }

    override fun onLoginClicked() {
        Toast.makeText(this, text_input_nickname.toString(), Toast.LENGTH_SHORT).show()
    }
}