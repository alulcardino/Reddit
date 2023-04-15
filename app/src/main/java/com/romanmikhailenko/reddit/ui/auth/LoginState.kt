package com.romanmikhailenko.reddit.ui.auth

import android.os.Parcelable
import androidx.annotation.StringRes
import kotlinx.parcelize.Parcelize

sealed class LoginState {
    @Parcelize
    object DefaultState : LoginState(), Parcelable

    @Parcelize
    object LoginSuccessfulState : LoginState(), Parcelable

    @Parcelize
    object LoginButtonEnable : LoginState(), Parcelable

    @Parcelize
    class ErrorState(@StringRes val stringRes: Int) : LoginState(), Parcelable
}