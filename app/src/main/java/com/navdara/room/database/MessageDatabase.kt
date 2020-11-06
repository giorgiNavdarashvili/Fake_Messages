package com.navdara.room.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.navdara.room.dao.MessageDao
import com.navdara.room.entities.MessageEntity
import com.navdara.room.typeConverters.Converters

@Database(entities = [MessageEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class MessageDatabase : RoomDatabase() {
    abstract fun messageDao(): MessageDao

    companion object {
        @Volatile
        private var INSTANCE: MessageDatabase? = null

        fun getDatabase(context: Context): MessageDatabase {
            val temp = INSTANCE
            if (temp != null) {
                return temp
            }

            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MessageDatabase::class.java,
                    "message_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }


    }
}