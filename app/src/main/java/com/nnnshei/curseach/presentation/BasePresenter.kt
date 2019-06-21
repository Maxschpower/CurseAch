package com.nnnshei.curseach.presentation

import com.arellomobile.mvp.MvpPresenter
import com.arellomobile.mvp.MvpView
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BasePresenter<T : MvpView> : MvpPresenter<T>() {

    private val jobsList = CompositeDisposable()

    fun Disposable.untilDestroy() = jobsList.add(this)

    override fun onDestroy() {
        jobsList.clear()
        super.onDestroy()
    }
}