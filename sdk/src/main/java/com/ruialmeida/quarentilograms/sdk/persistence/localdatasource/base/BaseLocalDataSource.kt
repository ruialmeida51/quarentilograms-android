package com.ruialmeida.quarentilograms.sdk.persistence.localdatasource.base

import com.ruialmeida.quarentilograms.sdk.persistence.dao.BaseDao

open class BaseLocalDataSource<T>(private val dao: BaseDao<T>) : IBaseLocalDataSource<T> {
    override suspend fun insert(item: T): Long = dao.insert(item)
    override suspend fun insertAll(items: List<T>): List<Long> = dao.insertAll(items)

    override suspend fun update(item: T) = dao.update(item)
    override suspend fun updateAll(items: List<T>) = dao.updateAll(items)

    override suspend fun delete(item: T) = dao.delete(item)
    override suspend fun deleteAll(items: List<T>) = dao.deleteAll(items)

    override suspend fun upsert(item: T) {
        val id = insert(item)
        if (id == -1L) update(item)
    }

    override suspend fun upsert(items: List<T>) {
        val insertResult = insertAll(items)
        val updateList = mutableListOf<T>()

        for (i in insertResult.indices) {
            if (insertResult[i] == -1L) updateList.add(items[i])
        }

        if (updateList.isNotEmpty()) updateAll(updateList)
    }
}