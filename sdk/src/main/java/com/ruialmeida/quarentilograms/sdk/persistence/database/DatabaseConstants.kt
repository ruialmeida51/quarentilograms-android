package com.ruialmeida.quarentilograms.sdk.persistence.database

object DatabaseConstants {

    object Database {
        const val DB_NAME = "QuarentilogramsDB"
        const val VERSION = 1
    }

    object UserTable {
        const val TABLE_NAME = "id"
        const val PRIMARY_KEY_ID_COLUMN = "id"
        const val API_ID_COLUMN = "unique_id"
        const val NAME_COLUMN = "name"
        const val USERNAME_COLUMN = "username"
        const val EMAIL_COLUMN = "email"
        const val PROFILE_PHOTO_URL_COLUMN = "photo_url"
    }
}