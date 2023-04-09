package com.romanmikhailenko.reddit.presentation.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.romanmikhailenko.reddit.databinding.FragmentMainBinding
import com.romanmikhailenko.reddit.model.Post
import java.util.UUID

class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val mBinding get() = _binding!!
    private lateinit var mAdapter: MainAdapter
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        init()
        setList()
    }

    private fun init() {
        mAdapter = MainAdapter()
        with(mBinding.recycleView) {
            adapter = mAdapter
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
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
                "",
            )
        }
        mAdapter.setList(items)
    }

}