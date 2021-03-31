package com.ruialmeida.quarentilograms.sdk.persistence.database

import android.app.Application
import androidx.room.Room
import com.ruialmeida.quarentilograms.sdk.persistence.database.DatabaseConstants.Database

class DatabaseProvider(private val androidApplication: Application) : IDatabaseProvider {
    override fun getDatabase(): QuarentilogramsDatabase = Room.databaseBuilder(
        androidApplication,
        QuarentilogramsDatabase::class.java,
        Database.DB_NAME
    ).build()
}

