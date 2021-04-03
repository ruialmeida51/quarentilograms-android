package com.ruialmeida.quarentilograms.features.feed

import com.ruialmeida.quarentilograms.features.feed.viewmodel.FeedFragmentViewModel
import com.ruialmeida.quarentilograms.sdk.koin.KoinModule
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object FeedModule : KoinModule {
    override fun getModule() = module {
        viewModel { FeedFragmentViewModel() }
    }
}