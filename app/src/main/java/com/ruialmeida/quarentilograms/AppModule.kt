package com.ruialmeida.quarentilograms

import com.ruialmeida.quarentilograms.features.FeaturesModule
import com.ruialmeida.quarentilograms.sdk.koin.KoinModule
import com.ruialmeida.quarentilograms.sdk.koin.KoinModuleList
import com.ruialmeida.quarentilograms.shared.SharedModule

object AppModule : KoinModuleList {
    override fun getModules() = FeaturesModule.getModules() + SharedModule.getModule()
}