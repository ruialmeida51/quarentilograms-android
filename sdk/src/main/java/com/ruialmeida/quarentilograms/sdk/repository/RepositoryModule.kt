package com.ruialmeida.quarentilograms.sdk.repository

import com.ruialmeida.quarentilograms.sdk.koin.KoinModule
import com.ruialmeida.quarentilograms.sdk.repository.user.IUserRepository
import com.ruialmeida.quarentilograms.sdk.repository.user.UserRepository
import org.koin.dsl.module

object RepositoryModule : KoinModule {
    override fun getModule() = module {
        single<IUserRepository> { UserRepository(get(), get()) }
    }
}