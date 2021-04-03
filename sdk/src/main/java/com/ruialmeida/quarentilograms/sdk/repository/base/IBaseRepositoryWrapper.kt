package com.ruialmeida.quarentilograms.sdk.repository.base

interface IBaseRepositoryWrapper<RepositoryType> {
    /**
     * Insert an object in the database.
     *
     * @param item the object to be inserted.
     */
    suspend fun insertLocalDataSource(item: RepositoryType): Long

    /**
     * Insert a list of objects in the database.
     *
     * @param items the objects to be inserted.
     */
    suspend fun insertAllLocalDataSource(items: List<RepositoryType>): List<Long>

    /**
     * Update an object in the database.
     *
     * @param item the object to be updated.
     */
    suspend fun updateLocalDataSource(item: RepositoryType)

    /**
     * Update a list of objects in the database.
     *
     * @param items the objects to be updated.
     */
    suspend fun updateAllLocalDataSource(items: List<RepositoryType>)

    /**
     * Delete an object in the database.
     *
     * @param item the object to be deleted.
     */
    suspend fun deleteLocalDataSource(item: RepositoryType)

    /**
     * Delete a list of objects in the database.
     *
     * @param items the objects to be deleted.
     */
    suspend fun deleteAllLocalDataSource(items: List<RepositoryType>)

    /**
     * Insert or update an object in the database.
     *
     * @param item the item to be upserted
     */
    suspend fun upsertLocalDataSource(item: RepositoryType)

    /**
     * Insert or update a list of objects in the database.
     *
     * @param items the items to be upserted
     */
    suspend fun upsertLocalDataSource(items: List<RepositoryType>)
}