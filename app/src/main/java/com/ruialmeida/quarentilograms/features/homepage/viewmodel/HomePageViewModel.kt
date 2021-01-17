package com.ruialmeida.quarentilograms.features.homepage.viewmodel

import android.util.Log
import com.ruialmeida.lumbridgelibrary.extensions.platform.coroutines.*
import com.ruialmeida.lumbridgelibrary.viewmodel.base.BaseStatefulViewModel
import com.ruialmeida.quarentilograms.features.homepage.state.HomePageErrorState
import com.ruialmeida.quarentilograms.features.homepage.state.HomePageState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*

class HomePageViewModel : BaseStatefulViewModel<HomePageState, HomePageErrorState>() {

    companion object {
        private sealed class HomePageClickActions {
            object ExampleClick: HomePageClickActions()
            object ExampleClick2: HomePageClickActions()
        }
    }

    override fun getDefaultState(): HomePageState = HomePageState()

    override fun setup() {
        updateState(getDefaultState())
    }

    fun bindClick(
        sampleClick: Flow<Unit>,
        sampleClick2: Flow<Unit>
    ) {

        listOf(
            sampleClick.map { HomePageClickActions.ExampleClick },
            sampleClick2.map { HomePageClickActions.ExampleClick2 }
        ).merge().throttle().onEach { actions ->
            when(actions) {
                HomePageClickActions.ExampleClick -> { Log.d("TaggyTag", "Tootoo 1") }
                HomePageClickActions.ExampleClick2 ->  { Log.d("TaggyTag", "Tootoo 2") }
            }
        }.flowOnMain().launchOnIO()
    }

    override fun getDefaultErrorState(): HomePageErrorState = HomePageErrorState()

}