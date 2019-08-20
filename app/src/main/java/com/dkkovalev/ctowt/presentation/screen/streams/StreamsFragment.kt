package com.dkkovalev.ctowt.presentation.screen.streams

import android.os.Bundle
import android.transition.ChangeBounds
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.dkkovalev.ctowt.R
import com.dkkovalev.ctowt.data.model.entity.BrowseItem
import com.dkkovalev.ctowt.data.model.entity.StreamItem
import com.squareup.picasso.Picasso
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.browse_item.iv_thumbnail
import kotlinx.android.synthetic.main.streams_screen.*
import javax.inject.Inject

class StreamsFragment : DaggerFragment() {

    @Inject
    lateinit var viewModel: StreamsViewModel

    private var item: BrowseItem? = null
    private lateinit var streamsAdapter: StreamsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        item = arguments?.getParcelable<BrowseItem>("browse_item")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.streams_screen, container, false).apply {
        sharedElementEnterTransition = ChangeBounds().apply {
            duration = 300
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Picasso.get()
            .load(item?.thumbnail)
            .fit()
            .centerCrop()
            .into(iv_thumbnail)

        tv_description.text = item?.description

        toolbar.title = item?.name

        streamsAdapter = StreamsAdapter { item, thumbnail -> {} }
        with(rv_streams) {
            adapter = streamsAdapter
            layoutManager = LinearLayoutManager(activity)
        }

        item?.let {
            viewModel.getStreams(it.twitchId, it.mixerId)
        }

        viewModel.dataEvent.observe(viewLifecycleOwner, Observer { data ->
            when (data) {
                is StreamsEvent.Data.Streams -> displayStreams(data.streams)
            }
        })

        /*streamsAdapter.submitList(
            listOf(
                BrowseItem(
                    name = "123",
                    thumbnail = "https://upload.wikimedia.org/wikipedia/commons/e/ed/Raccoon_%28Procyon_lotor%29_2.jpg"
                ),
                BrowseItem(
                    name = "123",
                    thumbnail = "https://upload.wikimedia.org/wikipedia/commons/e/ed/Raccoon_%28Procyon_lotor%29_2.jpg"
                ),
                BrowseItem(
                    name = "123",
                    thumbnail = "https://upload.wikimedia.org/wikipedia/commons/e/ed/Raccoon_%28Procyon_lotor%29_2.jpg"
                ),
                BrowseItem(
                    name = "123",
                    thumbnail = "https://upload.wikimedia.org/wikipedia/commons/e/ed/Raccoon_%28Procyon_lotor%29_2.jpg"
                ),
                BrowseItem(
                    name = "123",
                    thumbnail = "https://upload.wikimedia.org/wikipedia/commons/e/ed/Raccoon_%28Procyon_lotor%29_2.jpg"
                ),
                BrowseItem(
                    name = "123",
                    thumbnail = "https://upload.wikimedia.org/wikipedia/commons/e/ed/Raccoon_%28Procyon_lotor%29_2.jpg"
                ),
                BrowseItem(
                    name = "123",
                    thumbnail = "https://upload.wikimedia.org/wikipedia/commons/e/ed/Raccoon_%28Procyon_lotor%29_2.jpg"
                ),
                BrowseItem(
                    name = "123",
                    thumbnail = "https://upload.wikimedia.org/wikipedia/commons/e/ed/Raccoon_%28Procyon_lotor%29_2.jpg"
                ),
                BrowseItem(
                    name = "123",
                    thumbnail = "https://upload.wikimedia.org/wikipedia/commons/e/ed/Raccoon_%28Procyon_lotor%29_2.jpg"
                ),
                BrowseItem(
                    name = "123",
                    thumbnail = "https://upload.wikimedia.org/wikipedia/commons/e/ed/Raccoon_%28Procyon_lotor%29_2.jpg"
                ),
                BrowseItem(
                    name = "123",
                    thumbnail = "https://upload.wikimedia.org/wikipedia/commons/e/ed/Raccoon_%28Procyon_lotor%29_2.jpg"
                ),
                BrowseItem(
                    name = "123",
                    thumbnail = "https://upload.wikimedia.org/wikipedia/commons/e/ed/Raccoon_%28Procyon_lotor%29_2.jpg"
                ),
                BrowseItem(
                    name = "123",
                    thumbnail = "https://upload.wikimedia.org/wikipedia/commons/e/ed/Raccoon_%28Procyon_lotor%29_2.jpg"
                ),
                BrowseItem(
                    name = "123",
                    thumbnail = "https://upload.wikimedia.org/wikipedia/commons/e/ed/Raccoon_%28Procyon_lotor%29_2.jpg"
                ),
                BrowseItem(
                    name = "123",
                    thumbnail = "https://upload.wikimedia.org/wikipedia/commons/e/ed/Raccoon_%28Procyon_lotor%29_2.jpg"
                ),
                BrowseItem(
                    name = "123",
                    thumbnail = "https://upload.wikimedia.org/wikipedia/commons/e/ed/Raccoon_%28Procyon_lotor%29_2.jpg"
                ),
                BrowseItem(
                    name = "123",
                    thumbnail = "https://upload.wikimedia.org/wikipedia/commons/e/ed/Raccoon_%28Procyon_lotor%29_2.jpg"
                ),
                BrowseItem(
                    name = "123",
                    thumbnail = "https://upload.wikimedia.org/wikipedia/commons/e/ed/Raccoon_%28Procyon_lotor%29_2.jpg"
                ),
                BrowseItem(
                    name = "123",
                    thumbnail = "https://upload.wikimedia.org/wikipedia/commons/e/ed/Raccoon_%28Procyon_lotor%29_2.jpg"
                ),
                BrowseItem(
                    name = "123",
                    thumbnail = "https://upload.wikimedia.org/wikipedia/commons/e/ed/Raccoon_%28Procyon_lotor%29_2.jpg"
                )
            )
        )*/
    }

    private fun displayStreams(streams: List<StreamItem>) {
        streamsAdapter.submitList(streams)
    }
}