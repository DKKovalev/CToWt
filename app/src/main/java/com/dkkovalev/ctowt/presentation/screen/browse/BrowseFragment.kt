package com.dkkovalev.ctowt.presentation.screen.browse

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.dkkovalev.ctowt.utils.activityViewModelProvider
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class BrowseFragment : DaggerFragment() {
    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private lateinit var viewModel: BrowseViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = activityViewModelProvider(factory)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        println("!!! $viewModel")
    }
}