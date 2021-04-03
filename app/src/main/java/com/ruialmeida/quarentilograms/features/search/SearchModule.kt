package com.ruialmeida.quarentilograms.features.search

import com.ruialmeida.quarentilograms.features.search.viewmodel.SearchFragmentViewModel
import com.ruialmeida.quarentilograms.sdk.koin.KoinModule
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object SearchModule : KoinModule {
    override fun getModule() = module {
        viewModel { SearchFragmentViewModel() }
    }
}