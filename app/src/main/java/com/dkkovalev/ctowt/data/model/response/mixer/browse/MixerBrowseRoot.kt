package com.dkkovalev.ctowt.data.model.response.mixer.browse

import com.dkkovalev.ctowt.data.network.*
import com.google.gson.annotations.SerializedName

data class MixerBrowseRoot(
    @SerializedName(MIXER_ID) var id: Int? = null,
    @SerializedName(MIXER_NAME) var name: String? = null,
    @SerializedName(MIXER_PARENT) var parent: String? = null,
    @SerializedName(MIXER_DESCRIPTION) var description: String? = null,
    @SerializedName(MIXER_SOURCE) var source: String? = null,
    @SerializedName(MIXER_VIEWERS_CURRENT) var currentViewers: Int? = null,
    @SerializedName(MIXER_COVER_URL) var coverImageUrl: String? = null,
    @SerializedName(MIXER_BACKGROUND_URL) var backgroundImageUrl: String? = null,
    @SerializedName(MIXER_ONLINE) var online: Int? = null
)