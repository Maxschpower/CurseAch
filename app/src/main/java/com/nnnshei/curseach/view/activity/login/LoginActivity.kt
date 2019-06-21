package com.nnnshei.curseach.view.activity.login

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.nnnshei.curseach.R
import com.nnnshei.curseach.presentation.login.LoginPresenter
import com.nnnshei.curseach.presentation.login.LoginView
import kotlinx.android.synthetic.main.activity_login.*
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.android.support.SupportAppNavigator


class LoginActivity : MvpAppCompatActivity(), LoginView {

    @InjectPresenter
    lateinit var presenter: LoginPresenter

    @ProvidePresenter
    fun providePresenter() = get<LoginPresenter>()

    private val holder: NavigatorHolder by inject()
    private val navigator: Navigator = SupportAppNavigator(this, R.id.container)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        text_input_nickname.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (s.isNullOrBlank()) {
                    btn_enter.isEnabled = false
                    btn_enter.isClickable = false
                } else {
                    btn_enter.isEnabled = true
                    btn_enter.isClickable = true
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })
        btn_enter.setOnClickListener {
            presenter.onLoginClicked(text_input_nickname.text.toString())
        }
    }

    override fun onResume() {
        super.onResume()
        holder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        holder.removeNavigator()
    }

}