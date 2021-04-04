package com.ruialmeida.quarentilograms.sdk.securepreferences

import android.content.SharedPreferences
import java.util.*

/**
 * An helper class to retrieve and create secure preferences by encrypting
 * the user data.
 */
interface ISecurePreferences {

    /**
     * Names of the keys to save our data.
     */
    companion object Keys {
        const val USER_UUID = "USER_IDENTIFIER"
    }

    fun getSecurePreferences() : SharedPreferences
    fun getStringOrSet(key: String, valueToSet: String): String
}