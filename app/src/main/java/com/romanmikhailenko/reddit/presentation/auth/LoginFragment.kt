package com.romanmikhailenko.reddit.presentation.auth

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.romanmikhailenko.reddit.R
import com.romanmikhailenko.reddit.databinding.FragmentLoginBinding
import com.romanmikhailenko.reddit.presentation.utils.APP_ACTIVITY
import com.romanmikhailenko.reddit.presentation.utils.validateEmail
import com.romanmikhailenko.reddit.presentation.utils.validatePassword


class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val mBinding get() = _binding!!

    private val viewModel by viewModels<LoginViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()
        init()
    }

    private fun init() {
        with(mBinding) {
            etEmail.doAfterTextChanged {
                val email = etEmail.text.toString()
                if (!validateEmail(email)) {
                    etLayoutEmail.error = "Hueta"
                } else {
                    etLayoutEmail.error = null
                }
                btnLogin.isEnabled =
                    etLayoutPassword.error == null && etLayoutEmail.error == null
                Log.d("My", "${etLayoutPassword.error} ${etLayoutEmail.error}")
            }

            etPassword.doAfterTextChanged {
                val password = etPassword.text.toString()
                if (!validatePassword(password)) {
                    etLayoutPassword.error = "Hueta"
                } else {
                    etLayoutPassword.error = null
                }
                btnLogin.isEnabled =
                    etLayoutPassword.error == null && etLayoutEmail.error == null
                Log.d("My", "${etLayoutPassword.error} ${etLayoutEmail.error}")

            }

            btnLogin.setOnClickListener {
                APP_ACTIVITY.navController.navigate(R.id.action_loginFragment_to_mainFragment)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}