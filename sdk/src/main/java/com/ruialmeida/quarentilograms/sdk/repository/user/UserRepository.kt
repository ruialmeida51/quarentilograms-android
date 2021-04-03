package com.ruialmeida.quarentilograms.sdk.repository.user

import com.ruialmeida.quarentilograms.sdk.model.local.LocalUserData
import com.ruialmeida.quarentilograms.sdk.network.service.service.UserService
import com.ruialmeida.quarentilograms.sdk.persistence.localdatasource.user.IUserLocalDataSource
import com.ruialmeida.quarentilograms.sdk.repository.base.BaseRepositoryWrapper

class UserRepository(
    private val localDataSource: IUserLocalDataSource, private val userService: UserService
) : IUserRepository, BaseRepositoryWrapper<LocalUserData, IUserLocalDataSource, UserService>(localDataSource, userService) {

    override suspend fun findById(id: Long): LocalUserData {
        return localDataSource.findById(id)
    }

    override suspend fun findAll(): List<LocalUserData> {
        return listOf()
    }
}