package com.romanmikhailenko.reddit.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.romanmikhailenko.reddit.R
import com.romanmikhailenko.reddit.ui.utils.set
import com.romanmikhailenko.reddit.ui.utils.validateEmail
import com.romanmikhailenko.reddit.ui.utils.validatePassword

class LoginViewModel(savedStateHandle: SavedStateHandle) : ViewModel() {
    private val mutableState =
        savedStateHandle.getLiveData<LoginState>(KEY_SAVED_STATE_LOGIN, LoginState.DefaultState)

    val state: LiveData<LoginState>
        get() = mutableState

    fun login(email: String, password: String) {
        if (!validateEmail(email)) {
            mutableState.set(newValue = LoginState.ErrorState(stringRes = R.string.invalid_email))
            return
        }

        if (!validatePassword(password)) {
            mutableState.set(newValue = LoginState.ErrorState(stringRes = R.string.invalid_password))
            return
        }

        mutableState.set(newValue = LoginState.LoginSuccessfulState)
    }

    fun isValidate(email: String, password: String) {
        if (!validateEmail(email) || !validatePassword(password)) {
            mutableState.set(newValue = LoginState.DefaultState)
            return
        }

        mutableState.set(newValue = LoginState.LoginButtonEnable)
    }

    companion object {
        private const val KEY_SAVED_STATE_LOGIN = "KEY_SAVED_STATE_LOGIN"
    }
}
