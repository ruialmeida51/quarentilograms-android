package com.ruialmeida.quarentilograms.features.login.state

data class LoginErrorState(
    val errorType: LoginErrorTypes? = null
) {
    sealed class LoginErrorTypes {
        object InvalidPassword: LoginErrorTypes()
        object InvalidEmail: LoginErrorTypes()
        object UnknownError : LoginErrorTypes()
    }
}