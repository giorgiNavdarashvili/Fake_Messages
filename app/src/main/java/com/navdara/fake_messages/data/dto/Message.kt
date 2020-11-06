package com.navdara.fake_messages.data.dto

data class Message(
    val user: User,
    val subject: String,
    val title: String,
    val content: String,
    val image: String?
)