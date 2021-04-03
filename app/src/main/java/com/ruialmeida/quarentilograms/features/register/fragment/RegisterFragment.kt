package com.ruialmeida.quarentilograms.features.register.fragment

import android.util.Log
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.ruialmeida.quarentilograms.R
import com.ruialmeida.quarentilograms.databinding.FragmentRegisterBinding
import com.ruialmeida.quarentilograms.features.register.viewmodel.RegisterFragmentViewModel
import com.ruialmeida.quarentilograms.features.register.viewmodel.RegisterFragmentViewModel.Companion.RegisterFragmentActions
import com.ruialmeida.quarentilograms.shared.fragment.BaseDataBindingFragment

class RegisterFragment : BaseDataBindingFragment<FragmentRegisterBinding, RegisterFragmentViewModel>(R.layout.fragment_register, RegisterFragmentViewModel::class) {
    companion object {
        private const val TAG = "RegisterFragment"
    }

    override fun handleInteractions(binding: FragmentRegisterBinding, viewModel: RegisterFragmentViewModel) {
        binding.registerViewModel = viewModel

        viewModel.getShouldEnableRegisterButtonLive().observe(this, Observer { shouldRegisterButtonBeEnabled ->
            handleShouldRegisterButtonBeEnabled(binding, shouldRegisterButtonBeEnabled)
        })

        viewModel.getRegisterActionsLive().observe(this, Observer { action ->
            handleRegisterActions(action)
        })
    }

    private fun handleShouldRegisterButtonBeEnabled(binding: FragmentRegisterBinding, shouldEnableLoginButton: Boolean?) {
        Log.d(TAG, "Handling isEnabled of the register button. isEnabled($shouldEnableLoginButton)")
        shouldEnableLoginButton?.let { nonNullShouldEnableLoginButton ->
            binding.fragmentRegisterButton.isEnabled = nonNullShouldEnableLoginButton
            binding.fragmentRegisterButton.alpha = if (nonNullShouldEnableLoginButton) 1f else 0.5f
        }
    }

    private fun handleRegisterActions(registerActions: RegisterFragmentActions) {
        when(registerActions) {
            RegisterFragmentActions.RegisterClick -> {
                findNavController().navigate(RegisterFragmentDirections.actionFragmentRegisterToActivityAuthenticated())
                requireActivity().finish()
            }
        }
    }
}