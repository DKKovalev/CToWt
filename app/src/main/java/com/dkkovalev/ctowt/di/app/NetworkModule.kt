package com.dkkovalev.ctowt.di.app

import android.content.Context
import com.dkkovalev.ctowt.BuildConfig
import com.dkkovalev.ctowt.data.network.MixerApiService
import com.dkkovalev.ctowt.data.network.TwitchApiService
import com.dkkovalev.ctowt.data.network.clientIdHeader
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

private const val TIMEOUT: Long = 120
private const val CACHE_SIZE: Long = 10 * 1024 * 1024

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun providesTwitchApiService(@Named("Twitch") retrofit: Retrofit.Builder): TwitchApiService =
        retrofit.baseUrl(BuildConfig.TWITCH_ENDPOINT).build().create(TwitchApiService::class.java)

    @Provides
    @Singleton
    fun providesMixerApiService(@Named("Mixer") retrofit: Retrofit.Builder): MixerApiService =
        retrofit.baseUrl(BuildConfig.MIXER_ENDPOINT).build().create(MixerApiService::class.java)

    @Provides
    @Singleton
    @Named("Twitch")
    fun providesTwitchRetrofit(@Named("Twitch") okHttpClient: OkHttpClient): Retrofit.Builder =
        Retrofit.Builder().apply {
            addConverterFactory(GsonConverterFactory.create())
            client(okHttpClient)
        }

    @Provides
    @Singleton
    @Named("Mixer")
    fun providesMixerRetrofit(@Named("Mixer") okHttpClient: OkHttpClient): Retrofit.Builder =
        Retrofit.Builder().apply {
            addConverterFactory(GsonConverterFactory.create())
            client(okHttpClient)
        }

    @Provides
    @Singleton
    @Named("Twitch")
    fun providesTwitchOkHttpClient(cache: Cache): OkHttpClient = OkHttpClient.Builder().apply {
        cache(cache)
        addInterceptor(clientIdHeader(BuildConfig.TWITCH_CLIENT_ID))
        connectTimeout(TIMEOUT, TimeUnit.SECONDS)
        writeTimeout(TIMEOUT, TimeUnit.SECONDS)
        readTimeout(TIMEOUT, TimeUnit.SECONDS)
        addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY })
    }.build()

    @Provides
    @Singleton
    @Named("Mixer")
    fun providesMixerOkHttpClient(cache: Cache): OkHttpClient = OkHttpClient.Builder().apply {
        cache(cache)
        addInterceptor(clientIdHeader(BuildConfig.MIXER_CLIENT_ID))
        connectTimeout(TIMEOUT, TimeUnit.SECONDS)
        writeTimeout(TIMEOUT, TimeUnit.SECONDS)
        readTimeout(TIMEOUT, TimeUnit.SECONDS)
        addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY })
    }.build()

    @Provides
    @Singleton
    fun providesCache(context: Context): Cache = Cache(context.cacheDir, CACHE_SIZE)
}