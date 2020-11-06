package com.navdara.fake_messages.data.api

import com.navdara.fake_messages.data.util.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: MessageApi by lazy {
        retrofit.create(MessageApi::class.java)
    }
}