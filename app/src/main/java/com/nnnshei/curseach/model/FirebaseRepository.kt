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

    override fun sendMessage(message: Message, roomKey: String): Completable {
        return database
            .setValue(
                IRemoteDatabase.TABLE_MESSAGES + "/" + roomKey,
                database.createKey(IRemoteDatabase.TABLE_MESSAGES + "/" + roomKey),
                message
            )
    }

    override fun createUser(nickname: String) =
        database.setValue(
            IRemoteDatabase.TABLE_USERS,
            nickname,
            true
        )

    override fun observeMessages(roomKey: String) =
        database.observeChildsList(
            IRemoteDatabase.TABLE_MESSAGES,
            roomKey,
            Message::class.java
        )

    override fun updateLastMessage(room: Room): Completable =
        database.setValue(
            IRemoteDatabase.TABLE_ROOMS,
            room.title!!,
            room
        )

    override var currentRoom: String = ""
}