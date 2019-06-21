package com.nnnshei.curseach.model.db

import com.androidhuman.rxfirebase2.database.RxFirebaseDatabase
import com.google.firebase.database.FirebaseDatabase
import com.nnnshei.curseach.model.Room
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

class DbRepository(
    private val firebaseDatabase: FirebaseDatabase
) : IRemoteDatabase {

    override fun <T : Any> observeTable(
        tableReference: String,
        type: Class<T>
    ): Observable<List<T>> = RxFirebaseDatabase
        .dataChanges(firebaseDatabase.getReference(tableReference))
        .map {
            it.children.mapNotNull {
                it.getValue<T>(type)
            }
        }

    override fun observeRooms(
        tableReference: String
    ): Observable<List<Room>> = RxFirebaseDatabase
        .dataChanges(firebaseDatabase.getReference(tableReference))
        .map {
            it.children.mapNotNull {
                it.getValue(Room::class.java)?.apply { title = it.key }
            }
        }

    override fun <T : Any> observeChildsList(
        tableReference: String,
        key: String,
        type: Class<T>
    ): Observable<List<T>> = RxFirebaseDatabase
        .dataChanges(firebaseDatabase.getReference("$tableReference/$key"))
        .map {
            it.children.mapNotNull {
                it.getValue<T>(type)
            }
        }

    override fun <T : Any> observeChild(
        tableReference: String,
        key: String,
        type: Class<T>
    ): Observable<T> = RxFirebaseDatabase
        .dataChanges(firebaseDatabase.getReference("$tableReference/$key"))
        .map {
            it.getValue<T>(type)
        }

    override fun <T : Any> getTable(tableReference: String, type: Class<T>): Single<List<T>> =
        RxFirebaseDatabase
            .data(firebaseDatabase.getReference(tableReference))
            .map {
                it.children.mapNotNull {
                    it.getValue<T>(type)
                }
            }

    override fun <T : Any> getTableChild(
        tableReference: String,
        key: String,
        type: Class<T>
    ): Single<T> = RxFirebaseDatabase
        .data(firebaseDatabase.getReference("$tableReference/$key"))
        .map { it.getValue<T>(type) }

    override fun <T : Any> setValue(tableReference: String, key: String, value: T): Completable =
        RxFirebaseDatabase
            .setValue(firebaseDatabase.getReference("/$tableReference/$key"), value)

    override fun <T : Any> updateChildren(
        tableReference: String,
        values: Map<String, T>
    ): Completable = RxFirebaseDatabase.setValue(firebaseDatabase.getReference("tableReference"), values)

    override fun createKey(tableReference: String): String = firebaseDatabase
        .getReference("/$tableReference/")
        .push().key ?: throw RuntimeException("Created key == null")

}