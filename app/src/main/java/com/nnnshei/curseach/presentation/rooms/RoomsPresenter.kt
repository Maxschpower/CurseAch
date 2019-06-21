package com.nnnshei.curseach.presentation.rooms

import com.arellomobile.mvp.InjectViewState
import com.nnnshei.curseach.IAppPreferences
import com.nnnshei.curseach.Screens
import com.nnnshei.curseach.model.service.Api
import com.nnnshei.curseach.presentation.BasePresenter
import com.nnnshei.curseach.util.ISchedulers
import ru.terrakok.cicerone.Router

@InjectViewState
class RoomsPresenter(
    private val router: Router,
    private val preferences: IAppPreferences,
    private val api: Api,
    private val scheduler: ISchedulers
) : BasePresenter<RoomsView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        api.observeRooms()
            .observeOn(scheduler.ui())
            .subscribeOn(scheduler.io())
            .subscribe({
                viewState.bindData(it)
            }, {
                it.printStackTrace()
            })
            .untilDestroy()
    }

    fun onRoomClicked(key: String) {
        router.navigateTo(Screens.Room(key))
    }

}