package com.dkkovalev.ctowt.presentation.screen.browse

import androidx.lifecycle.ViewModel
import com.dkkovalev.ctowt.data.repo.browse.BrowseRepoModule
import com.dkkovalev.ctowt.di.FragmentScoped
import com.dkkovalev.ctowt.di.ViewModelKey
import com.dkkovalev.ctowt.domain.browse.BrowseInteractorModule
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
internal abstract class BrowseModule {

    @FragmentScoped
    @ContributesAndroidInjector(
        modules = [
            BrowseRepoModule::class,
            BrowseInteractorModule::class
        ]
    )
    internal abstract fun contributesBrowseFragment(): BrowseFragment

    @Binds
    @IntoMap
    @ViewModelKey(BrowseViewModel::class)
    abstract fun bindsBrowseViewModel(viewModel: BrowseViewModel): ViewModel
}