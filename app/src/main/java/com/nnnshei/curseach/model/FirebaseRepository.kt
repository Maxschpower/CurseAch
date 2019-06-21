package com.nnnshei.curseach.model

import com.nnnshei.curseach.model.db.IRemoteDatabase
import com.nnnshei.curseach.model.service.Api
import io.reactivex.Completable
import io.reactivex.Observable

class FirebaseRepository(
    private val database: IRemoteDatabase
) : Api {

    override fun observeRooms(): Observable<List<Room>> =
        database.observeRooms(IRemoteDatabase.TABLE_ROOMS)

    override fun sendMessage(message: Message, roomKey: String): Completable =
        database.setValue(
            IRemoteDatabase.TABLE_MESSAGES,
            database.createKey("/$roomKey" + IRemoteDatabase.TABLE_MESSAGES),
            message
        )

    override fun createUser(nickname: String) =
        database.setValue(
            IRemoteDatabase.TABLE_USERS,
            nickname,
            true
        )

    override fun observeMessages(roomKey: Int) =
        database.observeChildsList(
            IRemoteDatabase.TABLE_MESSAGES,
            "$roomKey",
            Message::class.java
        )
}