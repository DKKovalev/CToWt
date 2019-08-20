package com.dkkovalev.ctowt.data.repo.streams

import com.dkkovalev.ctowt.data.mapper.streams.StreamsMapper
import com.dkkovalev.ctowt.data.network.MIXER_ORDER_RULE
import com.dkkovalev.ctowt.data.network.MixerApiService
import com.dkkovalev.ctowt.data.network.TwitchApiService
import javax.inject.Inject

class StreamsRepoImpl @Inject constructor(
    private val twitchApi: TwitchApiService,
    private val mixerApi: MixerApiService,
    private val mapper: StreamsMapper
) : StreamsRepo {
    override suspend fun loadStreams(twitchId: Int, mixerId: Int) = mapper.restToStreams(
        twitchApi.loadTwitchStreams(twitchId).data,
        mixerApi.loadMixerStreams(mixerId, MIXER_ORDER_RULE)
    )
}