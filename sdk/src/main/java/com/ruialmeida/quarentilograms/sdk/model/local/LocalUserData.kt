package com.ruialmeida.quarentilograms.sdk.model.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ruialmeida.quarentilograms.sdk.persistence.database.DatabaseConstants.UserTable

@Entity(tableName = UserTable.TABLE_NAME)
data class LocalUserData(
    @PrimaryKey
    @ColumnInfo(name = UserTable.PRIMARY_KEY_ID_COLUMN)
    val id: Long = -1,

    @ColumnInfo(name = UserTable.API_ID_COLUMN)
    val uniqueUserId: Long,

    @ColumnInfo(name = UserTable.NAME_COLUMN)
    val name: String,

    @ColumnInfo(name = UserTable.USERNAME_COLUMN)
    val userName: String,

    @ColumnInfo(name = UserTable.EMAIL_COLUMN)
    val email: String,

    @ColumnInfo(name = UserTable.PROFILE_PHOTO_URL_COLUMN)
    val photoUrl: String
)