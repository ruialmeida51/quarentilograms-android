package com.ruialmeida.quarentilograms.sdk.network.client

import okhttp3.OkHttpClient
import retrofit2.Retrofit

interface INetworkClient {
    /**
     * Returns the instance of our http client and appends the interceptors.
     */
    fun getHTTPClient(): OkHttpClient

    /**
     * Builds our retrofit client using our http client.
     */
    fun getRetrofit(): Retrofit
}