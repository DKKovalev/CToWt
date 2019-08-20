package com.dkkovalev.ctowt.presentation.screen.streams

import androidx.lifecycle.ViewModel
import com.dkkovalev.ctowt.data.repo.streams.StreamsRepoModule
import com.dkkovalev.ctowt.di.FragmentScoped
import com.dkkovalev.ctowt.di.ViewModelKey
import com.dkkovalev.ctowt.domain.streams.StreamsInteractorModule
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
internal abstract class StreamsModule {

    @FragmentScoped
    @ContributesAndroidInjector(
        modules = [
            StreamsRepoModule::class,
            StreamsInteractorModule::class
        ]
    )
    abstract fun contributesStreamsFragment(): StreamsFragment

    @Binds
    @IntoMap
    @ViewModelKey(StreamsViewModel::class)
    abstract fun bindsStreamsViewModel(viewModel: StreamsViewModel): ViewModel
}