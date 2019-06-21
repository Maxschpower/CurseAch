package com.nnnshei.curseach.model.db

import com.nnnshei.curseach.model.Room
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

interface IRemoteDatabase {

    companion object {
        const val TABLE_ROOMS = "rooms"
        const val TABLE_USERS = "users"
        const val TABLE_MESSAGES = "messages"
    }

    fun <T : Any> observeTable(tableReference: String, type: Class<T>): Observable<List<T>>
    fun <T : Any> observeChildsList(
        tableReference: String,
        key: String,
        type: Class<T>
    ): Observable<List<T>>

    fun <T : Any> getTable(tableReference: String, type: Class<T>): Single<List<T>>
    fun <T : Any> getTableChild(tableReference: String, key: String, type: Class<T>): Single<T>
    fun <T : Any> setValue(tableReference: String, key: String, value: T): Completable
    fun <T : Any> updateChildren(tableReference: String, values: Map<String, T>): Completable
    fun createKey(tableReference: String): String
    fun <T : Any> observeChild(tableReference: String, key: String, type: Class<T>): Observable<T>
    fun observeRooms(tableReference: String): Observable<List<Room>>
}