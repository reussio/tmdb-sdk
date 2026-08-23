package dev.reuss.tmdb.quarkus.runtime

import dev.reuss.tmdb.TmdbClient
import io.quarkus.arc.SyntheticCreationalContext
import io.quarkus.runtime.annotations.Recorder
import java.util.function.Function

/** Supplies the runtime-init factory used for Quarkus' synthetic [TmdbClient] bean. */
@Recorder
open class TmdbRecorder {
    open fun createClient(): Function<SyntheticCreationalContext<TmdbClient>, TmdbClient> = TmdbClientCreator()
}
