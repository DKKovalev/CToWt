package com.dkkovalev.ctowt.data.repo.browse

import com.dkkovalev.ctowt.data.network.MixerApiService
import com.dkkovalev.ctowt.data.network.TwitchApiService
import javax.inject.Inject

class BrowseRepoImpl @Inject constructor(
    private val twitchApi: TwitchApiService,
    private val mixerApi: MixerApiService
) : BrowseRepo {
    override fun loadBrowseScreen() {
    }
}