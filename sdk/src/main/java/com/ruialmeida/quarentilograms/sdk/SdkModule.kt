package com.ruialmeida.quarentilograms.sdk

import com.ruialmeida.quarentilograms.sdk.analytics.AnalyticsModule
import com.ruialmeida.quarentilograms.sdk.koin.KoinModule
import com.ruialmeida.quarentilograms.sdk.koin.KoinModuleList
import com.ruialmeida.quarentilograms.sdk.network.NetworkModule
import com.ruialmeida.quarentilograms.sdk.persistence.PersistenceModule
import com.ruialmeida.quarentilograms.sdk.repository.RepositoryModule
import org.koin.core.module.Module
import org.koin.dsl.module

object SdkModule : KoinModuleList {
    override fun getModules() = NetworkModule.getModule() +
            PersistenceModule.getModule() +
            RepositoryModule.getModule() +
            AnalyticsModule.getModule()
}