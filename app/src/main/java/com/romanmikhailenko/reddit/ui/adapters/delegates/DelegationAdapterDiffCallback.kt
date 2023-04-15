package com.romanmikhailenko.reddit.ui.adapters.delegates

import androidx.recyclerview.widget.DiffUtil
import com.romanmikhailenko.reddit.ui.model.RedditList
import com.romanmikhailenko.reddit.ui.utils.getItemId

internal class DelegationAdapterDiffCallback : DiffUtil.ItemCallback<RedditList>() {
    override fun areItemsTheSame(oldItem: RedditList, newItem: RedditList): Boolean {
        return oldItem.getItemId() == newItem.getItemId()
    }

    override fun areContentsTheSame(oldItem: RedditList, newItem: RedditList): Boolean {
        return oldItem == newItem
    }

}