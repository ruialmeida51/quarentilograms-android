package com.ruialmeida.quarentilograms.features.authentication

import com.ruialmeida.quarentilograms.features.authentication.viewmodel.AuthenticationActivityViewModel
import com.ruialmeida.quarentilograms.sdk.koin.KoinModule
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object AuthenticationModule  : KoinModule {
    override fun getModule() = module {
        viewModel { AuthenticationActivityViewModel() }
    }
}