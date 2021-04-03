package com.ruialmeida.quarentilograms.features.authenticated

import com.ruialmeida.quarentilograms.features.authenticated.viewmodel.AuthenticatedActivityViewModel
import com.ruialmeida.quarentilograms.sdk.koin.KoinModule
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

object AuthenticatedModule : KoinModule {
    override fun getModule() = module {
        viewModel { AuthenticatedActivityViewModel() }
    }
}