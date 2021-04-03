package com.ruialmeida.quarentilograms.sdk.extensions.platform.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData

/**
 * Adapted from adbfara's library. Kudos for the amazing work!
 * @see <a href="https://github.com/adibfara/Lives/blob/master/lives/src/main/java/com/snakydesign/livedataextensions/Combining.kt">Check his amazing library here</a>
 */

/**
 * zips both of the LiveData and emits a value after both of them have emitted their values,
 * after that, emits values whenever both of them emit another value.
 *
 * The difference between combineLatest and zip is that the zip only emits after all LiveData
 * objects have a new value, but combineLatest will emit after any of them has a new value.
 */
fun <T1, T2, R> zip(
    source1: LiveData<T1>,
    source2: LiveData<T2>,
    combiner: (T1, T2) -> R
): LiveData<R> {
    val mediator = MediatorLiveData<R>()

    var source1Emitted = false
    var source2Emitted = false

    val combinerFunction = {
        val source1Value = source1.value
        val source2Value = source2.value

        if (source1Emitted && source2Emitted
            && source1Value != null && source2Value != null
        ) {

            source1Emitted = false
            source2Emitted = false

            mediator.value = combiner(source1Value, source2Value)
        }
    }

    mediator.addSource(source1) {
        source1Emitted = true
        combinerFunction()
    }
    mediator.addSource(source2) {
        source2Emitted = true
        combinerFunction()
    }

    return mediator
}

/**
 * zips three LiveData and emits a value after all of them have emitted their values,
 * after that, emits values whenever all of them emit another value.
 *
 * The difference between combineLatest and zip is that the zip only emits after all LiveData
 * objects have a new value, but combineLatest will emit after any of them has a new value.
 */
fun <T1, T2, T3, R> zip(
    source1: LiveData<T1>,
    source2: LiveData<T2>,
    source3: LiveData<T3>,
    combiner: (T1, T2, T3) -> R
): LiveData<R> {
    val mediator = MediatorLiveData<R>()

    var source1Emitted = false
    var source2Emitted = false
    var source3Emitted = false

    val combinerFunction = {
        val source1Value = source1.value
        val source2Value = source2.value
        val source3Value = source3.value

        if (source1Emitted && source2Emitted && source3Emitted
            && source1Value != null && source2Value != null && source3Value != null
        ) {
            source1Emitted = false
            source2Emitted = false
            source3Emitted = false

            mediator.value = combiner(source1Value, source2Value, source3Value)
        }
    }

    mediator.addSource(source1) {
        source1Emitted = true
        combinerFunction()
    }

    mediator.addSource(source2) {
        source2Emitted = true
        combinerFunction()
    }

    mediator.addSource(source3) {
        source3Emitted = true
        combinerFunction()
    }

    return mediator
}