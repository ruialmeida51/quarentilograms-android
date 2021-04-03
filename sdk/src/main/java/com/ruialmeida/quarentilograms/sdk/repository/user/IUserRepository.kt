package com.ruialmeida.quarentilograms.sdk.repository.user

import com.ruialmeida.quarentilograms.sdk.model.local.LocalUserData
import com.ruialmeida.quarentilograms.sdk.repository.base.IBaseRepositoryWrapper

interface IUserRepository : IBaseRepositoryWrapper<LocalUserData> {
    /**
     * Finds the item by id either by calling the network or retrieving one
     * stored locally.
     *
     * @param id the id of the object [LocalUserData]
     */
    suspend fun findById(id: Long): LocalUserData?

    /**
     * Finds all of the items either by calling the network or retrieving one
     * stored locally.
     */
    suspend fun findAll(): List<LocalUserData>?
}