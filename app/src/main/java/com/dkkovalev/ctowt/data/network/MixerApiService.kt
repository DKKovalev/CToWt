package com.dkkovalev.ctowt.data.network

import retrofit2.http.GET

interface MixerApiService{
    @GET(MIXER_BROWSE)
    suspend fun browseGames()
}