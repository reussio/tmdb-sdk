package dev.reuss.tmdb.quarkus.deployment;

import dev.reuss.tmdb.quarkus.runtime.QuarkusTmdbMetricsRecorder;
import io.quarkus.arc.deployment.AdditionalBeanBuildItem;
import io.quarkus.deployment.Capabilities;
import io.quarkus.deployment.Capability;
import io.quarkus.deployment.annotations.BuildProducer;
import io.quarkus.deployment.annotations.BuildStep;

/**
 * Registers TMDB metrics support when Quarkus Metrics is present.
 */
public class TmdbMetricsProcessor {

    @BuildStep
    void metricsBeans(Capabilities capabilities, BuildProducer<AdditionalBeanBuildItem> additionalBeans) {
        if (shouldRegisterMetrics(capabilities)) {
            additionalBeans.produce(AdditionalBeanBuildItem.builder()
                    .addBeanClass(QuarkusTmdbMetricsRecorder.class)
                    .setUnremovable()
                    .build());
        }
    }

    static boolean shouldRegisterMetrics(Capabilities capabilities) {
        return capabilities.isPresent(Capability.METRICS);
    }
}
