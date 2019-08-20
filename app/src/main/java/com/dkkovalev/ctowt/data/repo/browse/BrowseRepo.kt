package com.dkkovalev.ctowt.data.repo.browse

import com.dkkovalev.ctowt.data.model.entity.BrowseItem
import com.dkkovalev.ctowt.data.model.response.mixer.browse.MixerBrowseRoot
import com.dkkovalev.ctowt.data.model.response.twitch.browse.TwitchBrowseRoot

interface BrowseRepo {
    suspend fun loadMixerTop(): List<MixerBrowseRoot>
    suspend fun loadTwitchTop(): TwitchBrowseRoot
    suspend fun loadTop(): List<BrowseItem>
}