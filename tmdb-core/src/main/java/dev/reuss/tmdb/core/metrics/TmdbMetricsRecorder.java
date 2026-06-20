package dev.reuss.tmdb.core.metrics;

import java.time.Duration;

public interface TmdbMetricsRecorder {

    TmdbMetricsRecorder NOOP = new TmdbMetricsRecorder() {
        @Override
        public void recordRequestStarted(String method, String path) {
        }

        @Override
        public void recordRequestFinished(String method, String path, int statusCode, Duration duration, long responseBytes) {
        }

        @Override
        public void recordRequestFailed(String method, String path, Throwable exception, Duration duration) {
        }

        @Override
        public void recordMappingFailed(String method, String path, Class<?> responseType, Throwable exception) {
        }
    };

    void recordRequestStarted(String method, String path);

    void recordRequestFinished(String method, String path, int statusCode, Duration duration, long responseBytes);

    void recordRequestFailed(String method, String path, Throwable exception, Duration duration);

    void recordMappingFailed(String method, String path, Class<?> responseType, Throwable exception);
}
