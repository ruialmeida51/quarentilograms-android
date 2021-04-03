package com.ruialmeida.quarentilograms.sdk.model.api

import com.google.gson.annotations.SerializedName
import com.ruialmeida.quarentilograms.sdk.model.local.LocalUserData

data class APIUser(
    @SerializedName("id") val uniqueUserId: Long,
    @SerializedName("name") val name: String,
    @SerializedName("username") val userName: String,
    @SerializedName("email") val email: String,
    @SerializedName("photo_url") val photoUrl: String
)

fun APIUser.toLocalUserData(): LocalUserData = LocalUserData(
    uniqueUserId = uniqueUserId,
    name = name,
    userName = userName,
    email = email,
    photoUrl = photoUrl
)