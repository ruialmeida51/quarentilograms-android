package com.ruialmeida.quarentilograms.sdk.repository.base

import com.ruialmeida.quarentilograms.sdk.persistence.localdatasource.base.IBaseLocalDataSource

open class BaseRepositoryWrapper<RepositoryItem, DaoType : IBaseLocalDataSource<RepositoryItem>, ServiceType>(
    private val localDataSource: DaoType,
    private val service: ServiceType
) : IBaseRepositoryWrapper<RepositoryItem> {

    override suspend fun insertLocalDataSource(item: RepositoryItem): Long = localDataSource.insert(item)
    override suspend fun insertAllLocalDataSource(items: List<RepositoryItem>): List<Long> = localDataSource.insertAll(items)

    override suspend fun updateLocalDataSource(item: RepositoryItem) = localDataSource.update(item)
    override suspend fun updateAllLocalDataSource(items: List<RepositoryItem>) = localDataSource.updateAll(items)

    override suspend fun deleteLocalDataSource(item: RepositoryItem) = localDataSource.delete(item)
    override suspend fun deleteAllLocalDataSource(items: List<RepositoryItem>) = localDataSource.deleteAll(items)

    override suspend fun upsertLocalDataSource(item: RepositoryItem) = localDataSource.upsert(item)
    override suspend fun upsertLocalDataSource(items: List<RepositoryItem>) = localDataSource.upsert(items)
}