package com.dkkovalev.ctowt.data.mapper.streams

import com.dkkovalev.ctowt.data.model.entity.StreamItem
import com.dkkovalev.ctowt.data.model.response.mixer.streams.MixerStreamsRoot
import com.dkkovalev.ctowt.data.model.response.twitch.streams.TwitchStreamsData

private const val TWITCH = "twitch"
private const val MIXER = "mixer"

class StreamsMapperImpl : StreamsMapper {
    override fun restToStreams(
        twitchStreams: List<TwitchStreamsData>,
        mixerStreams: List<MixerStreamsRoot>
    ): List<StreamItem> = twitchStreams.map(::createStreamItemFromTwitch)
        .plus(mixerStreams.map(::createStreamItemFromMixer))

    private fun createStreamItemFromTwitch(data: TwitchStreamsData) = StreamItem(source = TWITCH).apply {
        streamName = data.title.orEmpty()
        streamId = data.gameId.orEmpty()
        thumbnailUrl = data.thumbnailUrl
            ?.replace("{width}", "304")
            ?.replace("{height}", "171")
            .orEmpty()
    }

    private fun createStreamItemFromMixer(data: MixerStreamsRoot) = StreamItem(source = MIXER).apply {
        streamName = data.streamName.orEmpty()
        streamId = data.id.toString()
        thumbnailUrl =
            "https://upload.wikimedia.org/wikipedia/commons/e/ed/Raccoon_%28Procyon_lotor%29_2.jpg" //TODO REMOVE
    }
}