package com.dkkovalev.ctowt.data.network

import com.dkkovalev.ctowt.data.model.response.twitch.TwitchBrowseRoot
import retrofit2.http.GET

interface TwitchApiService {
    @GET(TWITCH_BROWSE)
    suspend fun loadTwitchTop(): TwitchBrowseRoot
}