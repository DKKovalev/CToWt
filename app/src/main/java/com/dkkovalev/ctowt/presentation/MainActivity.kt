package com.dkkovalev.ctowt.presentation

import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.dkkovalev.ctowt.R
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        NavHostFragment.findNavController(nav_host_fragment).navigate(R.id.browseFragment)
    }
}
