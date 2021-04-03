package com.ruialmeida.quarentilograms.features.newpost

import com.ruialmeida.quarentilograms.features.newpost.viewmodel.NewPostFragmentViewModel
import com.ruialmeida.quarentilograms.sdk.koin.KoinModule
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object NewPostModule : KoinModule {
    override fun getModule() = module {
        viewModel { NewPostFragmentViewModel() }
    }
}