package dev.reuss.tmdb.quarkus.runtime;

import dev.reuss.tmdb.TmdbClient;
import io.quarkus.arc.SyntheticCreationalContext;
import io.quarkus.runtime.annotations.Recorder;

import java.util.function.Function;

@Recorder
public class TmdbRecorder {

    public Function<SyntheticCreationalContext<TmdbClient>, TmdbClient> createClient() {
        return new TmdbClientCreator();
    }
}
