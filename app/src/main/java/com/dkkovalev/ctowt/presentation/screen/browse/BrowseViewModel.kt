package com.dkkovalev.ctowt.presentation.screen.browse

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dkkovalev.ctowt.domain.browse.BrowseInteractor
import com.dkkovalev.ctowt.utils.Event
import kotlinx.coroutines.launch
import javax.inject.Inject

class BrowseViewModel @Inject constructor(private val interactor: BrowseInteractor) : ViewModel() {
    private val innerScreenEvent = MutableLiveData<Event<BrowseEvent.UiEvent>>()
    val screenEvent: LiveData<Event<BrowseEvent.UiEvent>>
        get() = innerScreenEvent

    private val innerDataEvent = MutableLiveData<BrowseEvent.Data>()
    val dataEvent: LiveData<BrowseEvent.Data>
        get() = innerDataEvent

    init {
        innerScreenEvent.value = Event(BrowseEvent.UiEvent.Loading)
        viewModelScope.launch {
            try {
                innerDataEvent.value = BrowseEvent.Data.Top(interactor.getCurrentTop())
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}