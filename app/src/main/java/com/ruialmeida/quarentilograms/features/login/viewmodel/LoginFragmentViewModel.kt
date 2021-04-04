package com.ruialmeida.quarentilograms.features.login.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ruialmeida.quarentilograms.sdk.extensions.platform.kotlin.multipleLet
import com.ruialmeida.quarentilograms.sdk.extensions.platform.livedata.combineLatestNullable
import com.ruialmeida.quarentilograms.sdk.extensions.platform.livedata.update
import com.ruialmeida.quarentilograms.sdk.repository.user.IUserRepository
import com.ruialmeida.quarentilograms.sdk.utils.platform.livedata.SingleLiveData
import com.ruialmeida.quarentilograms.sdk.utils.validator.CredentialsValidator
import com.ruialmeida.quarentilograms.sdk.utils.validator.CredentialsValidator.validateEmail
import com.ruialmeida.quarentilograms.sdk.utils.validator.CredentialsValidator.validatePassword
import com.ruialmeida.quarentilograms.sdk.extensions.koin.inject
import com.ruialmeida.quarentilograms.shared.viewmodel.BaseDataBindingViewModel
import kotlinx.coroutines.launch
import java.lang.Exception

class LoginFragmentViewModel : BaseDataBindingViewModel() {
    companion object {
        private const val TAG = "LoginFragmentViewModel"

        sealed class LoginFragmentActions {
            object LoginClick : LoginFragmentActions()
            object RegisterClick : LoginFragmentActions()
        }
    }

    private val userRepository: IUserRepository by inject()

    /**
     * Data binding variables to be used on the XML.
     */
    val emailLive = MutableLiveData<String>()
    val passwordLive = MutableLiveData<String>()

    /**
     * Action listeners
     *
     * "For anyone using LiveData in a previous Fragment which is a Home Fragment,
     * whenever you go back to the previous Fragment by pressing back button the Fragment is
     * starting to observe the data and because ViewModel survives this operation it immediately
     * emits the last emitted value which in my case opens the Fragment from which I pressed the
     * back button, that way it looks like the back button is not working the solution for this is
     * using something that emits data only once. I used this:"
     *
     * See a more thorough explanation at: https://stackoverflow.com/a/62176554
     */
    private val loginFragmentActionsLive = SingleLiveData<LoginFragmentActions>()

    /**
     * Calculates if the login button should be enabled or not.
     */
    private val shouldEnableLoginButton = combineLatestNullable(emailLive, passwordLive) { email, password ->
        multipleLet(email, password) { nonNullEmail, nonNullPassword ->
            validateCredentials(nonNullEmail, nonNullPassword)
        } ?: false
    }

    /**
     * Validates our user credentials using our helper class [CredentialsValidator]
     */
    private fun validateCredentials(email: String, password: String): Boolean {
        return validateEmail(email) && validatePassword(password)
    }

    /**
     * Handles the register button click.
     */
    fun onRegisterButtonClick() {
        Log.d(TAG, "Clicked the register button.")
        loginFragmentActionsLive.update(LoginFragmentActions.RegisterClick)
    }

    /**
     * Handles the login button click.
     */
    fun onLoginClick() {
        Log.d(TAG, "Clicked the login button.")
        viewModelScope.launch {
            try {
                userRepository.findAll()
            } catch (exception: Exception) {
                Log.e(TAG, "Kaboom!", exception)
            }
        }
        loginFragmentActionsLive.update(LoginFragmentActions.LoginClick)
    }

    /**
     * Exposed live datas for fragment consumption.
     */
    fun getShouldEnableLoginButtonLive(): LiveData<Boolean?> = shouldEnableLoginButton
    fun getLoginActionsLive(): LiveData<LoginFragmentActions> = loginFragmentActionsLive
}