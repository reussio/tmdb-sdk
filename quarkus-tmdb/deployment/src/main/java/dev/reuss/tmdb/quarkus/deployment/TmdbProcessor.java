package dev.reuss.tmdb.quarkus.deployment;

import dev.reuss.tmdb.TmdbClient;
import dev.reuss.tmdb.core.metrics.TmdbMetricsRecorder;
import dev.reuss.tmdb.quarkus.runtime.TmdbConfig;
import dev.reuss.tmdb.quarkus.runtime.TmdbProducer;
import dev.reuss.tmdb.quarkus.runtime.TmdbRecorder;
import io.quarkus.arc.deployment.AdditionalBeanBuildItem;
import io.quarkus.arc.deployment.SyntheticBeanBuildItem;
import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.deployment.annotations.ExecutionTime;
import io.quarkus.deployment.annotations.Record;
import io.quarkus.deployment.builditem.ConfigMappingBuildItem;
import io.quarkus.deployment.builditem.FeatureBuildItem;
import jakarta.inject.Singleton;
import org.jboss.jandex.Type;

/**
 * Core Quarkus build processor for the TMDB extension.
 */
public class TmdbProcessor {

    private static final String FEATURE = "tmdb";
    private static final Type TMDB_METRICS_RECORDER = Type.create(TmdbMetricsRecorder.class);

    @BuildStep
    FeatureBuildItem feature() {
        return new FeatureBuildItem(FEATURE);
    }

    @BuildStep
    ConfigMappingBuildItem configMapping() {
        return new ConfigMappingBuildItem(TmdbConfig.class, "tmdb");
    }

    @BuildStep
    AdditionalBeanBuildItem producerBeans() {
        return AdditionalBeanBuildItem.builder()
                .addBeanClass(TmdbProducer.class)
                .setUnremovable()
                .build();
    }

    @BuildStep
    @Record(ExecutionTime.RUNTIME_INIT)
    SyntheticBeanBuildItem tmdbClient(TmdbRecorder recorder) {
        return SyntheticBeanBuildItem.configure(TmdbClient.class)
                .scope(Singleton.class)
                .defaultBean()
                .unremovable()
                .addInjectionPoint(TMDB_METRICS_RECORDER)
                .createWith(recorder.createClient())
                .startup()
                .setRuntimeInit()
                .done();
    }
}
