package com.dkkovalev.ctowt.domain.browse

import com.dkkovalev.ctowt.data.repo.browse.BrowseRepo
import com.dkkovalev.ctowt.di.FragmentScoped
import dagger.Module
import dagger.Provides

@Module
class BrowseInteractorModule {
    @FragmentScoped
    @Provides
    fun providesBrowseInteractor(repo: BrowseRepo): BrowseInteractor = BrowseInteractorImpl(repo)
}