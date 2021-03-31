package com.ruialmeida.quarentilograms.sdk.persistence.database

/**
 * Provides the necessary items related to database creation.
 */
interface IDatabaseProvider {
    /**
     * Returns and creates our local database [QuarentilogramsDatabase]
     */
    fun getDatabase() : QuarentilogramsDatabase
}