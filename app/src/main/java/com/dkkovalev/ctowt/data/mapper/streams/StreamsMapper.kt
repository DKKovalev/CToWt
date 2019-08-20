package com.dkkovalev.ctowt.data.mapper.streams

import com.dkkovalev.ctowt.data.model.entity.StreamItem
import com.dkkovalev.ctowt.data.model.response.mixer.streams.MixerStreamsRoot
import com.dkkovalev.ctowt.data.model.response.twitch.streams.TwitchStreamsData

interface StreamsMapper {
    fun restToStreams(twitchStreams: List<TwitchStreamsData>, mixerStreams: List<MixerStreamsRoot>): List<StreamItem>
}