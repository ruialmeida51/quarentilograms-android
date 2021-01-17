package com.ruialmeida.quarentilograms.features.login.state

data class LoginState(
    val loginButtonEnabled: Boolean = false,
    val isLoading: Boolean = false
)