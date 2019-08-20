package com.dkkovalev.ctowt.data.mapper.browse

import com.dkkovalev.ctowt.data.model.entity.BrowseItem
import com.dkkovalev.ctowt.data.model.response.mixer.browse.MixerBrowseRoot
import com.dkkovalev.ctowt.data.model.response.twitch.browse.TwitchBrowseData

interface BrowseMapper {
    fun restToBrowse(twitchResponse: List<TwitchBrowseData>, mixerResponse: List<MixerBrowseRoot>): List<BrowseItem>
}