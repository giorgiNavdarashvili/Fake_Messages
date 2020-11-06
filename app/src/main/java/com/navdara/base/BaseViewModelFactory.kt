package com.navdara.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.navdara.fake_messages.data.repository.Repository

class BaseViewModelFactory(
    private val repo: Repository
): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return BaseViewModel(repo) as T
    }

}