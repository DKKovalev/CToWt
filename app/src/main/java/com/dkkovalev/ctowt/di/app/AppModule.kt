package com.dkkovalev.ctowt.di.app

import android.content.Context
import com.dkkovalev.ctowt.App
import dagger.Module
import dagger.Provides

@Module
internal class AppModule {
    @Provides
    fun providesContext(application: App): Context = application.applicationContext
}