package com.romanmikhailenko.reddit.presentation.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.romanmikhailenko.reddit.R
import com.romanmikhailenko.reddit.databinding.FragmentLoginBinding
import com.romanmikhailenko.reddit.databinding.FragmentOnboardingBinding


class LoginFragment : Fragment() {
    lateinit var binding: FragmentLoginBinding
    private val viewModel by viewModels<LoginViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(layoutInflater, container, false)
        binding.button.setOnClickListener {
            if (viewModel.validateEmail()) {

            }
            findNavController().navigate(R.id.action_loginFragment_to_mainFragment)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}