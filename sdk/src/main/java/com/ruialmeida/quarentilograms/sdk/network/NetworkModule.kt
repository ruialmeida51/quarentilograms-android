package com.ruialmeida.quarentilograms.sdk.network

import com.ruialmeida.quarentilograms.sdk.koin.KoinModule
import com.ruialmeida.quarentilograms.sdk.network.client.INetworkClient
import com.ruialmeida.quarentilograms.sdk.network.client.NetworkClient
import com.ruialmeida.quarentilograms.sdk.network.service.provider.IServiceProvider
import com.ruialmeida.quarentilograms.sdk.network.service.provider.ServiceProvider
import com.ruialmeida.quarentilograms.sdk.network.service.service.LoginService
import org.koin.androidx.compose.get
import org.koin.dsl.module

object NetworkModule: KoinModule {
    override fun getModule() = module {
        single<INetworkClient> { NetworkClient() }
        single<IServiceProvider> { ServiceProvider(get<INetworkClient>().getRetrofit()) }

        factory { get<IServiceProvider>().getLoginService() }
    }
}