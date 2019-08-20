package com.dkkovalev.ctowt.data.model.response.twitch.streams

import com.dkkovalev.ctowt.data.network.*
import com.google.gson.annotations.SerializedName

data class TwitchStreamsData(
    @SerializedName(TWITCH_ID) var id: String? = null,
    @SerializedName(TWITCH_USER_ID) var userId: String? = null,
    @SerializedName(TWITCH_USER_NAME) var userName: String? = null,
    @SerializedName(TWITCH_GAME_ID) var gameId: String? = null,
    @SerializedName(TWITCH_TYPE) var type: String? = null,
    @SerializedName(TWITCH_TITLE) var title: String? = null,
    @SerializedName(TWITCH_VIEWER_COUNT) var viewers: Int? = null,
    @SerializedName(TWITCH_STARTED_AT) var startedAt: String? = null,
    @SerializedName(TWITCH_LANGUAGE) var language: String? = null,
    @SerializedName(TWITCH_THUMBNAIL_URL) var thumbnailUrl: String? = null
)