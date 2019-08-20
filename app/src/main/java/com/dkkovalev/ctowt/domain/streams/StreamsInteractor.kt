package com.dkkovalev.ctowt.domain.streams

import com.dkkovalev.ctowt.data.model.entity.StreamItem

interface StreamsInteractor {
    suspend fun getStreams(twitchId: Int, mixerId: Int): List<StreamItem>
}