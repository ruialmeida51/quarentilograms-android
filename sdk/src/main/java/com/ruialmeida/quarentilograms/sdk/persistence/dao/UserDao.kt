package com.ruialmeida.quarentilograms.sdk.persistence.dao

import androidx.room.Dao
import androidx.room.Query
import com.ruialmeida.quarentilograms.sdk.model.local.LocalUserData
import com.ruialmeida.quarentilograms.sdk.persistence.database.DatabaseConstants.UserTable

@Dao
interface UserDao : BaseDao<LocalUserData> {
    /**
     * Returns all of the users present in the database.
     */
    @Query("SELECT * FROM ${UserTable.TABLE_NAME}")
    suspend fun findAll(): List<LocalUserData>

    /**
     * Returns the user with the specified if it exists.
     */
    @Query("SELECT * FROM ${UserTable.TABLE_NAME} WHERE ${UserTable.PRIMARY_KEY_ID_COLUMN} =:userId")
    suspend fun findById(userId: Long): LocalUserData
}