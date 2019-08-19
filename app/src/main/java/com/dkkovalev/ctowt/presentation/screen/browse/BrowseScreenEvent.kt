package com.dkkovalev.ctowt.presentation.screen.browse

import com.dkkovalev.ctowt.data.model.entity.BrowseModel

sealed class BrowseScreenEvent {
    sealed class UiEvent {
        object Loading : UiEvent()
        object Loaded : UiEvent()
    }

    sealed class Data : BrowseScreenEvent() {
        data class Top(val top: List<BrowseModel>) : Data()
        object Error : Data()
    }
}