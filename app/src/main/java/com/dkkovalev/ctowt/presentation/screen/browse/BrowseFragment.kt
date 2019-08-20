package com.dkkovalev.ctowt.presentation.screen.browse

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dkkovalev.ctowt.R
import com.dkkovalev.ctowt.data.model.entity.BrowseItem
import com.dkkovalev.ctowt.presentation.MainRouter
import com.dkkovalev.ctowt.utils.activityViewModelProvider
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.browse_screen.*
import javax.inject.Inject

class BrowseFragment : DaggerFragment() {
    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private lateinit var viewModel: BrowseViewModel
    private lateinit var browseAdapter: BrowseAdapter

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

        browseAdapter = BrowseAdapter { item, thumbnail -> (activity as MainRouter).browseToStreams(item, thumbnail) }
        with(rv_top) {
            adapter = browseAdapter
            layoutManager = LinearLayoutManager(activity)
        }

        viewModel.screenEvent.observe(viewLifecycleOwner, Observer {
            it.getContentIfNotHandled()?.let { screenEvent ->
                when (screenEvent) {
                    is BrowseEvent.UiEvent.Loading -> displayLoading()
                }
            }
        })

        viewModel.dataEvent.observe(viewLifecycleOwner, Observer { data ->
            when (data) {
                is BrowseEvent.Data.Top -> displayItems(data.top)
            }
        })
    }

    private fun displayItems(top: List<BrowseItem>) {
        rv_top.visibility = VISIBLE
        pb_loading.visibility = GONE
        browseAdapter.submitList(top)
    }

    private fun displayLoading() {
        rv_top.visibility = GONE
        pb_loading.visibility = VISIBLE
    }
}