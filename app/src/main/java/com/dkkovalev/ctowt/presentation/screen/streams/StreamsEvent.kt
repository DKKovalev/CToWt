package com.dkkovalev.ctowt.presentation.screen.streams

import com.dkkovalev.ctowt.data.model.entity.StreamItem

sealed class StreamsEvent {
    sealed class UiEvent : StreamsEvent()

    sealed class Data : StreamsEvent() {
        data class Streams(val streams: List<StreamItem>) : Data()
        object Error : Data()
    }
}