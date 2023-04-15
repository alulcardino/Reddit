package com.romanmikhailenko.reddit.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.romanmikhailenko.reddit.databinding.ItemPostBinding
import com.romanmikhailenko.reddit.ui.model.Post

class MainDiffCall(
    private val oldList: List<Post>,
    private val newList: List<Post>
) : DiffUtil.Callback() {
    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]

    }
}

class MainAdapter : RecyclerView.Adapter<MainAdapter.MainHolder>() {

    private var posts = emptyList<Post>()

    class MainHolder(
        private val binding: ItemPostBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(post: Post) = with(binding) {
          //  tvPostTag.text = post.tag
            tvPostAuthor.text = post.author
            tvPostDescription.text = post.description
            tvPostTitle.text = post.title
            tvVotes.text = post.votes
            tvComment.text = post.comments
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MainHolder(ItemPostBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        holder.bind(posts[position])
    }

    override fun getItemCount() = posts.size


    fun setList(list: List<Post>) {
        val diffResult = DiffUtil.calculateDiff(MainDiffCall(posts, list))
        posts = list
        diffResult.dispatchUpdatesTo(this)
    }

}