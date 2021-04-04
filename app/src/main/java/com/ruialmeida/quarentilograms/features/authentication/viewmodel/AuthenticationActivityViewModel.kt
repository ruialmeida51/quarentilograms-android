package com.ruialmeida.quarentilograms.features.authentication.viewmodel

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.ruialmeida.quarentilograms.sdk.extensions.koin.inject
import com.ruialmeida.quarentilograms.sdk.model.local.LocalUserData
import com.ruialmeida.quarentilograms.sdk.repository.user.IUserRepository
import com.ruialmeida.quarentilograms.sdk.securepreferences.ISecurePreferences
import com.ruialmeida.quarentilograms.shared.viewmodel.BaseDataBindingViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AuthenticationActivityViewModel : BaseDataBindingViewModel() {

    private val userRepository: IUserRepository by inject()
    private val sharedPrefs: ISecurePreferences by inject()

    init {

        viewModelScope.launch(Dispatchers.IO) {
            val inserted = userRepository.insertAllLocalDataSource(
                listOf(
                    LocalUserData(
                        uniqueUserId = 1,
                        name = "asdf",
                        userName = "username1",
                        email = "email1@email.com",
                        photoUrl = "somelink1.com"
                    ),
                    LocalUserData(
                        uniqueUserId = 2,
                        name = "asdf2",
                        userName = "username12",
                        email = "email12@email.com",
                        photoUrl = "somelink12.com"
                    ),
                    LocalUserData(
                        uniqueUserId = 3,
                        name = "asdf3",
                        userName = "username13",
                        email = "email13@email.com",
                        photoUrl = "somelink13.com"
                    ),
                    LocalUserData(
                        uniqueUserId = 4,
                        name = "asdf4",
                        userName = "username14",
                        email = "email14@email.com",
                        photoUrl = "somelink14.com"
                    )
                )
            )

            Log.d("Asdf", "prefs ${sharedPrefs.getSecurePreferences().getString(ISecurePreferences.USER_UUID, null)}")
            Log.d("Asdf", "users: $inserted")
            Log.d("Asdf", "users: ${userRepository.findAll()}")
        }
    }
}