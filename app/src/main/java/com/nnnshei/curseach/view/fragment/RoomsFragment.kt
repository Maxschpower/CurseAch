package com.nnnshei.curseach.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.nnnshei.curseach.R
import com.nnnshei.curseach.presentation.login.LoginPresenter
import org.koin.android.ext.android.get

class RoomsFragment : MvpAppCompatFragment() {

//    @InjectPresenter
//    lateinit var presenter: LoginPresenter
//
//    @ProvidePresenter
//    fun providePresenter() = get<LoginPresenter>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_rooms, container, false)

    companion object {
        fun newInstance() = RoomsFragment()
    }

}