package com.ruialmeida.quarentilograms.features.settings

import com.ruialmeida.quarentilograms.features.settings.viewmodel.SettingsFragmentViewModel
import com.ruialmeida.quarentilograms.sdk.koin.KoinModule
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

object SettingsModule : KoinModule {
    override fun getModule() = module {
        viewModel { SettingsFragmentViewModel() }
    }
}