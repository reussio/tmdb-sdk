package dev.reuss.tmdb.domain.certifications

import dev.reuss.tmdb.core.path.tmdbPath

internal object CertificationPaths {
    fun movieCertifications(): String = tmdbPath("certification", "movie", "list")

    fun tvCertifications(): String = tmdbPath("certification", "tv", "list")
}
