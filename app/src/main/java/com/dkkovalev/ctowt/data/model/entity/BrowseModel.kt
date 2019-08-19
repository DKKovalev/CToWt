package com.dkkovalev.ctowt.data.model.entity

data class BrowseModel(
    var twitchId: Int = 0,
    var mixerId: Int = 0,
    var onlineCount: Int = 0,
    var source: String = "",
    var name: String = ""
)