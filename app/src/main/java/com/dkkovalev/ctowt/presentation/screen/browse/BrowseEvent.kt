package com.dkkovalev.ctowt.presentation.screen.browse

import com.dkkovalev.ctowt.data.model.entity.BrowseItem

sealed class BrowseEvent {
    sealed class UiEvent {
        object Loading : UiEvent()
    }

    sealed class Data : BrowseEvent() {
        data class Top(val top: List<BrowseItem>) : Data()
        object Error : Data()
    }
}