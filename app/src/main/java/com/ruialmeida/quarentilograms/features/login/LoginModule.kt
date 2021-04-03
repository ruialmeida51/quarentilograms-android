package com.ruialmeida.quarentilograms.features.login

import com.ruialmeida.quarentilograms.features.login.viewmodel.LoginFragmentViewModel
import com.ruialmeida.quarentilograms.sdk.koin.KoinModule
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

object LoginModule : KoinModule {
    override fun getModule() = module {
        viewModel { LoginFragmentViewModel() }
    }
}