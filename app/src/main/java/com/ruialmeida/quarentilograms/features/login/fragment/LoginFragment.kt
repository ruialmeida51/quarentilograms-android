package com.ruialmeida.quarentilograms.features.login.fragment

import android.util.Log
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.ruialmeida.quarentilograms.R
import com.ruialmeida.quarentilograms.databinding.FragmentLoginBinding
import com.ruialmeida.quarentilograms.features.login.viewmodel.LoginFragmentViewModel
import com.ruialmeida.quarentilograms.features.login.viewmodel.LoginFragmentViewModel.Companion.LoginFragmentActions
import com.ruialmeida.quarentilograms.shared.fragment.BaseDataBindingFragment

class LoginFragment : BaseDataBindingFragment<FragmentLoginBinding, LoginFragmentViewModel>(R.layout.fragment_login, LoginFragmentViewModel::class) {
    companion object {
        private const val TAG = "LoginFragment"
    }

    override fun handleInteractions(binding: FragmentLoginBinding, viewModel: LoginFragmentViewModel) {
        binding.loginViewModel = viewModel

        viewModel.getShouldEnableLoginButtonLive().observe(this, Observer { shouldEnableLoginButton ->
            handleShouldLoginButtonEnabled(binding, shouldEnableLoginButton)
        })

        viewModel.getLoginActionsLive().observe(this, Observer { action ->
            handleLoginActions(action)
        })
    }

    private fun handleShouldLoginButtonEnabled(binding: FragmentLoginBinding, shouldEnableLoginButton: Boolean?) {
        Log.d(TAG, "Handling isEnabled of the login button. isEnabled($shouldEnableLoginButton)")
        shouldEnableLoginButton?.let { nonNullShouldEnableLoginButton ->
            binding.activityLoginButton.isEnabled = nonNullShouldEnableLoginButton
            binding.activityLoginButton.alpha = if (nonNullShouldEnableLoginButton) 1f else 0.5f
        }
    }

    private fun handleLoginActions(loginAction: LoginFragmentActions) {
        when(loginAction) {
            LoginFragmentActions.LoginClick -> {
                findNavController().navigate(LoginFragmentDirections.actionFragmentLoginToActivityAuthenticated())
                requireActivity().finish()
            }
            LoginFragmentActions.RegisterClick -> {
                findNavController().navigate(LoginFragmentDirections.actionFragmentLoginToFragmentRegister())
            }
        }
    }

}