package com.ruialmeida.quarentilograms.sdk.network.service.service

import com.ruialmeida.quarentilograms.sdk.model.api.APIUser
import retrofit2.http.GET

interface UserService {

    @GET("users/{id}")
    suspend fun retrieveUserById(id: Long): APIUser?

    @GET("users/")
    suspend fun retrieveUsers(): List<APIUser>?
}