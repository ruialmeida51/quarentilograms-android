package com.ruialmeida.quarentilograms.sdk.network.service.provider

import com.ruialmeida.quarentilograms.sdk.network.service.service.UserService
import retrofit2.Retrofit

class ServiceProvider(private val retrofit: Retrofit) : IServiceProvider {

    override fun getLoginService(): UserService = retrofit.create(UserService::class.java)

}