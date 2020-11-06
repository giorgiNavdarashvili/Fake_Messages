package com.navdara.fake_messages.data.api

import com.navdara.fake_messages.data.dto.Message
import retrofit2.http.GET

interface MessageApi {

    @GET("ecd16082")
    suspend fun getMessages(): List<Message>
}