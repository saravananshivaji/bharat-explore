package com.example.bharatexplore.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Welcome to Explore Indian Culture & Heritage! Experience the richness of India’s centuries-old traditions, spiritual teachings, architectural wonders, and diverse cultures from the comfort of your phone."
    }
    val text: LiveData<String> = _text
}