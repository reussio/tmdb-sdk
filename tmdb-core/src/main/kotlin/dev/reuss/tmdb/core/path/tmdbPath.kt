package dev.reuss.tmdb.core.path

import dev.reuss.tmdb.value.id.TmdbResourceId

internal fun tmdbPath(vararg segments: Any): String =
    segments.joinToString(
        separator = "/",
        prefix = "/"
    ) { segment ->
        when (segment) {
            is TmdbResourceId -> segment.asString()
            else -> segment.toString().trim('/')
        }
    }