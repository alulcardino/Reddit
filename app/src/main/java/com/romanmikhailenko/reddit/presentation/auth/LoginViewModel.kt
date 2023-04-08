package com.romanmikhailenko.reddit.presentation.auth

import android.util.Log
import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.romanmikhailenko.reddit.presentation.model.User

class LoginViewModel : ViewModel() {
    val mEmailLiveData = MutableLiveData<String>()
    val mPasswordLiveData = MutableLiveData<String>()
    val mMediatorLiveData = MediatorLiveData<Boolean>()
}
