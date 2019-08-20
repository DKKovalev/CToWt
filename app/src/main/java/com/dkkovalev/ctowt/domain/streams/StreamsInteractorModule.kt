package com.dkkovalev.ctowt.domain.streams

import com.dkkovalev.ctowt.data.repo.streams.StreamsRepo
import com.dkkovalev.ctowt.di.FragmentScoped
import dagger.Module
import dagger.Provides

@Module
class StreamsInteractorModule {
    @FragmentScoped
    @Provides
    fun providesStreamsInteractor(repo: StreamsRepo): StreamsInteractor = StreamsInteractorImpl(repo)
}