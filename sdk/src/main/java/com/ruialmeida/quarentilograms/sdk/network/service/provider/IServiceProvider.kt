package com.ruialmeida.quarentilograms.sdk.network.service.provider

import com.ruialmeida.quarentilograms.sdk.network.service.service.LoginService

/**
 * Holds the actual available endpoints
 */
interface IServiceProvider {
    fun getLoginService(): LoginService
}