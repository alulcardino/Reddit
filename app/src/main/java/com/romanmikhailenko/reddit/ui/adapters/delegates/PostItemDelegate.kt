package com.romanmikhailenko.reddit.ui.adapters.delegates

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.romanmikhailenko.reddit.databinding.ItemPostBinding
import com.romanmikhailenko.reddit.ui.adapters.viewholders.PostViewHolder
import com.romanmikhailenko.reddit.ui.model.Post
import com.romanmikhailenko.reddit.ui.model.RedditList

class PostItemDelegate(
) : DelegationAdapter<Post, PostViewHolder>(Post::class.java) {

    override fun createViewHolder(
        parent: ViewGroup,
        onLikeClick: (Int, Boolean) -> Unit
    ): RecyclerView.ViewHolder =
        PostViewHolder(
            ItemPostBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        ) { position, upDownVote ->
            onLikeClick(position, upDownVote)
        }

    override fun bindViewHolder(
        model: Post,
        viewHolder: PostViewHolder,
        payloads: List<RedditList>
    ) {
        viewHolder.bind(model)
    }


}