package com.ruialmeida.quarentilograms.sdk.koin

import org.koin.core.module.Module

/**
 * Enforces that whatever class implements this interface must return a list of koin [Module]
 */
interface KoinModuleList {
    fun getModules(): List<Module>
}