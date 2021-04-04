package com.ruialmeida.quarentilograms.sdk.utils.validator

import android.util.Patterns.EMAIL_ADDRESS

/**
 * An helper class that contains functions to validate the user credentials.
 */
object CredentialsValidator {
    /**
     * Defines the minimum amount of characters for the password.
     */
    private const val PASSWORD_MIN_CHAR_LIMIT = 5

    /**
     * Defines the maximum amount of characters for the password.
     */
    private const val PASSWORD_MAX_CHAR_LIMIT = 16

    /**
     * Validates the email according to [EMAIL_ADDRESS] android validator.
     */
    fun validateEmail(email: String): Boolean = EMAIL_ADDRESS.matcher(email).matches()

    /**
     * Validates the password according to length and special characters.
     */
    fun validatePassword(password: String): Boolean = password.length in PASSWORD_MIN_CHAR_LIMIT..PASSWORD_MAX_CHAR_LIMIT

    /**
     * Validates the name according to length and special characters.
     */
    fun validateName(name: String): Boolean = name.isNotEmpty()

    /**
     * Validates the username according to length and special characters.
     */
    fun validateUserName(username: String): Boolean = username.isNotEmpty()
}