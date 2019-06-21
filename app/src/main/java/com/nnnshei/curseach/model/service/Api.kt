package com.nnnshei.curseach.model.service

import com.nnnshei.curseach.model.Message
import com.nnnshei.curseach.model.Room
import io.reactivex.Completable
import io.reactivex.Observable

interface Api {
    fun observeRooms(): Observable<List<Room>>
    fun createUser(nickname: String): Completable
    fun sendMessage(message: Message, roomKey: String): Completable
    fun observeMessages(roomKey: String): Observable<List<Message>>
    var currentRoom: String
    fun updateLastMessage(room:Room): Completable
}