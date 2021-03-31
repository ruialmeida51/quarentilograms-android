package com.ruialmeida.quarentilograms.sdk.network.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class AuthenticationInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var req = chain.request()

        val url = req.url().newBuilder().addQueryParameter("APPID", "your_key_here").build()

        req = req.newBuilder().url(url).build()
        return chain.proceed(req)
    }

}