package com.dkkovalev.ctowt.di.app

import android.content.Context
import com.dkkovalev.ctowt.BuildConfig
import com.dkkovalev.ctowt.data.network.MixerApiService
import com.dkkovalev.ctowt.data.network.TwitchApiService
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

private const val TIMEOUT: Long = 120
private const val CACHE_SIZE: Long = 10 * 1024 * 1024

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun providesTwitchApiService(retrofit: Retrofit.Builder): TwitchApiService =
        retrofit.baseUrl(BuildConfig.TWITCH_ENDPOINT).build().create<TwitchApiService>(TwitchApiService::class.java)

    @Provides
    @Singleton
    fun providesMixerApiService(retrofit: Retrofit.Builder): MixerApiService =
        retrofit.baseUrl(BuildConfig.MIXER_ENDPOINT).build().create<MixerApiService>(MixerApiService::class.java)

    @Provides
    @Singleton
    fun providesTwitchRetrofit(okHttpClient: OkHttpClient): Retrofit.Builder = Retrofit.Builder().apply {
        addConverterFactory(GsonConverterFactory.create())
        client(okHttpClient)
    }

    @Provides
    @Singleton
    fun providesOkHttpClient(cache: Cache): OkHttpClient = OkHttpClient.Builder().apply {
        cache(cache)
        connectTimeout(TIMEOUT, TimeUnit.SECONDS)
        writeTimeout(TIMEOUT, TimeUnit.SECONDS)
        readTimeout(TIMEOUT, TimeUnit.SECONDS)
        addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY })
    }.build()

    @Provides
    @Singleton
    fun providesCache(context: Context): Cache = Cache(context.cacheDir, CACHE_SIZE)
}