package com.romanmikhailenko.reddit.ui.adapters.delegates

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.romanmikhailenko.reddit.ui.model.RedditList

abstract class DelegationAdapter<M, in VH : RecyclerView.ViewHolder>(val modelClass: Class<out M>) {

    abstract fun createViewHolder(
        parent: ViewGroup,
        onLikeClick: (Int, Boolean) -> Unit
    ) : RecyclerView.ViewHolder

    abstract fun bindViewHolder(model: M, viewHolder: VH, payloads: List<RedditList>)
}