package com.dkkovalev.ctowt.data.model.response.twitch

import com.dkkovalev.ctowt.data.network.TWITCH_COVER_URL
import com.dkkovalev.ctowt.data.network.TWITCH_ID
import com.dkkovalev.ctowt.data.network.TWITCH_NAME
import com.google.gson.annotations.SerializedName

data class TwitchBrowseData(
    @SerializedName(TWITCH_ID) var id: Int? = null,
    @SerializedName(TWITCH_NAME) var name: String? = null,
    @SerializedName(TWITCH_COVER_URL) var coverImageUrl: String? = null
)