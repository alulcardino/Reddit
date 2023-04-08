package com.romanmikhailenko.reddit.presentation.utils

import android.util.Patterns

fun validateEmail(emailString: String) : Boolean {
    return Patterns.EMAIL_ADDRESS.matcher(emailString).matches()
}

fun validatePassword(passwordString: String) : Boolean {
    return "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}\$".toRegex().matches(passwordString)
}

