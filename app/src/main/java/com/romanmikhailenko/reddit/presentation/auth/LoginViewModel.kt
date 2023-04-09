package com.romanmikhailenko.reddit.presentation.auth

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    val mEmailLiveData = MutableLiveData<String>()
    val mPasswordLiveData = MutableLiveData<String>()
    val mMediatorLiveData = MediatorLiveData<Boolean>()
}
