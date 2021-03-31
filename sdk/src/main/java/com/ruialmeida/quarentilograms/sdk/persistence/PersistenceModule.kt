package com.ruialmeida.quarentilograms.sdk.persistence

import com.ruialmeida.quarentilograms.sdk.koin.KoinModule
import com.ruialmeida.quarentilograms.sdk.persistence.database.DatabaseProvider
import com.ruialmeida.quarentilograms.sdk.persistence.database.QuarentilogramsDatabase
import com.ruialmeida.quarentilograms.sdk.persistence.localdatasource.user.IUserLocalDataSource
import com.ruialmeida.quarentilograms.sdk.persistence.localdatasource.user.UserLocalDataSource
import org.koin.dsl.module

object PersistenceModule : KoinModule {
    override fun getModule() = module {
        single { DatabaseProvider(get()).getDatabase() }

        single<IUserLocalDataSource> { UserLocalDataSource(get<QuarentilogramsDatabase>().userDAO()) }
    }
}