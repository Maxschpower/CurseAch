package com.nnnshei.curseach.presentation

import com.arellomobile.mvp.MvpPresenter
import com.arellomobile.mvp.MvpView
import kotlinx.coroutines.Job

open class BasePresenter<View : MvpView> : MvpPresenter<View>() {

    private val jobsList = mutableListOf<Job>()

    fun Job.untilDestroy() = jobsList.add(this)

    override fun onDestroy() {
        jobsList.forEach { it.cancel() }
        super.onDestroy()
    }
}