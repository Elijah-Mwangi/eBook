package com.example.deved.ui.tools

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ToolsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "You can get help from professional developers and some peers here!"
    }
    val text: LiveData<String> = _text
}