package dev.reuss.tmdb.value.language

import dev.reuss.tmdb.value.region.Region
import dev.reuss.tmdb.value.region.Regions

/**
 * Common TMDB language tag constants.
 *
 * TMDB commonly uses language tags composed of an ISO 639-1
 * language code and an ISO 3166-1 alpha-2 region code, for example
 * `de-DE`, `en-US` or `pt-BR`.
 *
 * This object is a convenience holder for frequently used language
 * tags. It is not intended to list every possible language-region
 * combination. Custom language tags can still be created with
 * [Language.of].
 *
 * @see Language
 * @see LanguageCode
 * @see Region
 */
object Languages {

    @JvmField
    val DE_DE = Language.of(LanguageCodes.DE, Regions.DE)

    @JvmField
    val EN_GB = Language.of(LanguageCodes.EN, Regions.GB)

    @JvmField
    val EN_US = Language.of(LanguageCodes.EN, Regions.US)

    @JvmField
    val ES_ES = Language.of(LanguageCodes.ES, Regions.ES)

    @JvmField
    val FR_FR = Language.of(LanguageCodes.FR, Regions.FR)

    @JvmField
    val IT_IT = Language.of(LanguageCodes.IT, Regions.IT)

    @JvmField
    val JA_JP = Language.of(LanguageCodes.JA, Regions.JP)

    @JvmField
    val KO_KR = Language.of(LanguageCodes.KO, Regions.KR)

    @JvmField
    val PT_BR = Language.of(LanguageCodes.PT, Regions.BR)

    @JvmField
    val ZH_CN = Language.of(LanguageCodes.ZH, Regions.CN)

    @JvmField
    val ZH_TW = Language.of(LanguageCodes.ZH, Regions.TW)

    @JvmField
    val ALL: Set<Language> = setOf(
        DE_DE,
        EN_GB,
        EN_US,
        ES_ES,
        FR_FR,
        IT_IT,
        JA_JP,
        KO_KR,
        PT_BR,
        ZH_CN,
        ZH_TW
    )
}