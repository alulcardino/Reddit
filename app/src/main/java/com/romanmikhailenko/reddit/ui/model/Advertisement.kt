package com.romanmikhailenko.reddit.ui.model

data class Advertisement (
    val id: String,
    val avatar: String,
    val tag: String,
    val author: String,
    val title: String,
) : RedditList