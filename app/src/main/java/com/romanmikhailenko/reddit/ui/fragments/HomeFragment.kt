package com.romanmikhailenko.reddit.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide.init
import com.romanmikhailenko.reddit.databinding.FragmentMainBinding
import com.romanmikhailenko.reddit.ui.adapters.delegates.AdvItemDelegate
import com.romanmikhailenko.reddit.ui.adapters.delegates.ComplexDelegatesRedditListAdapter
import com.romanmikhailenko.reddit.ui.adapters.delegates.PostItemDelegate
import com.romanmikhailenko.reddit.ui.model.Post
import com.romanmikhailenko.reddit.ui.main.MainAdapter
import com.romanmikhailenko.reddit.ui.main.MainViewModel
import com.romanmikhailenko.reddit.ui.utils.autoCleared
import java.util.UUID

class HomeFragment : Fragment() {
    private val viewBinding by viewBinding(FragmentMainBinding::bind)
    private var adapter: ComplexDelegatesRedditListAdapter by autoCleared()
    private val viewModel by viewModels<MainViewModel>()



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        initSubredditList()
        setList()
    }

    private fun initSubredditList() {

        adapter = ComplexDelegatesRedditListAdapter.Builder()
            .add(PostItemDelegate())
            .add(AdvItemDelegate())
            .build()

        with(viewBinding) {
            recycleView.setHasFixedSize(true)
            recycleView.layoutManager = LinearLayoutManager(context)
            recycleView.adapter = adapter
        }

    }


    private fun setList() {
        val items = List(20) {
            Post(
                UUID.randomUUID().toString(),
                "sho",
                "sho",
                "sho",
                "sho",
                "sho",
                "sho",
                "sldkhfsidvlsdhlkfwoivgewupogerwoigowiehgiwsldkhfsidvlsdhlkfwoivgewupogerwoigowiehgiwsldkhfsidvlsdhlkfwoivgewupogerwoigowiehgiw",
                true
            )
        }
        mAdapter.setList(items)
    }

}