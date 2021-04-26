package com.ruialmeida.quarentilograms.features.friends

import com.ruialmeida.quarentilograms.features.friends.viewmodel.FriendsFragmentViewModel
import com.ruialmeida.quarentilograms.sdk.koin.KoinModule
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object FriendsModule : KoinModule {
    override fun getModule() = module {
        viewModel { FriendsFragmentViewModel() }
    }
}