package com.navdara.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.navdara.fake_messages.R
import com.navdara.fake_messages.data.repository.Repository
import kotlinx.android.synthetic.main.activity_main.*

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: BaseViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repo = Repository()
        val viewModelFactory = BaseViewModelFactory(repo)
        viewModel = ViewModelProvider(this,viewModelFactory).get(BaseViewModel::class.java)
        viewModel.getMessages()
        viewModel.response.observe(this, Observer { response ->
            Log.d(TAG, "Response: $response")
        })

    }
}