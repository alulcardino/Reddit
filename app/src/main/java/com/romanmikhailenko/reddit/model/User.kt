package com.romanmikhailenko.reddit.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val email: String = "example@example.com",
    val password: String = "123456"
) : Parcelable
