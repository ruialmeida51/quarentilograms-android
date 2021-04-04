package com.ruialmeida.quarentilograms.sdk

import com.ruialmeida.quarentilograms.sdk.analytics.AnalyticsModule
import com.ruialmeida.quarentilograms.sdk.koin.KoinModuleList
import com.ruialmeida.quarentilograms.sdk.network.NetworkModule
import com.ruialmeida.quarentilograms.sdk.persistence.PersistenceModule
import com.ruialmeida.quarentilograms.sdk.repository.RepositoryModule
import com.ruialmeida.quarentilograms.sdk.securepreferences.SecurePreferencesModule

object SdkModule : KoinModuleList {
    override fun getModules() = NetworkModule.getModule() +
            PersistenceModule.getModule() +
            RepositoryModule.getModule() +
            SecurePreferencesModule.getModule() +
            AnalyticsModule.getModule()
}