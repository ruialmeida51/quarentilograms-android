package com.ruialmeida.quarentilograms.sdk.model.api

import com.google.gson.annotations.SerializedName
import com.ruialmeida.quarentilograms.sdk.model.local.LocalUserData

data class APIUser(
    @SerializedName("id") val uniqueUserId: Long,
    @SerializedName("fist_name") val firstName: String,
    @SerializedName("last_name") val lastName: String,
    @SerializedName("email") val email: String,
    @SerializedName("photo_url") val photoUrl: String
)

fun APIUser.toLocalUserData(): LocalUserData = LocalUserData(
    uniqueUserId = uniqueUserId,
    firstName = firstName,
    lastName = lastName,
    email = email,
    photoUrl = photoUrl
)