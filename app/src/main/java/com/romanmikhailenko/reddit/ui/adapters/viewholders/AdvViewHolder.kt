package com.romanmikhailenko.reddit.ui.adapters.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.romanmikhailenko.reddit.databinding.ItemAdvertisingBinding
import com.romanmikhailenko.reddit.ui.model.Advertisement

class AdvViewHolder(
    private val binding: ItemAdvertisingBinding,
) : RecyclerView.ViewHolder(binding.root) {
    private var currentItem: Advertisement? = null

    fun bind(item: Advertisement) = with(binding) {
        currentItem = item
        tvPostTitle.text = item.title
        tvAdvTag.text = item.tag


    }
}