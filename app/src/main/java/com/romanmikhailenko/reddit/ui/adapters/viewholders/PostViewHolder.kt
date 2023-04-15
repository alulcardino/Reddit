package com.romanmikhailenko.reddit.ui.adapters.viewholders

import android.content.Context
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.romanmikhailenko.reddit.R
import com.romanmikhailenko.reddit.databinding.ItemPostBinding
import com.romanmikhailenko.reddit.ui.model.Post

class PostViewHolder(
    private val binding: ItemPostBinding,
    upsChange: (Int, Boolean) -> Unit
) : RecyclerView.ViewHolder(binding.root) {
    private var currentItem: Post? = null

    init {
        with(binding) {
            btnUpVote.setOnClickListener {
                upsChange.invoke(layoutPosition, true)
            }

            btnDownVote.setOnClickListener {
                upsChange.invoke(layoutPosition, false)
            }
        }
    }

    fun bind(item: Post) = with(binding) {
        currentItem = item
        tvPostTitle.text = item.title
        tvPostAuthor.text = item.author
        tvPostDescription.text = item.description
        tvVotes.text = item.votes
        tvComment.text = item.comments

        Glide.with(root)
            .load(item.avatar)
            .transform(CircleCrop())
            .error(R.drawable.no_photo)
            .placeholder(R.drawable.no_photo)
            .into(ivPostAvatar)

        setScoredStyle(item)
    }

    private fun setScoredStyle(post: Post) {
        val context = binding.root.context
        when(post.upOrDownVote) {
            true -> {
                binding.btnUpVote.setColorFilter(
                    ContextCompat.getColor(
                        context,
                        R.color.red
                    )
                )
                binding.btnDownVote.colorFilter = null
            }
            false -> {
                binding.btnDownVote.setColorFilter(
                    ContextCompat.getColor(
                        context,
                        R.color.red
                    )
                )
                binding.btnUpVote.colorFilter = null
            }
            null -> {
                binding.btnUpVote.colorFilter = null
                binding.btnDownVote.colorFilter = null
            }
        }

    }
}