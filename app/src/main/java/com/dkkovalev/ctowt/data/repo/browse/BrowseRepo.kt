package com.dkkovalev.ctowt.data.repo.browse

import com.dkkovalev.ctowt.data.model.entity.BrowseModel
import com.dkkovalev.ctowt.data.model.response.mixer.MixerBrowseRoot
import com.dkkovalev.ctowt.data.model.response.twitch.TwitchBrowseRoot

interface BrowseRepo {
    suspend fun loadMixerTop(): List<MixerBrowseRoot>
    suspend fun loadTwitchTop(): TwitchBrowseRoot
    suspend fun loadTop(): List<BrowseModel>
}