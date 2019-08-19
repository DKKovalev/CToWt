package com.dkkovalev.ctowt.presentation.screen.browse

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.dkkovalev.ctowt.R
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

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.browse_screen, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.screenEvent.observe(viewLifecycleOwner, Observer {
            it.getContentIfNotHandled()?.let { screenEvent ->
                when (screenEvent) {
                    is BrowseScreenEvent.UiEvent.Loading -> println("!!! loading")
                }
            }
        })

        viewModel.dataEvent.observe(viewLifecycleOwner, Observer { data ->
            when (data) {
                is BrowseScreenEvent.Data.Top -> println("!!! [${data.top}]")
            }
        })
    }
}