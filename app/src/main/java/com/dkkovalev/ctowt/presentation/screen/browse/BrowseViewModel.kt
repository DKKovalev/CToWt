package com.dkkovalev.ctowt.presentation.screen.browse

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dkkovalev.ctowt.domain.browse.BrowseInteractor
import com.dkkovalev.ctowt.utils.Event
import javax.inject.Inject

class BrowseViewModel @Inject constructor(private val interactor: BrowseInteractor) : ViewModel() {
    private val innerScreenEvent = MutableLiveData<Event<BrowseScreenEvent.UiEvent>>()

    val screenEvent: LiveData<Event<BrowseScreenEvent.UiEvent>>
        get() = innerScreenEvent

    init {
        println("!!! interactor = [$interactor]")
    }
}