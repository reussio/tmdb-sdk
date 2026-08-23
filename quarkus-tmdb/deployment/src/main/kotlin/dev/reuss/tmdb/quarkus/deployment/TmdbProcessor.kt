package dev.reuss.tmdb.quarkus.deployment

import dev.reuss.tmdb.TmdbClient
import dev.reuss.tmdb.core.metrics.TmdbMetricsRecorder
import dev.reuss.tmdb.quarkus.runtime.TmdbConfig
import dev.reuss.tmdb.quarkus.runtime.TmdbProducer
import dev.reuss.tmdb.quarkus.runtime.TmdbRecorder
import io.quarkus.arc.deployment.AdditionalBeanBuildItem
import io.quarkus.arc.deployment.SyntheticBeanBuildItem
import io.quarkus.deployment.annotations.BuildStep
import io.quarkus.deployment.annotations.ExecutionTime
import io.quarkus.deployment.annotations.Record
import io.quarkus.deployment.builditem.ConfigMappingBuildItem
import io.quarkus.deployment.builditem.FeatureBuildItem
import jakarta.inject.Singleton
import org.jboss.jandex.Type

/**
 * Registers the TMDB feature, runtime configuration, producer beans, and runtime-initialized
 * synthetic client bean.
 *
 * The client is a default bean, allowing an application-provided [TmdbClient] to take precedence.
 */
class TmdbProcessor {
    @BuildStep
    fun feature(): FeatureBuildItem = FeatureBuildItem(FEATURE)

    @BuildStep
    fun configMapping(): ConfigMappingBuildItem =
        ConfigMappingBuildItem(
            TmdbConfig::class.java,
            "tmdb",
        )

    @BuildStep
    fun producerBeans(): AdditionalBeanBuildItem =
        AdditionalBeanBuildItem
            .builder()
            .addBeanClass(TmdbProducer::class.java)
            .setUnremovable()
            .build()

    @BuildStep
    @Record(ExecutionTime.RUNTIME_INIT)
    fun tmdbClient(recorder: TmdbRecorder): SyntheticBeanBuildItem =
        SyntheticBeanBuildItem
            .configure(TmdbClient::class.java)
            .scope(Singleton::class.java)
            .defaultBean()
            .unremovable()
            .addInjectionPoint(TMDB_METRICS_RECORDER)
            .createWith(recorder.createClient())
            .startup()
            .setRuntimeInit()
            .done()

    companion object {
        private const val FEATURE = "tmdb"

        private val TMDB_METRICS_RECORDER =
            Type.create(TmdbMetricsRecorder::class.java)
    }
}
