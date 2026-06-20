package dev.reuss.tmdb.quarkus.deployment;

import dev.reuss.tmdb.TmdbClient;
import dev.reuss.tmdb.core.config.TmdbClientConfig;
import dev.reuss.tmdb.core.metrics.TmdbMetricsRecorder;
import dev.reuss.tmdb.quarkus.runtime.TmdbProducer;
import io.quarkus.deployment.Capabilities;
import io.quarkus.deployment.IsDevelopment;
import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.deployment.builditem.CombinedIndexBuildItem;
import io.quarkus.deployment.pkg.builditem.CurateOutcomeBuildItem;
import io.quarkus.devui.spi.page.CardPageBuildItem;
import io.quarkus.devui.spi.page.Page;
import io.quarkus.maven.dependency.ResolvedDependency;
import org.eclipse.microprofile.config.ConfigProvider;

import jakarta.enterprise.inject.Produces;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Provides TMDB extension pages for the Quarkus Dev UI.
 */
public class TmdbDevUiProcessor {

    private static final String NOT_CONFIGURED = "not configured";
    private static final String ACTIVE = "active";
    private static final String INACTIVE = "inactive";

    @BuildStep(onlyIf = IsDevelopment.class)
    CardPageBuildItem devUiPages(
            CurateOutcomeBuildItem curateOutcome,
            Capabilities capabilities,
            CombinedIndexBuildItem combinedIndex
    ) {
        String baseUrl = configValue("tmdb.base-url", TmdbClientConfig.DEFAULT_BASE_URL);
        boolean accessTokenConfigured = isConfigured("tmdb.access-token");
        boolean healthActive = TmdbHealthProcessor.shouldRegisterHealthCheck(capabilities);
        boolean metricsActive = TmdbMetricsProcessor.shouldRegisterMetrics(capabilities);
        int reflectionClassCount = TmdbNativeImageProcessor.reflectionClassNames(combinedIndex.getIndex()).size();

        CardPageBuildItem card = new CardPageBuildItem();
        card.addPage(Page.tableDataPageBuilder("Configuration")
                .icon("font-awesome-solid:gear")
                .buildTimeDataKey("configuration")
                .showColumn("name")
                .showColumn("value"));

        card.addPage(Page.tableDataPageBuilder("Status")
                .icon("font-awesome-solid:circle-check")
                .buildTimeDataKey("status")
                .showColumn("name")
                .showColumn("status")
                .showColumn("details"));

        card.addPage(Page.tableDataPageBuilder("CDI Services")
                .icon("font-awesome-solid:plug")
                .staticLabel(String.valueOf(cdiServiceClassNames().size()))
                .buildTimeDataKey("services")
                .showColumn("name")
                .showColumn("type"));

        if (healthActive) {
            card.addPage(Page.externalPageBuilder("Health")
                    .icon("font-awesome-solid:heart-pulse")
                    .url("/q/health")
                    .doNotEmbed(true));
        }

        if (metricsActive) {
            card.addPage(Page.externalPageBuilder("Metrics")
                    .icon("font-awesome-solid:chart-line")
                    .url("/q/metrics")
                    .doNotEmbed(true));
        }

        card.addPage(Page.externalPageBuilder("TMDB Docs")
                .icon("font-awesome-solid:book")
                .url("https://developer.themoviedb.org/reference/intro/getting-started")
                .doNotEmbed(true));

        card.addBuildTimeData("configuration", devUiConfigurationRows(
                extensionVersion(curateOutcome),
                baseUrl,
                configValue("tmdb.default-language", TmdbClientConfig.DEFAULT_LANGUAGE),
                configValue("tmdb.default-region", NOT_CONFIGURED),
                configValue("tmdb.connect-timeout", TmdbClientConfig.DEFAULT_CONNECT_TIMEOUT),
                configValue("tmdb.request-timeout", TmdbClientConfig.DEFAULT_REQUEST_TIMEOUT),
                accessTokenConfigured));

        card.addBuildTimeData("status", devUiStatusRows(
                accessTokenConfigured,
                baseUrl,
                healthActive,
                metricsActive,
                reflectionClassCount));

        card.addBuildTimeData("services", devUiServiceRows());

        return card;
    }

    static List<Map<String, String>> devUiConfigurationRows(
            String extensionVersion,
            String baseUrl,
            String defaultLanguage,
            String defaultRegion,
            String connectTimeout,
            String requestTimeout,
            boolean accessTokenConfigured
    ) {
        return List.of(
                row("name", "Extension Version", "value", extensionVersion),
                row("name", "Base URL", "value", baseUrl),
                row("name", "Default Language", "value", defaultLanguage),
                row("name", "Default Region", "value", defaultRegion),
                row("name", "Connect Timeout", "value", connectTimeout),
                row("name", "Request Timeout", "value", requestTimeout),
                row("name", "Access Token", "value", accessTokenConfigured ? "configured" : NOT_CONFIGURED));
    }

    static List<Map<String, String>> devUiStatusRows(
            boolean accessTokenConfigured,
            String baseUrl,
            boolean healthActive,
            boolean metricsActive,
            int reflectionClassCount
    ) {
        boolean baseUrlValid = isValidUri(baseUrl);
        boolean configReady = accessTokenConfigured && baseUrlValid;

        return List.of(
                statusRow("Configuration", configReady ? "ready" : "incomplete",
                        configReady ? "Required TMDB configuration is present" : "Check access token and base URL"),
                statusRow("Access Token", accessTokenConfigured ? "configured" : NOT_CONFIGURED,
                        "Token value is intentionally hidden"),
                statusRow("Base URL", baseUrlValid ? "valid" : "invalid", baseUrl),
                statusRow("Health Capability", healthActive ? ACTIVE : INACTIVE,
                        "Requires the SmallRye Health extension"),
                statusRow("Metrics Capability", metricsActive ? ACTIVE : INACTIVE,
                        "Requires a Quarkus metrics extension such as Micrometer"),
                statusRow("Native Reflection", "registered", reflectionClassCount + " SDK model classes"));
    }

    static List<Map<String, String>> devUiServiceRows() {
        return cdiServiceClassNames().stream()
                .map(className -> row("name", simpleName(className), "type", className))
                .toList();
    }

    static List<String> cdiServiceClassNames() {
        List<String> serviceClassNames = new ArrayList<>();
        serviceClassNames.add(TmdbClient.class.getName());

        Arrays.stream(TmdbProducer.class.getDeclaredMethods())
                .filter(method -> method.isAnnotationPresent(Produces.class))
                .map(Method::getReturnType)
                .filter(type -> !TmdbMetricsRecorder.class.equals(type))
                .map(Class::getName)
                .sorted(Comparator.comparing(TmdbDevUiProcessor::simpleName))
                .forEach(serviceClassNames::add);

        return List.copyOf(serviceClassNames);
    }

    private static String extensionVersion(CurateOutcomeBuildItem curateOutcome) {
        return curateOutcome.getApplicationModel().getDependencies()
                .stream()
                .filter(dependency -> "dev.reuss.tmdb".equals(dependency.getGroupId()))
                .filter(dependency -> "quarkus-tmdb".equals(dependency.getArtifactId()))
                .map(ResolvedDependency::getVersion)
                .findFirst()
                .or(TmdbDevUiProcessor::packageVersion)
                .orElse("development");
    }

    private static Optional<String> packageVersion() {
        return Optional.ofNullable(TmdbDevUiProcessor.class.getPackage().getImplementationVersion())
                .filter(value -> !value.isBlank());
    }

    private static String configValue(String name, String defaultValue) {
        return ConfigProvider.getConfig()
                .getOptionalValue(name, String.class)
                .filter(value -> !value.isBlank())
                .orElse(defaultValue);
    }

    private static boolean isConfigured(String name) {
        return ConfigProvider.getConfig()
                .getOptionalValue(name, String.class)
                .filter(value -> !value.isBlank())
                .isPresent();
    }

    private static boolean isValidUri(String value) {
        try {
            URI uri = new URI(value);
            return uri.getScheme() != null && uri.getHost() != null;
        } catch (URISyntaxException exception) {
            return false;
        }
    }

    private static Map<String, String> row(String firstKey, String firstValue, String secondKey, String secondValue) {
        Map<String, String> row = new LinkedHashMap<>();
        row.put(firstKey, firstValue);
        row.put(secondKey, secondValue);
        return row;
    }

    private static Map<String, String> statusRow(String name, String status, String details) {
        Map<String, String> row = new LinkedHashMap<>();
        row.put("name", name);
        row.put("status", status);
        row.put("details", details);
        return row;
    }

    private static String simpleName(String className) {
        return className.substring(className.lastIndexOf('.') + 1);
    }
}
