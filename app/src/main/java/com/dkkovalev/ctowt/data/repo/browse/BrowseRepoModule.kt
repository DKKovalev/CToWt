package com.dkkovalev.ctowt.data.repo.browse

import com.dkkovalev.ctowt.data.network.MixerApiService
import com.dkkovalev.ctowt.data.network.TwitchApiService
import com.dkkovalev.ctowt.di.FragmentScoped
import dagger.Module
import dagger.Provides

@Module
class BrowseRepoModule {
    @FragmentScoped
    @Provides
    fun providesBrowseRepo(
        twitchApi: TwitchApiService,
        mixerApi: MixerApiService
    ): BrowseRepo = BrowseRepoImpl(twitchApi, mixerApi)
}