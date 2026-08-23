package dev.reuss.tmdb.quarkus.runtime

import dev.reuss.tmdb.TmdbClient
import io.quarkus.arc.SyntheticCreationalContext
import io.quarkus.runtime.annotations.Recorder
import java.util.function.Function

@Recorder
open class TmdbRecorder {
    open fun createClient(): Function<SyntheticCreationalContext<TmdbClient>, TmdbClient> = TmdbClientCreator()
}
