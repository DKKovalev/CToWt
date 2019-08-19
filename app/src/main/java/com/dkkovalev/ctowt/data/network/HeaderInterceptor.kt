package com.dkkovalev.ctowt.data.network

import okhttp3.Interceptor

const val CLIENT_ID = "Client-ID"

fun clientIdHeader(id: String) = Interceptor { chain ->
    val original = chain.request()
    val request = original.newBuilder()
        .header(CLIENT_ID, id)
        .method(original.method(), original.body())
        .build()
    chain.proceed(request)
}