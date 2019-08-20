package com.dkkovalev.ctowt.data.model.response.mixer.streams

import com.dkkovalev.ctowt.data.network.*
import com.google.gson.annotations.SerializedName

data class MixerStreamsRoot(
    @SerializedName(MIXER_FEATURED) var isFeatured: Boolean? = null,
    @SerializedName(MIXER_ID) var id: Int? = null,
    @SerializedName(MIXER_USER_ID) var userId: Int? = null,
    @SerializedName(MIXER_TOKEN) var token: String? = null,
    @SerializedName(MIXER_ONLINE) var isOnline: Boolean? = null,
    @SerializedName(MIXER_FEATURE_LEVEL) var featureLevel: Int? = null,
    @SerializedName(MIXER_PARTNERED) var isPartnered: Boolean? = null,
    @SerializedName(MIXER_TRANSCODING_PROFILE_ID) var transcodingProfileId: Int? = null,
    @SerializedName(MIXER_SUSPENDED) var isSuspended: Boolean? = null,
    @SerializedName(MIXER_NAME) var streamName: String? = null,
    @SerializedName(MIXER_AUDIENCE) var audience: String? = null,
    @SerializedName(MIXER_VIEWERS_CURRENT) var currentUserViewers: Int? = null
    )