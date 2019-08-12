package com.dkkovalev.ctowt.di

import android.content.Context
import com.dkkovalev.ctowt.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {
    @Provides
    @Singleton
    fun providesContext(application: App): Context = application.applicationContext
}