package com.dkkovalev.ctowt.data.model.response.twitch.browse

import com.dkkovalev.ctowt.data.network.TWITCH_DATA
import com.google.gson.annotations.SerializedName

data class TwitchBrowseRoot(@SerializedName(TWITCH_DATA) var data: List<TwitchBrowseData>)