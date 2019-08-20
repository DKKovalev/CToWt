package com.dkkovalev.ctowt.di.app

import com.dkkovalev.ctowt.di.ActivityScoped
import com.dkkovalev.ctowt.presentation.MainActivity
import com.dkkovalev.ctowt.presentation.screen.browse.BrowseModule
import com.dkkovalev.ctowt.presentation.screen.streams.StreamsModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {
    @ActivityScoped
    @ContributesAndroidInjector(
        modules = [
            BrowseModule::class,
            StreamsModule::class
        ]
    )
    internal abstract fun contributesMainActivity(): MainActivity
}