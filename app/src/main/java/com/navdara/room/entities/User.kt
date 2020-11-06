package com.navdara.room.entities

import androidx.room.Entity

@Entity
data class User(
    val name: String,
    val lastName: String,
    val activities: List<String>
) {
    override fun toString(): String {
        return name + lastName + activities.toString()
    }
}