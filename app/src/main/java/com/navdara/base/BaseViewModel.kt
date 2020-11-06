package com.navdara.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.navdara.fake_messages.data.dto.Message
import com.navdara.fake_messages.data.repository.Repository
import kotlinx.coroutines.launch

class BaseViewModel(private val repo: Repository): ViewModel() {

    val response: MutableLiveData<List<Message>> = MutableLiveData()

    fun getMessages() {
        viewModelScope.launch {
            val resp = repo.getMessages()
            response.value = resp
        }
    }

}