package com.ruialmeida.quarentilograms.features.login.viewmodel

import android.util.Log
import android.util.Patterns
import com.ruialmeida.lumbridgelibrary.extensions.platform.coroutines.flowOnIO
import com.ruialmeida.lumbridgelibrary.extensions.platform.coroutines.flowOnMain
import com.ruialmeida.lumbridgelibrary.extensions.platform.coroutines.launchOnIO
import com.ruialmeida.lumbridgelibrary.viewmodel.base.BaseStatefulViewModel
import com.ruialmeida.quarentilograms.features.login.state.LoginErrorState
import com.ruialmeida.quarentilograms.features.login.state.LoginState
import kotlinx.coroutines.flow.*

class LoginViewModel : BaseStatefulViewModel<LoginState, LoginErrorState>() {

    companion object {
        private const val TAG = "LoginViewModel"

        private sealed class LoginActions {
            object LoginClick : LoginActions()
            object RegisterClick : LoginActions()
        }
    }

    private var isEmailFocused: Boolean = false
    private var isPasswordFocused: Boolean = false

    override fun setup() {

    }

    fun bindClicks(
        emailChanges: Flow<CharSequence>,
        emailFocus: Flow<Boolean>,
        passwordChanges: Flow<CharSequence>,
        passwordFocus: Flow<Boolean>,
        loginButtonClick: Flow<Unit>,
        registerButtonClick: Flow<Unit>
    ) {

        combine(emailFocus, emailChanges, passwordFocus, passwordChanges) { emailFocusState, emailCharSequence, passwordFocusState, passwordCharSequence ->
            if ((emailFocusState != isEmailFocused) || (passwordFocusState != isPasswordFocused)) {

                Log.d(TAG, "Updated email or password: $emailCharSequence $passwordCharSequence")

                val shouldEnableLoginButton = isEmailValid(emailCharSequence.toString()) && isPasswordValid(passwordCharSequence.toString())
                updateState(getCurrentState().copy(loginButtonEnabled = shouldEnableLoginButton))

                isEmailFocused = emailFocusState
                isPasswordFocused = passwordFocusState
            }
        }.flowOnMain().launchOnIO()

        listOf(
            loginButtonClick.map { LoginActions.LoginClick },
            registerButtonClick.map { LoginActions.RegisterClick }
        ).merge().onEach { loginActions ->
            when(loginActions) {
                is LoginActions.LoginClick ->{
                    Log.d(TAG, "Clicked login")
                }
                is LoginActions.RegisterClick -> {
                    Log.d(TAG, "Clicked register")
                }
            }
        }.flowOnMain().launchOnIO()
    }

    private fun isEmailValid(email: String) = email.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    private fun isPasswordValid(password: String) = password.isNotEmpty()

    override fun getDefaultState(): LoginState = LoginState()
    override fun getDefaultErrorState(): LoginErrorState = LoginErrorState()
}