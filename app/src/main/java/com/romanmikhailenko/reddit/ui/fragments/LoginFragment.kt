package com.romanmikhailenko.reddit.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.romanmikhailenko.reddit.R
import com.romanmikhailenko.reddit.databinding.FragmentLoginBinding
import com.romanmikhailenko.reddit.ui.auth.LoginState
import com.romanmikhailenko.reddit.ui.auth.LoginViewModel
import com.romanmikhailenko.reddit.ui.utils.APP_ACTIVITY


class LoginFragment : Fragment() {
    lateinit var binding: FragmentLoginBinding
    private val viewModel by viewModels<LoginViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initLoginFrom()
        setupViewModel()
    }


    private fun setupViewModel() {
        viewModel.state.observe(viewLifecycleOwner) {
            state ->
                when(state) {
                    is LoginState.LoginButtonEnable -> binding.btnLogin.isEnabled = true
                    is LoginState.LoginSuccessfulState -> APP_ACTIVITY.navController.navigate(R.id.action_loginFragment_to_mainFragment)
                    is LoginState.ErrorState -> binding.btnLogin.isEnabled = false
                    is LoginState.DefaultState -> binding.btnLogin.isEnabled = false
                }
        }
    }


   private fun initLoginFrom() = with(binding) {
       btnLogin.setOnClickListener {
           viewModel.login(
               etEmail.text.toString(),
               etPassword.text.toString()
           )
       }

       etEmail.doAfterTextChanged {
           viewModel.isValidate(
               etEmail.text.toString(),
               etPassword.text.toString()
           )
       }

       etPassword.doAfterTextChanged {
           viewModel.isValidate(
               etEmail.text.toString(),
               etPassword.text.toString()
           )
       }

   }


}