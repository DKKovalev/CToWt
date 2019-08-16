package com.dkkovalev.ctowt.di

import com.dkkovalev.ctowt.presentation.MainActivity
import com.dkkovalev.ctowt.presentation.screen.browse.BrowseModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = [BrowseModule::class])
    abstract fun mainActivity(): MainActivity
}