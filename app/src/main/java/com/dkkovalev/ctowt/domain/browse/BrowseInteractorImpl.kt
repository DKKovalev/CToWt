package com.dkkovalev.ctowt.domain.browse

import com.dkkovalev.ctowt.data.repo.browse.BrowseRepo
import javax.inject.Inject

class BrowseInteractorImpl @Inject constructor(private val repo: BrowseRepo) : BrowseInteractor {
    override suspend fun getCurrentTop() {
        repo.loadBrowseScreen()
    }
}