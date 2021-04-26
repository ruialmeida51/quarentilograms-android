package com.ruialmeida.quarentilograms.features.dms

import com.ruialmeida.quarentilograms.features.dms.viewmodel.DmsFragmentViewModel
import com.ruialmeida.quarentilograms.sdk.koin.KoinModule
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object DmsModule : KoinModule {
    override fun getModule() = module {
        viewModel { DmsFragmentViewModel() }
    }
}