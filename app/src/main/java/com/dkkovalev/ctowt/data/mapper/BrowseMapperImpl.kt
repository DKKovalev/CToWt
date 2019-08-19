package com.dkkovalev.ctowt.data.mapper

import com.dkkovalev.ctowt.data.model.entity.BrowseModel
import com.dkkovalev.ctowt.data.model.response.mixer.MixerBrowseRoot
import com.dkkovalev.ctowt.data.model.response.twitch.TwitchBrowseData

class BrowseMapperImpl : BrowseMapper {
    override fun restToBrowse(
        twitchResponse: List<TwitchBrowseData>,
        mixerResponse: List<MixerBrowseRoot>
    ): List<BrowseModel> = twitchResponse.flatMap { createBrowseModel(it, mixerResponse) }

    private fun createBrowseModel(
        twitchRoot: TwitchBrowseData,
        mixerRoot: List<MixerBrowseRoot>
    ) = mixerRoot
        .filter { it.name == twitchRoot.name }
        .map {
            BrowseModel().apply {
                twitchId = twitchRoot.id ?: 0
                mixerId = it.id ?: 0
                name = twitchRoot.name.orEmpty()
            }
        }
}