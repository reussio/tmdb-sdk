package dev.reuss.tmdb.domain.configuration;

final class ConfigurationPaths {

    private static final String CONFIGURATION = "/configuration";

    private ConfigurationPaths() {
    }

    static String details() {
        return CONFIGURATION;
    }

    static String countries() {
        return CONFIGURATION + "/countries";
    }

    static String jobs() {
        return CONFIGURATION + "/jobs";
    }

    static String languages() {
        return CONFIGURATION + "/languages";
    }

    static String primaryTranslations() {
        return CONFIGURATION + "/primary_translations";
    }

    static String timezones() {
        return CONFIGURATION + "/timezones";
    }
}
