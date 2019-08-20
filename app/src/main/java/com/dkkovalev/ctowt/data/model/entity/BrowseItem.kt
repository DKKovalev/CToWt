package com.dkkovalev.ctowt.data.model.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class BrowseItem(
    var twitchId: Int = 0,
    var mixerId: Int = 0,
    var onlineCount: Int = 0,
    var source: String = "",
    var name: String = "",
    var thumbnail: String = "",
    var description: String = ""
) : Parcelable