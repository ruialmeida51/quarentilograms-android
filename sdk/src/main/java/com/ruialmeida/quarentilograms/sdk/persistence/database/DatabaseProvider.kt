package com.ruialmeida.quarentilograms.sdk.persistence.database

import android.app.Application
import androidx.room.Room
import com.ruialmeida.quarentilograms.sdk.extensions.koin.inject
import com.ruialmeida.quarentilograms.sdk.persistence.database.DatabaseConstants.Database
import com.ruialmeida.quarentilograms.sdk.securepreferences.ISecurePreferences
import net.sqlcipher.database.SQLiteDatabase.getBytes
import net.sqlcipher.database.SupportFactory
import java.util.UUID

class DatabaseProvider(private val androidApplication: Application) : IDatabaseProvider {

    private val securePreferences by inject<ISecurePreferences>()

    override fun getDatabase(): QuarentilogramsDatabase {
        val passPhrase = securePreferences.getStringOrSet(ISecurePreferences.USER_UUID, UUID.randomUUID().toString())
        val sqLitePassPhrase = getBytes(passPhrase.toCharArray())
        val sqLiteFactory = SupportFactory(sqLitePassPhrase)

        return Room.databaseBuilder(androidApplication, QuarentilogramsDatabase::class.java, Database.DB_NAME)
            .openHelperFactory(sqLiteFactory)
            .fallbackToDestructiveMigration()
            .build()
    }
}