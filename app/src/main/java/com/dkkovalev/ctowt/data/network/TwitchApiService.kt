package com.dkkovalev.ctowt.data.network

import com.dkkovalev.ctowt.data.model.response.twitch.browse.TwitchBrowseRoot
import com.dkkovalev.ctowt.data.model.response.twitch.streams.TwitchStreamsRoot
import retrofit2.http.GET
import retrofit2.http.Query

interface TwitchApiService {
    @GET(TWITCH_BROWSE)
    suspend fun loadTwitchTop(): TwitchBrowseRoot

    @GET(TWITCH_STREAMS)
    suspend fun loadTwitchStreams(@Query(TWITCH_GAME_ID) id: Int): TwitchStreamsRoot
}