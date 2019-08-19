package com.dkkovalev.ctowt.data.mapper

import com.dkkovalev.ctowt.data.model.entity.BrowseModel
import com.dkkovalev.ctowt.data.model.response.mixer.MixerBrowseRoot
import com.dkkovalev.ctowt.data.model.response.twitch.TwitchBrowseData

interface BrowseMapper {
    fun restToBrowse(twitchResponse: List<TwitchBrowseData>, mixerResponse: List<MixerBrowseRoot>): List<BrowseModel>
}