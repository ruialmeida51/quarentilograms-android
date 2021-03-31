package com.ruialmeida.quarentilograms.sdk.persistence.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ruialmeida.quarentilograms.sdk.model.local.LocalUserData
import com.ruialmeida.quarentilograms.sdk.persistence.dao.UserDao
import com.ruialmeida.quarentilograms.sdk.persistence.database.DatabaseConstants.Database as DatabaseConstants

@Database(
    entities = [LocalUserData::class],
    version = DatabaseConstants.VERSION,
    exportSchema = false
)
abstract class QuarentilogramsDatabase : RoomDatabase() {

    abstract fun userDAO(): UserDao
}