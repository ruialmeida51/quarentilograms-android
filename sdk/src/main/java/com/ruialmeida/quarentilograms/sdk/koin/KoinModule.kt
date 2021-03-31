package com.ruialmeida.quarentilograms.sdk.koin

import org.koin.core.module.Module

/**
 * Enforces that whatever class implements this interface must return a koin [Module]
 */
interface KoinModule {
    fun getModule(): Module
}