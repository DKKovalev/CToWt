package com.dkkovalev.ctowt.presentation

import android.os.Bundle
import android.widget.ImageView
import androidx.navigation.NavController
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.NavHostFragment
import com.dkkovalev.ctowt.R
import com.dkkovalev.ctowt.data.model.entity.BrowseItem
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : DaggerAppCompatActivity(), MainRouter {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = NavHostFragment.findNavController(nav_host_fragment).apply { navigate(R.id.browseFragment) }
    }

    override fun browseToStreams(item: BrowseItem, view: ImageView) {
        navController.navigate(
            R.id.streamsFragment,
            Bundle().apply { putParcelable("browse_item", item) },
            null,
            FragmentNavigatorExtras(view to "game_thumbnail")
        )
    }
}
