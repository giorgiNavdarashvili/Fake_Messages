package com.navdara.room.typeConverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.navdara.room.entities.User
// username, lastName, act1,act2
class Converters {

    @TypeConverter
    fun fromUser(user: User): String {
        return user.toString()
    }

    @TypeConverter
    fun toUser(userString: String): User {
        val username = userString.substringBefore(",")
        val str = userString.substringAfter(",")
        val lastName = str.substringBefore(",")
        val activitiesToParse = userString.split(",")
        val activities = activitiesToParse.subList(2,activitiesToParse.size)

        return User(
            username,
            lastName,
            activities
        )

    }
}