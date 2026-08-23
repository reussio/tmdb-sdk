package dev.reuss.tmdb.quarkus.deployment

import dev.reuss.tmdb.quarkus.runtime.TmdbHealthCheck
import io.quarkus.arc.deployment.AdditionalBeanBuildItem
import io.quarkus.deployment.Capabilities
import io.quarkus.deployment.Capability
import io.quarkus.deployment.annotations.BuildProducer
import io.quarkus.deployment.annotations.BuildStep

/**
 * Registers TMDB health check support when Quarkus Health is present.
 */
class TmdbHealthProcessor {

    @BuildStep
    fun healthCheck(
        capabilities: Capabilities,
        additionalBeans: BuildProducer<AdditionalBeanBuildItem>
    ) {
        if (shouldRegisterHealthCheck(capabilities)) {
            additionalBeans.produce(
                AdditionalBeanBuildItem.builder()
                    .addBeanClass(TmdbHealthCheck::class.java)
                    .setUnremovable()
                    .build()
            )
        }
    }

    companion object {

        @JvmStatic
        fun shouldRegisterHealthCheck(
            capabilities: Capabilities
        ): Boolean =
            capabilities.isPresent(Capability.SMALLRYE_HEALTH)
    }
}