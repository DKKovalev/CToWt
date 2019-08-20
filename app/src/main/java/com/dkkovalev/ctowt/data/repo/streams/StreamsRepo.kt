package com.dkkovalev.ctowt.data.repo.streams

import com.dkkovalev.ctowt.data.model.entity.StreamItem

interface StreamsRepo {
    suspend fun loadStreams(twitchId: Int, mixerId: Int): List<StreamItem>
}