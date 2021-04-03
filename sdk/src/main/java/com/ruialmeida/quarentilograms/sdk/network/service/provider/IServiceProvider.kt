package com.ruialmeida.quarentilograms.sdk.network.service.provider

import com.ruialmeida.quarentilograms.sdk.network.service.service.UserService

/**
 * Holds the actual available endpoints
 */
interface IServiceProvider {
    fun getLoginService(): UserService
}