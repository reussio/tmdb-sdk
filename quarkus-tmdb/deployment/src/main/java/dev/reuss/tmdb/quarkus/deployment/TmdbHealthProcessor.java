package dev.reuss.tmdb.quarkus.deployment;

import dev.reuss.tmdb.quarkus.runtime.TmdbHealthCheck;
import io.quarkus.arc.deployment.AdditionalBeanBuildItem;
import io.quarkus.deployment.Capabilities;
import io.quarkus.deployment.Capability;
import io.quarkus.deployment.annotations.BuildProducer;
import io.quarkus.deployment.annotations.BuildStep;

/**
 * Registers TMDB health check support when Quarkus Health is present.
 */
public class TmdbHealthProcessor {

    @BuildStep
    void healthCheck(Capabilities capabilities, BuildProducer<AdditionalBeanBuildItem> additionalBeans) {
        if (shouldRegisterHealthCheck(capabilities)) {
            additionalBeans.produce(AdditionalBeanBuildItem.builder()
                    .addBeanClass(TmdbHealthCheck.class)
                    .setUnremovable()
                    .build());
        }
    }

    static boolean shouldRegisterHealthCheck(Capabilities capabilities) {
        return capabilities.isPresent(Capability.SMALLRYE_HEALTH);
    }
}
