package com.nnnshei.curseach.presentation.room

import com.arellomobile.mvp.MvpView
import com.nnnshei.curseach.model.Message

interface RoomView : MvpView {
    fun bindData(data: List<Message>)
}