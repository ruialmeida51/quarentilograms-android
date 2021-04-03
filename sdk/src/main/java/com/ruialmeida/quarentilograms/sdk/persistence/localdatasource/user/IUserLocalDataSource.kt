package com.ruialmeida.quarentilograms.sdk.persistence.localdatasource.user

import com.ruialmeida.quarentilograms.sdk.model.local.LocalUserData
import com.ruialmeida.quarentilograms.sdk.persistence.localdatasource.base.IBaseLocalDataSource

interface IUserLocalDataSource : IBaseLocalDataSource<LocalUserData> {
    /**
     * Returns all of the users present in the database.
     */
    suspend fun findAll(): List<LocalUserData>?

    /**
     * Returns the user present in the database with the specified id.
     *
     * @param userId - the user of the id to search
     */
    suspend fun findById(userId: Long): LocalUserData?
}
