package com.dkkovalev.ctowt.di

import androidx.lifecycle.ViewModelProvider
import com.dkkovalev.ctowt.presentation.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {
    @Binds
    internal abstract fun bindsViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}