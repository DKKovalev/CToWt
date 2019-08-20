package com.dkkovalev.ctowt.data.model.entity

data class StreamItem(
    var streamName: String = "",
    var streamId: String = "",
    var thumbnailUrl: String = "",
    var viewersCount: Int = 0,
    var source: String
)