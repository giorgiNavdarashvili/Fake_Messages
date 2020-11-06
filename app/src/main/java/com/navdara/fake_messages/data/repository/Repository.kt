package com.navdara.fake_messages.data.repository

import com.navdara.fake_messages.data.api.RetrofitInstance
import com.navdara.fake_messages.data.dto.Message

class Repository {

    suspend fun getMessages(): List<Message>{
        return RetrofitInstance.api.getMessages()
    }
}