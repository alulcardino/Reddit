package com.romanmikhailenko.reddit.ui.adapters.delegates

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.romanmikhailenko.reddit.databinding.ItemAdvertisingBinding
import com.romanmikhailenko.reddit.ui.adapters.viewholders.AdvViewHolder
import com.romanmikhailenko.reddit.ui.model.Advertisement
import com.romanmikhailenko.reddit.ui.model.RedditList

class AdvItemDelegate : DelegationAdapter<Advertisement, AdvViewHolder>(Advertisement::class.java) {
    override fun createViewHolder(
        parent: ViewGroup,
        onLikeClick: (Int, Boolean) -> Unit
    ): RecyclerView.ViewHolder =
        AdvViewHolder(
            ItemAdvertisingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun bindViewHolder(
        model: Advertisement,
        viewHolder: AdvViewHolder,
        payloads: List<RedditList>
    ) {
        viewHolder.bind(model)
    }


}