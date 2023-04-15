package com.romanmikhailenko.reddit.ui.model

data class Post(
    val id: String,
    val avatar: String,
    val tag: String,
    val author: String,
    var votes: String,
    val comments: String,
    val title: String,
    val description: String,
    var upOrDownVote: Boolean?
) : RedditList
