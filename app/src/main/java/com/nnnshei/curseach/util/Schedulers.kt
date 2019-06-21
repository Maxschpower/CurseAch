package com.nnnshei.curseach.util

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class Schedulers : ISchedulers {
    override fun ui(): Scheduler = AndroidSchedulers.mainThread()
    override fun computation() = Schedulers.computation()
    override fun trampoline() = Schedulers.trampoline()
    override fun newThread() = Schedulers.newThread()
    override fun io() = Schedulers.io()
}