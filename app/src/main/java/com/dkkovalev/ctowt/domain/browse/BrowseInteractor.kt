package com.dkkovalev.ctowt.domain.browse

import com.dkkovalev.ctowt.data.model.entity.BrowseModel
import com.dkkovalev.ctowt.data.model.response.mixer.MixerBrowseRoot

interface BrowseInteractor {
    suspend fun getCurrentTop(): List<BrowseModel>
}