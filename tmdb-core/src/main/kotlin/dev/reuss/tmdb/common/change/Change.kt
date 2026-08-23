package dev.reuss.tmdb.common.change

import dev.reuss.tmdb.common.TmdbModel

/**
 * Change group for a TMDB resource field.
 *
 * @property key   changed field key
 * @property items change items
 */
@JvmRecord
data class Change(
    val key: String?,
    val items: List<ChangeItem> = emptyList(),
) : TmdbModel
