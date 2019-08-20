package com.dkkovalev.ctowt.domain.streams;

import com.dkkovalev.ctowt.data.repo.streams.StreamsRepo;
import com.dkkovalev.ctowt.di.FragmentScoped;
import dagger.Module;
import dagger.Provides;

@Module
public class StreamsInteractorModuleJava {
    @FragmentScoped
    @Provides
    StreamsInteractor providesStreamsInteractor(StreamsRepo repo) {
        return new StreamsInteractorImpl(repo);
    }
}
