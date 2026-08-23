package dev.reuss.tmdb.quarkus.deployment

import dev.reuss.tmdb.TmdbClient
import dev.reuss.tmdb.core.config.TmdbClientConfig
import dev.reuss.tmdb.core.metrics.TmdbMetricsRecorder
import dev.reuss.tmdb.quarkus.runtime.TmdbProducer
import io.quarkus.deployment.Capabilities
import io.quarkus.deployment.IsDevelopment
import io.quarkus.deployment.annotations.BuildStep
import io.quarkus.deployment.builditem.CombinedIndexBuildItem
import io.quarkus.deployment.pkg.builditem.CurateOutcomeBuildItem
import io.quarkus.devui.spi.page.CardPageBuildItem
import io.quarkus.devui.spi.page.Page
import jakarta.enterprise.inject.Produces
import org.eclipse.microprofile.config.ConfigProvider
import java.net.URI
import java.net.URISyntaxException

/**
 * Provides TMDB extension pages for the Quarkus Dev UI.
 */
class TmdbDevUiProcessor {
    @BuildStep(onlyIf = [IsDevelopment::class])
    fun devUiPages(
        curateOutcome: CurateOutcomeBuildItem,
        capabilities: Capabilities,
        combinedIndex: CombinedIndexBuildItem,
    ): CardPageBuildItem {
        val baseUrl =
            configValue(
                "tmdb.base-url",
                TmdbClientConfig.DEFAULT_BASE_URL,
            )

        val accessTokenConfigured =
            isConfigured("tmdb.access-token")

        val healthActive =
            TmdbHealthProcessor.shouldRegisterHealthCheck(capabilities)

        val metricsActive =
            TmdbMetricsProcessor.shouldRegisterMetrics(capabilities)

        val reflectionClassCount =
            TmdbNativeImageProcessor
                .reflectionClassNames(combinedIndex.index)
                .size

        return CardPageBuildItem().apply {
            addPage(
                Page
                    .tableDataPageBuilder("Configuration")
                    .icon("font-awesome-solid:gear")
                    .buildTimeDataKey("configuration")
                    .showColumn("name")
                    .showColumn("value"),
            )

            addPage(
                Page
                    .tableDataPageBuilder("Status")
                    .icon("font-awesome-solid:circle-check")
                    .buildTimeDataKey("status")
                    .showColumn("name")
                    .showColumn("status")
                    .showColumn("details"),
            )

            addPage(
                Page
                    .tableDataPageBuilder("CDI Services")
                    .icon("font-awesome-solid:plug")
                    .staticLabel(cdiServiceClassNames().size.toString())
                    .buildTimeDataKey("services")
                    .showColumn("name")
                    .showColumn("type"),
            )

            if (healthActive) {
                addPage(
                    Page
                        .externalPageBuilder("Health")
                        .icon("font-awesome-solid:heart-pulse")
                        .url("/q/health")
                        .doNotEmbed(true),
                )
            }

            if (metricsActive) {
                addPage(
                    Page
                        .externalPageBuilder("Metrics")
                        .icon("font-awesome-solid:chart-line")
                        .url("/q/metrics")
                        .doNotEmbed(true),
                )
            }

            addPage(
                Page
                    .externalPageBuilder("TMDB Docs")
                    .icon("font-awesome-solid:book")
                    .url(
                        "https://developer.themoviedb.org/reference/intro/getting-started",
                    ).doNotEmbed(true),
            )

            addBuildTimeData(
                "configuration",
                devUiConfigurationRows(
                    extensionVersion(curateOutcome),
                    baseUrl,
                    configValue(
                        "tmdb.default-language",
                        TmdbClientConfig.DEFAULT_LANGUAGE,
                    ),
                    configValue(
                        "tmdb.default-region",
                        NOT_CONFIGURED,
                    ),
                    configValue(
                        "tmdb.connect-timeout",
                        TmdbClientConfig.DEFAULT_CONNECT_TIMEOUT,
                    ),
                    configValue(
                        "tmdb.request-timeout",
                        TmdbClientConfig.DEFAULT_REQUEST_TIMEOUT,
                    ),
                    accessTokenConfigured,
                ),
            )

            addBuildTimeData(
                "status",
                devUiStatusRows(
                    accessTokenConfigured,
                    baseUrl,
                    healthActive,
                    metricsActive,
                    reflectionClassCount,
                ),
            )

            addBuildTimeData(
                "services",
                devUiServiceRows(),
            )
        }
    }

    companion object {
        private const val NOT_CONFIGURED = "not configured"
        private const val ACTIVE = "active"
        private const val INACTIVE = "inactive"

        @JvmStatic
        fun devUiConfigurationRows(
            extensionVersion: String,
            baseUrl: String,
            defaultLanguage: String,
            defaultRegion: String,
            connectTimeout: String,
            requestTimeout: String,
            accessTokenConfigured: Boolean,
        ): List<Map<String, String>> =
            listOf(
                row(
                    "name",
                    "Extension Version",
                    "value",
                    extensionVersion,
                ),
                row(
                    "name",
                    "Base URL",
                    "value",
                    baseUrl,
                ),
                row(
                    "name",
                    "Default Language",
                    "value",
                    defaultLanguage,
                ),
                row(
                    "name",
                    "Default Region",
                    "value",
                    defaultRegion,
                ),
                row(
                    "name",
                    "Connect Timeout",
                    "value",
                    connectTimeout,
                ),
                row(
                    "name",
                    "Request Timeout",
                    "value",
                    requestTimeout,
                ),
                row(
                    "name",
                    "Access Token",
                    "value",
                    if (accessTokenConfigured) "configured" else NOT_CONFIGURED,
                ),
            )

        @JvmStatic
        fun devUiStatusRows(
            accessTokenConfigured: Boolean,
            baseUrl: String,
            healthActive: Boolean,
            metricsActive: Boolean,
            reflectionClassCount: Int,
        ): List<Map<String, String>> {
            val baseUrlValid = isValidUri(baseUrl)
            val configReady = accessTokenConfigured && baseUrlValid

            return listOf(
                statusRow(
                    "Configuration",
                    if (configReady) "ready" else "incomplete",
                    if (configReady) {
                        "Required TMDB configuration is present"
                    } else {
                        "Check access token and base URL"
                    },
                ),
                statusRow(
                    "Access Token",
                    if (accessTokenConfigured) "configured" else NOT_CONFIGURED,
                    "Token value is intentionally hidden",
                ),
                statusRow(
                    "Base URL",
                    if (baseUrlValid) "valid" else "invalid",
                    baseUrl,
                ),
                statusRow(
                    "Health Capability",
                    if (healthActive) ACTIVE else INACTIVE,
                    "Requires the SmallRye Health extension",
                ),
                statusRow(
                    "Metrics Capability",
                    if (metricsActive) ACTIVE else INACTIVE,
                    "Requires a Quarkus metrics extension such as Micrometer",
                ),
                statusRow(
                    "Native Reflection",
                    "registered",
                    "$reflectionClassCount SDK model classes",
                ),
            )
        }

        @JvmStatic
        fun devUiServiceRows(): List<Map<String, String>> =
            cdiServiceClassNames().map { className ->
                row(
                    "name",
                    simpleName(className),
                    "type",
                    className,
                )
            }

        @JvmStatic
        fun cdiServiceClassNames(): List<String> =
            buildList {
                add(TmdbClient::class.java.name)

                TmdbProducer::class.java.declaredMethods
                    .asSequence()
                    .filter {
                        it.isAnnotationPresent(Produces::class.java)
                    }.map { it.returnType }
                    .filterNot {
                        it == TmdbMetricsRecorder::class.java
                    }.map { it.name }
                    .sortedBy { simpleName(it) }
                    .forEach { className ->
                        add(className)
                    }
            }

        private fun extensionVersion(curateOutcome: CurateOutcomeBuildItem): String =
            curateOutcome.applicationModel.dependencies
                .firstOrNull {
                    it.groupId == "dev.reuss.tmdb" &&
                        it.artifactId == "quarkus-tmdb"
                }?.version
                ?: packageVersion()
                ?: "development"

        private fun packageVersion(): String? =
            TmdbDevUiProcessor::class.java
                .`package`
                .implementationVersion
                ?.takeIf { it.isNotBlank() }

        private fun configValue(
            name: String,
            defaultValue: String,
        ): String =
            ConfigProvider
                .getConfig()
                .getOptionalValue(name, String::class.java)
                .filter { it.isNotBlank() }
                .orElse(defaultValue)

        private fun isConfigured(name: String): Boolean =
            ConfigProvider
                .getConfig()
                .getOptionalValue(name, String::class.java)
                .filter { it.isNotBlank() }
                .isPresent

        private fun isValidUri(value: String): Boolean =
            try {
                val uri = URI(value)
                uri.scheme != null && uri.host != null
            } catch (_: URISyntaxException) {
                false
            }

        private fun row(
            firstKey: String,
            firstValue: String,
            secondKey: String,
            secondValue: String,
        ): Map<String, String> =
            linkedMapOf(
                firstKey to firstValue,
                secondKey to secondValue,
            )

        private fun statusRow(
            name: String,
            status: String,
            details: String,
        ): Map<String, String> =
            linkedMapOf(
                "name" to name,
                "status" to status,
                "details" to details,
            )

        private fun simpleName(className: String): String = className.substringAfterLast('.')
    }
}
