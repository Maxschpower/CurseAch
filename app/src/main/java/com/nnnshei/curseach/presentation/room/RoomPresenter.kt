package com.nnnshei.curseach.presentation.room

import android.util.Log
import com.arellomobile.mvp.InjectViewState
import com.nnnshei.curseach.IAppPreferences
import com.nnnshei.curseach.model.Message
import com.nnnshei.curseach.model.Room
import com.nnnshei.curseach.model.service.Api
import com.nnnshei.curseach.presentation.BasePresenter
import com.nnnshei.curseach.util.ISchedulers
import ru.terrakok.cicerone.Router

@InjectViewState
class RoomPresenter(
    private val router: Router,
    private val preferences: IAppPreferences,
    private val api: Api,
    private val scheduler: ISchedulers
) : BasePresenter<RoomView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        api.observeMessages(api.currentRoom)
            .observeOn(scheduler.ui())
            .subscribeOn(scheduler.io())
            .subscribe {
                viewState.bindData(it)
            }
            .untilDestroy()
    }

    fun sendClicked(message: String) {
        api
            .sendMessage(
                Message(preferences.nickname, message, System.currentTimeMillis()),
                api.currentRoom
            )
            .observeOn(scheduler.ui())
            .subscribeOn(scheduler.io())
            .subscribe {
                api.updateLastMessage(
                    Room(
                        Message(preferences.nickname, message, System.currentTimeMillis()),
                        api.currentRoom
                    )
                )
                    .observeOn(scheduler.ui())
                    .subscribeOn(scheduler.io())
                    .subscribe {}
            }
            .untilDestroy()
    }

}