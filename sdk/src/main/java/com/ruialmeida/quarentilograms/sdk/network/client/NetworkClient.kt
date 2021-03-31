package com.ruialmeida.quarentilograms.sdk.network.client

import com.ruialmeida.quarentilograms.sdk.BuildConfig
import com.ruialmeida.quarentilograms.sdk.network.interceptor.AuthenticationInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkClient : INetworkClient {

    override fun getHTTPClient(): OkHttpClient = OkHttpClient().newBuilder()
        .addInterceptor(AuthenticationInterceptor())
        .build()

    override fun getRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.API_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(getHTTPClient())
        .build()

}