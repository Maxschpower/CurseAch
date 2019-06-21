package com.nnnshei.curseach.presentation.rooms

import com.arellomobile.mvp.MvpView
import com.nnnshei.curseach.model.Message
import com.nnnshei.curseach.model.Room

interface RoomsView : MvpView {
    fun bindData(rooms: List<Room>)
}