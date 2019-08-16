package com.dkkovalev.ctowt.di

import android.content.Context
import com.dkkovalev.ctowt.App
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun provideContext(application: App): Context = application.applicationContext
}