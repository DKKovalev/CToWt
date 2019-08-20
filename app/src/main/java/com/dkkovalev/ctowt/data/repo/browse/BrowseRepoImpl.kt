package com.dkkovalev.ctowt.data.repo.browse

import com.dkkovalev.ctowt.data.mapper.browse.BrowseMapper
import com.dkkovalev.ctowt.data.model.entity.BrowseItem
import com.dkkovalev.ctowt.data.network.MixerApiService
import com.dkkovalev.ctowt.data.network.TwitchApiService
import javax.inject.Inject

class BrowseRepoImpl @Inject constructor(
    private val twitchApi: TwitchApiService,
    private val mixerApi: MixerApiService,
    private val mapper: BrowseMapper
) : BrowseRepo {
    override suspend fun loadMixerTop() = mixerApi.loadMixerTop()
    override suspend fun loadTwitchTop() = twitchApi.loadTwitchTop()
    override suspend fun loadTop(): List<BrowseItem> {
        val mixer = mixerApi.loadMixerTop()
        val twitch = twitchApi.loadTwitchTop().data
        return mapper.restToBrowse(twitch, mixer)
    }
}