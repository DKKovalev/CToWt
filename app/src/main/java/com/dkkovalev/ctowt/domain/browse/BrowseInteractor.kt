package com.dkkovalev.ctowt.domain.browse

import com.dkkovalev.ctowt.data.model.entity.BrowseItem

interface BrowseInteractor {
    suspend fun getCurrentTop(): List<BrowseItem>
}