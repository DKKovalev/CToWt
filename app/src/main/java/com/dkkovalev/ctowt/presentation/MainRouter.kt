package com.dkkovalev.ctowt.presentation

import android.widget.ImageView
import com.dkkovalev.ctowt.data.model.entity.BrowseItem

interface MainRouter {
    fun browseToStreams(item: BrowseItem, view: ImageView)
}