package com.navdara.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "message_table")
data class MessageEntity(
    val user: User,
    val subject: String,
    val title: String,
    val content: String,
    val image: String?
) {
    @PrimaryKey(autoGenerate = true)
    var messageId: Int = 0
}