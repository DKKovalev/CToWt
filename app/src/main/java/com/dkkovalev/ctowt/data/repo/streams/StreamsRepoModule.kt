package com.dkkovalev.ctowt.data.repo.streams

import com.dkkovalev.ctowt.data.mapper.streams.StreamsMapper
import com.dkkovalev.ctowt.data.mapper.streams.StreamsMapperImpl
import com.dkkovalev.ctowt.data.network.MixerApiService
import com.dkkovalev.ctowt.data.network.TwitchApiService
import com.dkkovalev.ctowt.di.FragmentScoped
import dagger.Module
import dagger.Provides

@Module
class StreamsRepoModule {

    @FragmentScoped
    @Provides
    fun providesStreamsMapper(): StreamsMapper = StreamsMapperImpl()

    @FragmentScoped
    @Provides
    fun providesStreamsRepo(
        twitchApi: TwitchApiService,
        mixerApi: MixerApiService,
        mapper: StreamsMapper
    ): StreamsRepo = StreamsRepoImpl(twitchApi, mixerApi, mapper)
}