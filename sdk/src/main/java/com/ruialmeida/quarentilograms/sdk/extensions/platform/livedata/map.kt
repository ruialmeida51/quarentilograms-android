package com.ruialmeida.quarentilograms.sdk.extensions.platform.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData

/**
 * Calls the mapper [func] everytime this live data emits a value.
 */
fun <X, Y> LiveData<X>.map(func: (X?) -> Y?): MutableLiveData<Y?> {
    return MediatorLiveData<Y>().apply {
        addSource(this@map) { x -> value = func(x) }
    }
}

/**
 * Calls the mapper [func] everytime this live data emits a non-null value.
 */
fun <X, Y> LiveData<X>.mapNonNull(func: (X) -> Y): MutableLiveData<Y> {
    return MediatorLiveData<Y>().apply {
        addSource(this@mapNonNull) { x ->
            x ?: return@addSource
            value = func(x)
        }
    }
}