package com.dkkovalev.ctowt.di

import com.dkkovalev.ctowt.presentation.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector(
        modules = []
    )
    abstract fun mainActivity(): MainActivity
}