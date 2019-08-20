package com.dkkovalev.ctowt.data.model.response.twitch.streams

import com.dkkovalev.ctowt.data.network.TWITCH_DATA
import com.google.gson.annotations.SerializedName

data class TwitchStreamsRoot(@SerializedName(TWITCH_DATA) var data: List<TwitchStreamsData>)