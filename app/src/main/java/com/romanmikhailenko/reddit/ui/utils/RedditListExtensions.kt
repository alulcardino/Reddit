package com.romanmikhailenko.reddit.ui.utils

import com.romanmikhailenko.reddit.ui.model.Advertisement
import com.romanmikhailenko.reddit.ui.model.Post
import com.romanmikhailenko.reddit.ui.model.RedditList

fun RedditList.getItemId() : String {
    return when(this) {
        is Post -> this.id
        is Advertisement -> this.id
    }
}

fun RedditList.getLikeStatus(): Boolean? {
    return when (this) {
        is Post -> this.upOrDownVote
        else -> null
    }
}

fun RedditList.setLikeStatus(likes: Boolean?) {
    return when (this) {
        is Post -> this.upOrDownVote = likes
        else -> {}
    }
}

fun RedditList.plusScore(value: Int) {
    return when (this) {
        is Post -> this.votes += value
        else -> {}    }
}

fun RedditList.updateScore(upDownVote: Boolean){
    if (upDownVote) {
        when (this.getLikeStatus()) {
            true -> {
                this.setLikeStatus(null)
                this.plusScore(-1)
            }
            false -> {
                this.setLikeStatus(true)
                this.plusScore(2)
            }
            null -> {
                this.setLikeStatus(true)
                this.plusScore(1)
            }
        }
    } else {
        when (this.getLikeStatus()) {
            true -> {
                this.setLikeStatus(false)
                this.plusScore(-2)
            }
            false -> {
                this.setLikeStatus(null)
                this.plusScore(1)
            }
            null -> {
                this.setLikeStatus(false)
                this.plusScore(-1)
            }
        }
    }
}
