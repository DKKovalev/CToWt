package com.dkkovalev.ctowt.di.browse

import com.dkkovalev.ctowt.data.repo.browse.BrowseRepo
import com.dkkovalev.ctowt.di.FragmentScoped
import com.dkkovalev.ctowt.domain.browse.BrowseInteractor
import com.dkkovalev.ctowt.domain.browse.BrowseInteractorImpl
import dagger.Module
import dagger.Provides

@Module
class BrowseInteractorModule {

    @FragmentScoped
    @Provides
    fun providesBrowseInteractor(repo: BrowseRepo): BrowseInteractor = BrowseInteractorImpl(repo)
}