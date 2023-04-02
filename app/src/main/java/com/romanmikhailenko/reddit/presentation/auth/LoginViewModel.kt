package com.romanmikhailenko.reddit.presentation.auth

import android.util.Log
import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.romanmikhailenko.reddit.presentation.model.User

class LoginViewModel : ViewModel() {
    private val mutableState = MutableLiveData(
        User(
            email = "example@example.com",
            password = "123456"
        )
    )

    val state: LiveData<User>
        get() = mutableState


    fun validateEmail(): Boolean {
        Log.d("MyLog", mutableState.value.email.toString())
        return Patterns.EMAIL_ADDRESS.matcher(mutableState.value.email.toString()).matches()
    }
}