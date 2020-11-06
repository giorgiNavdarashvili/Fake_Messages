package com.navdara.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.navdara.room.entities.MessageEntity

@Dao
interface MessageDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addMessage(messageEntity: MessageEntity)

    @Query("SELECT * FROM message_table ORDER BY messageId ASC")
    fun readAllMessages() : LiveData<List<MessageEntity>>

}