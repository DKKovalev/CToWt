package com.dkkovalev.ctowt.domain.streams

import com.dkkovalev.ctowt.data.model.entity.StreamItem
import com.dkkovalev.ctowt.data.repo.streams.StreamsRepo
import javax.inject.Inject

class StreamsInteractorImpl @Inject constructor(private val repo: StreamsRepo) : StreamsInteractor {
    override suspend fun getStreams(twitchId: Int, mixerId: Int): List<StreamItem> = repo.loadStreams(twitchId, mixerId)
}