package com.ruialmeida.quarentilograms.features.register

import com.ruialmeida.quarentilograms.features.register.viewmodel.RegisterFragmentViewModel
import com.ruialmeida.quarentilograms.sdk.koin.KoinModule
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object RegisterModule : KoinModule {
    override fun getModule() = module {
        viewModel { RegisterFragmentViewModel() }
    }
}