package com.dkkovalev.ctowt.data.network

import com.dkkovalev.ctowt.data.model.response.mixer.MixerBrowseRoot
import retrofit2.http.GET

interface MixerApiService {
    @GET(MIXER_BROWSE)
    suspend fun loadMixerTop(): List<MixerBrowseRoot>
}