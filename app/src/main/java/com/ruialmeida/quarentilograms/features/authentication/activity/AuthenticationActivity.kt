package com.ruialmeida.quarentilograms.features.authentication.activity

import androidx.navigation.fragment.NavHostFragment
import com.ruialmeida.quarentilograms.R
import com.ruialmeida.quarentilograms.databinding.ActivityAuthenticationBinding
import com.ruialmeida.quarentilograms.features.authentication.viewmodel.AuthenticationActivityViewModel
import com.ruialmeida.quarentilograms.shared.activity.BaseNavigationDataBindingActivity

class AuthenticationActivity :
    BaseNavigationDataBindingActivity<ActivityAuthenticationBinding, AuthenticationActivityViewModel>(
        R.layout.activity_authentication,
        R.id.activity_authentication_navigation_host_fragment,
        AuthenticationActivityViewModel::class
    ) {
    override fun handleInteractions(
        binding: ActivityAuthenticationBinding,
        viewModel: AuthenticationActivityViewModel,
    ) {
    }
}