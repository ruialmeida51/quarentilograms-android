package com.ruialmeida.quarentilograms.features.homepage.state

data class HomePageErrorState(
    val errorType: HomePageErrorTypes? = null
) {
    sealed class HomePageErrorTypes {
        object FetchError: HomePageErrorTypes()
    }
}
