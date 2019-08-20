package com.dkkovalev.ctowt.data.mapper.browse

import com.dkkovalev.ctowt.data.model.entity.BrowseItem
import com.dkkovalev.ctowt.data.model.response.mixer.browse.MixerBrowseRoot
import com.dkkovalev.ctowt.data.model.response.twitch.browse.TwitchBrowseData

class BrowseMapperImpl : BrowseMapper {
    override fun restToBrowse(
        twitchResponse: List<TwitchBrowseData>,
        mixerResponse: List<MixerBrowseRoot>
    ): List<BrowseItem> = twitchResponse.flatMap { createBrowseModel(it, mixerResponse) }

    private fun createBrowseModel(
        twitchRoot: TwitchBrowseData,
        mixerRoot: List<MixerBrowseRoot>
    ) = mixerRoot
        .filter { it.name == twitchRoot.name }
        .map {
            BrowseItem().apply {
                twitchId = twitchRoot.id ?: 0
                mixerId = it.id ?: 0
                name = twitchRoot.name.orEmpty()
                thumbnail = it.backgroundImageUrl.orEmpty()
                description = it.description.orEmpty()
            }
        }
}