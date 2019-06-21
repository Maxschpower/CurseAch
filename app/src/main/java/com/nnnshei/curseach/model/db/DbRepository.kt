package com.nnnshei.curseach.model.db

import com.google.firebase.database.DatabaseReference

class DbRepository(private val dbReference: DatabaseReference) {

    fun getRoomsNode() =
        dbReference.child("rooms")

    fun getMembersNode() =
        dbReference.child("members")

    fun getUsersNode() =
        dbReference.child("users")

    fun getMessagesNode() =
        dbReference.child("messages")

}