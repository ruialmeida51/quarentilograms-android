package com.ruialmeida.quarentilograms.sdk.persistence.dao

import androidx.room.*

@Dao
interface BaseDao<T> {
    /**
     * Insert an object in the database.
     *
     * @param item the object to be inserted.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: T): Long

    /**
     * Insert a list of objects in the database.
     *
     * @param items the objects to be inserted.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(items: List<T>): List<Long>

    /**
     * Update an object in the database.
     *
     * @param item the object to be updated.
     */
    @Update
    suspend fun update(item: T)

    /**
     * Update a list of objects in the database.
     *
     * @param items the objects to be updated.
     */
    @Update
    suspend fun updateAll(items: List<T>)

    /**
     * Delete an object in the database.
     *
     * @param item the object to be deleted.
     */
    @Delete
    suspend fun delete(item: T)

    /**
     * Delete a list of objects in the database.
     *
     * @param items the objects to be deleted.
     */
    @Delete
    suspend fun deleteAll(items: List<T>)
}