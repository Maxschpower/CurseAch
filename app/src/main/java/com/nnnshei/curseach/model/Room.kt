package com.nnnshei.curseach.model

data class Room(
    val id: Int,
    val interest: Interest,
    val lastMessage: String,
    val users: List<User>
)