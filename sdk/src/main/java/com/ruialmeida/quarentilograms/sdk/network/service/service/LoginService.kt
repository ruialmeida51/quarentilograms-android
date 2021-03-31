package com.ruialmeida.quarentilograms.sdk.network.service.service

import com.ruialmeida.quarentilograms.sdk.model.api.APIUser
import retrofit2.http.GET

interface LoginService {

    @GET
    suspend fun testFunction(): APIUser

}