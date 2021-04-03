package com.ruialmeida.quarentilograms.features.register.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ruialmeida.quarentilograms.sdk.extensions.platform.kotlin.multipleLet
import com.ruialmeida.quarentilograms.sdk.extensions.platform.livedata.combineLatestNullable
import com.ruialmeida.quarentilograms.sdk.extensions.platform.livedata.update
import com.ruialmeida.quarentilograms.sdk.utils.platform.livedata.SingleLiveData
import com.ruialmeida.quarentilograms.sdk.utils.validator.CredentialsValidator
import com.ruialmeida.quarentilograms.shared.viewmodel.BaseDataBindingViewModel

class RegisterFragmentViewModel : BaseDataBindingViewModel() {
    companion object {
        private const val TAG = "RegisterFragmentViewModel"

        sealed class RegisterFragmentActions {
            object RegisterClick: RegisterFragmentActions()
        }
    }

    /**
     * Data binding variables to be used on the XML.
     */
    val nameLive = MutableLiveData<String>()
    val userNameLive = MutableLiveData<String>()
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
    private val registerFragmentActionsLive = SingleLiveData<RegisterFragmentActions>()

    /**
     * Calculates if the register button should be enabled or not.
     */
    private val shouldEnableRegisterButton = combineLatestNullable(nameLive, userNameLive, emailLive, passwordLive) { name, userName, email, password ->
        multipleLet(name, userName, email, password) { nonNullName, nonNullUserName, nonNullEmail, nonNullPassword ->
            validateCredentials(nonNullName, nonNullUserName, nonNullEmail, nonNullPassword)
        } ?: false
    }

    /**
     * Validates our user credentials using our helper class [CredentialsValidator]
     */
    private fun validateCredentials(name: String, userName: String, email: String, password: String): Boolean {
        return CredentialsValidator.validateEmail(email)
                && CredentialsValidator.validatePassword(password)
                && CredentialsValidator.validateName(name)
                && CredentialsValidator.validateUserName(userName)
    }

    /**
     * Handles the register button click.
     */
    fun onRegisterButtonClick() {
        Log.d(TAG, "Clicked the register button.")
        registerFragmentActionsLive.update(RegisterFragmentActions.RegisterClick)
    }

    /**
     * Exposed live datas for fragment consumption.
     */
    fun getShouldEnableRegisterButtonLive(): LiveData<Boolean?> = shouldEnableRegisterButton
    fun getRegisterActionsLive(): LiveData<RegisterFragmentActions> = registerFragmentActionsLive
}