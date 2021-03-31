package com.ruialmeida.quarentilograms.sdk.persistence.localdatasource.user

import com.ruialmeida.quarentilograms.sdk.model.local.LocalUserData
import com.ruialmeida.quarentilograms.sdk.persistence.dao.UserDao
import com.ruialmeida.quarentilograms.sdk.persistence.localdatasource.base.BaseLocalDataSource

class UserLocalDataSource(private val userDao: UserDao) : IUserLocalDataSource, BaseLocalDataSource<LocalUserData>(userDao) {
    override suspend fun findAll(): List<LocalUserData> = userDao.findAll()
}