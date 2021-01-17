package com.ruialmeida.quarentilograms.features.login.activity

import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.ruialmeida.lumbridgelibrary.activities.base.BaseStatefulActivity
import com.ruialmeida.lumbridgelibrary.extensions.bindings.clicksThrottle
import com.ruialmeida.quarentilograms.R
import com.ruialmeida.quarentilograms.databinding.ActivityLoginBinding
import com.ruialmeida.quarentilograms.features.login.state.LoginErrorState
import com.ruialmeida.quarentilograms.features.login.state.LoginState
import com.ruialmeida.quarentilograms.features.login.viewmodel.LoginViewModel
import kotlinx.coroutines.flow.distinctUntilChanged
import reactivecircus.flowbinding.android.view.focusChanges
import reactivecircus.flowbinding.android.widget.textChanges

class LoginActivity : BaseStatefulActivity<ActivityLoginBinding, LoginViewModel, LoginState, LoginErrorState>() {
    override fun setupContent() {
    }

    override fun setupClickListeners() {
        viewModel.bindClicks(
            binding.activityLoginEmail.textChanges(),
            binding.activityLoginEmail.focusChanges(),
            binding.activityLoginPassword.textChanges(),
            binding.activityLoginPassword.focusChanges(),
            binding.activityLoginButton.clicksThrottle(),
            binding.activityLoginRegisterButton.clicksThrottle()
        )
    }

    override fun setupObservables() {
    }

    override fun handleUpdateScreenFromState(newState: LoginState?) {
        handleLoginButtonState(newState?.loginButtonEnabled)
        handleLoadingState(newState?.isLoading)
    }

    override fun handleUpdateScreenFromError(errorState: LoginErrorState?) {
        handleErrorsFromType(errorState?.errorType)
    }

    private fun handleLoginButtonState(shouldActivateButton: Boolean?) {

    }

    private fun handleLoadingState(shouldShowLoading: Boolean?) {

    }

    private fun handleErrorsFromType(errorTypes: LoginErrorState.LoginErrorTypes?) {

    }

    override fun setupDataBinding(): ActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
    override fun setupViewModel(): LoginViewModel = ViewModelProvider.NewInstanceFactory().create(LoginViewModel::class.java)
}