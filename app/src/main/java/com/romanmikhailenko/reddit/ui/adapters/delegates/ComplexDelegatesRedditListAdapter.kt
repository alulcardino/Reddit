package com.romanmikhailenko.reddit.ui.adapters.delegates

import android.util.SparseArray
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.romanmikhailenko.reddit.ui.model.RedditList
import com.romanmikhailenko.reddit.ui.utils.updateScore

class ComplexDelegatesRedditListAdapter(
    private val delegates: SparseArray<DelegationAdapter<RedditList, RecyclerView.ViewHolder>>
) : PagingDataAdapter<RedditList, RecyclerView.ViewHolder>(DelegationAdapterDiffCallback()){
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val delegateAdapter = delegates[getItemViewType(position)]
    }

    override fun getItemViewType(position: Int): Int {
        val item = getItem(position) ?:
            throw NullPointerException("Cant get viewType for position $position")
        for (i in 0 until delegates.size()) {
            if (delegates[i].modelClass == item.javaClass) {
                return delegates.keyAt(i)
            }
        }
        throw NullPointerException("Cant get viewType for position $position")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return delegates[viewType].createViewHolder(
            parent = parent,
            onLikeClick = ::onLikeClick
        )
    }

    private fun onLikeClick(position: Int, upDownVote: Boolean) {
        snapshot()[position]?.updateScore(upDownVote)
        notifyItemChanged(position)
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        val delegateAdapter = delegates[getItemViewType(position)]
        val item = getItem(position)  ?: return
        delegateAdapter.bindViewHolder(item, holder, emptyList())
    }

    class Builder() {
        private var count = 0;
        private val delegates: SparseArray<DelegationAdapter<RedditList, RecyclerView.ViewHolder>> = SparseArray()

        fun add(delegateAdapter: DelegationAdapter<out RedditList, *>): Builder {
            delegates.put(
                count++,
                delegateAdapter as DelegationAdapter<RedditList, RecyclerView.ViewHolder>
            )
            return this
        }

        fun build(): ComplexDelegatesRedditListAdapter {
            require(count !=0 ) { "Register at least one adapter" }
            return ComplexDelegatesRedditListAdapter(delegates)
        }
    }
}