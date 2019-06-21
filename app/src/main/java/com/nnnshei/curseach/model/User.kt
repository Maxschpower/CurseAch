package com.nnnshei.curseach.model

data class User(
    val name: String,
    val interests: List<Interest>,
    val rooms: List<Room>
)