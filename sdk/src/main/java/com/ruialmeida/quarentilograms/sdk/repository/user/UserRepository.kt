package com.ruialmeida.quarentilograms.sdk.repository.user

import com.ruialmeida.quarentilograms.sdk.model.api.toLocalUserData
import com.ruialmeida.quarentilograms.sdk.model.local.LocalUserData
import com.ruialmeida.quarentilograms.sdk.network.service.service.UserService
import com.ruialmeida.quarentilograms.sdk.persistence.localdatasource.user.IUserLocalDataSource
import com.ruialmeida.quarentilograms.sdk.repository.base.BaseRepositoryWrapper

class UserRepository(
    private val localDataSource: IUserLocalDataSource, private val userService: UserService
) : IUserRepository, BaseRepositoryWrapper<LocalUserData, IUserLocalDataSource, UserService>(localDataSource, userService) {

    override suspend fun findById(id: Long): LocalUserData? {
        return localDataSource.findById(id)
            ?: userService.retrieveUserById(id)?.toLocalUserData()
    }

    override suspend fun findAll(): List<LocalUserData>? {
        var userList = localDataSource.findAll()

        if (userList.isNullOrEmpty()) {
            userList = userService.retrieveUsers()?.map {
                it.toLocalUserData()
            }
        }

        return userList
    }
}