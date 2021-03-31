package com.ruialmeida.quarentilograms.sdk.network.service.provider

import com.ruialmeida.quarentilograms.sdk.network.service.service.LoginService
import retrofit2.Retrofit

class ServiceProvider(private val retrofit: Retrofit) : IServiceProvider {

    override fun getLoginService(): LoginService = retrofit.create(LoginService::class.java)

}