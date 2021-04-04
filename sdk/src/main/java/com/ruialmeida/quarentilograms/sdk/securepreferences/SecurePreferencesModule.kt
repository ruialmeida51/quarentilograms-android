package com.ruialmeida.quarentilograms.sdk.securepreferences

import com.ruialmeida.quarentilograms.sdk.koin.KoinModule
import org.koin.core.module.Module
import org.koin.dsl.module

object SecurePreferencesModule : KoinModule {
    override fun getModule() = module {
        single<ISecurePreferences> { SecurePreferences(get()) }
    }
}