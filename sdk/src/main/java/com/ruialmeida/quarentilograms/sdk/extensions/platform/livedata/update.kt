package com.ruialmeida.quarentilograms.sdk.extensions.platform.livedata

import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

/**
 * If the function call is made on the UI thread this will call the
 * [LiveData.setValue] method, otherwise calls the [LiveData.postValue] method.
 */
fun <T> MutableLiveData<T>.update(newValue: T) {
    // if this returns true, then you're on the UI thread!
    if (Looper.myLooper() == Looper.getMainLooper()) {
        value = newValue
    } else {
        postValue(newValue)
    }
}