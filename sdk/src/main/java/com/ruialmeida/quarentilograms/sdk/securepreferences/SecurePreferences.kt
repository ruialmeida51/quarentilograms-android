package com.ruialmeida.quarentilograms.sdk.securepreferences

import android.app.Application
import android.content.SharedPreferences
import androidx.core.content.edit
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys

/**
 * An helper class to retrieve and create secure preferences by encrypting
 * the user data.
 */
class SecurePreferences(private val context: Application) : ISecurePreferences {
    private val masterKey = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)
    private val preferencesName = "Quarentilograms_Secure_Prefs"
    private var sharedPreferences: SharedPreferences? = null

    init {
        createSecurePreferences()
    }

    private fun createSecurePreferences() : SharedPreferences {
        return EncryptedSharedPreferences.create(preferencesName, masterKey, context,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        ).apply { sharedPreferences = this }
    }

    override fun getSecurePreferences() : SharedPreferences {
        return sharedPreferences ?: createSecurePreferences()
    }

    override fun getStringOrSet(key: String, valueToSet: String): String {
        val prefs = getSecurePreferences()
        val initialValue = prefs.getString(key, null)

        if (initialValue.isNullOrEmpty()) {
            prefs.edit(commit = true) { putString(key, valueToSet) }
        }

        return (initialValue ?: prefs.getString(key, valueToSet)).orEmpty()
    }
}