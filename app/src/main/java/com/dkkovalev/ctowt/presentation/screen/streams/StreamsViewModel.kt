package com.dkkovalev.ctowt.presentation.screen.streams

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dkkovalev.ctowt.domain.streams.StreamsInteractor
import com.dkkovalev.ctowt.presentation.screen.streams.StreamsEvent.Data
import com.dkkovalev.ctowt.presentation.screen.streams.StreamsEvent.UiEvent
import com.dkkovalev.ctowt.utils.Event
import kotlinx.coroutines.launch
import javax.inject.Inject

class StreamsViewModel @Inject constructor(private val interactor: StreamsInteractor) : ViewModel() {

    private val innerScreenEvent = MutableLiveData<Event<UiEvent>>()
    val screenEvent: LiveData<Event<UiEvent>>
        get() = innerScreenEvent

    private val innerDataEvent = MutableLiveData<Data>()
    val dataEvent: LiveData<Data>
        get() = innerDataEvent

    fun getStreams(twitchId: Int, mixerId: Int) {
        viewModelScope.launch {
            try {
                innerDataEvent.value = Data.Streams(interactor.getStreams(twitchId, mixerId))
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}