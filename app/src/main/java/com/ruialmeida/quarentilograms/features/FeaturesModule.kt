package com.ruialmeida.quarentilograms.features

import com.ruialmeida.quarentilograms.features.login.LoginModule
import com.ruialmeida.quarentilograms.features.register.RegisterModule
import com.ruialmeida.quarentilograms.sdk.koin.KoinModuleList

object FeaturesModule : KoinModuleList {
    override fun getModules() = LoginModule.getModule() + RegisterModule.getModule()
}