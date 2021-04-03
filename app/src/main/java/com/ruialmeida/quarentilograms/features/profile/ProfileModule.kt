package com.ruialmeida.quarentilograms.features.profile

import com.ruialmeida.quarentilograms.features.profile.viewmodel.ProfileFragmentViewModel
import com.ruialmeida.quarentilograms.sdk.koin.KoinModule
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object ProfileModule : KoinModule {
    override fun getModule() = module {
        viewModel { ProfileFragmentViewModel() }
    }
}