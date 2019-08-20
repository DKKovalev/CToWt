package com.dkkovalev.ctowt.data.network

import com.dkkovalev.ctowt.data.model.response.mixer.browse.MixerBrowseRoot
import com.dkkovalev.ctowt.data.model.response.mixer.streams.MixerStreamsRoot
import retrofit2.http.GET
import retrofit2.http.Query

interface MixerApiService {
    @GET(MIXER_BROWSE)
    suspend fun loadMixerTop(): List<MixerBrowseRoot>

    @GET(MIXER_STREAMS)
    suspend fun loadMixerStreams(@Query(MIXER_GAME_ID) id: Int, @Query(MIXER_ORDER) oder: String): List<MixerStreamsRoot>
}