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
    private val innerScreenEvent = MutableLiveData<Event<BrowseScreenEvent.UiEvent>>()
    val screenEvent: LiveData<Event<BrowseScreenEvent.UiEvent>>
        get() = innerScreenEvent

    private val innerDataEvent = MutableLiveData<BrowseScreenEvent.Data>()
    val dataEvent: LiveData<BrowseScreenEvent.Data>
        get() = innerDataEvent

    init {
        innerScreenEvent.value = Event(BrowseScreenEvent.UiEvent.Loading)
        viewModelScope.launch {
            try {
                innerDataEvent.value = BrowseScreenEvent.Data.Top(interactor.getCurrentTop())
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}