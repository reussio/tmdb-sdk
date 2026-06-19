package dev.reuss.tmdb.value.language;

import dev.reuss.tmdb.value.region.Region;
import dev.reuss.tmdb.value.region.Regions;

/**
 * Common TMDB language tag constants.
 *
 * <p>TMDB commonly uses language tags composed of an ISO 639-1
 * language code and an ISO 3166-1 alpha-2 region code, for example
 * {@code de-DE}, {@code en-US} or {@code pt-BR}.</p>
 *
 * <p>This class is a convenience holder for frequently used language
 * tags. It is not intended to list every possible language-region
 * combination. Custom language tags can still be created with
 * {@link Language#of(String)}.</p>
 *
 * @see Language
 * @see LanguageCode
 * @see Region
 * @see <a href="https://developer.themoviedb.org/docs/languages">TMDB Languages</a>
 */
public final class Languages {

    public static final Language DE_DE = Language.of(LanguageCodes.DE, Regions.DE);
    public static final Language EN_US = Language.of(LanguageCodes.EN, Regions.US);
    public static final Language EN_GB = Language.of(LanguageCodes.EN, Regions.GB);
    public static final Language PT_BR = Language.of(LanguageCodes.PT, Regions.BR);
    public static final Language ES_ES = Language.of(LanguageCodes.ES, Regions.ES);
    public static final Language FR_FR = Language.of(LanguageCodes.FR, Regions.FR);
    public static final Language IT_IT = Language.of(LanguageCodes.IT, Regions.IT);
    public static final Language JA_JP = Language.of(LanguageCodes.JA, Regions.JP);
    public static final Language KO_KR = Language.of(LanguageCodes.KO, Regions.KR);
    public static final Language ZH_CN = Language.of(LanguageCodes.ZH, Regions.CN);
    public static final Language ZH_TW = Language.of(LanguageCodes.ZH, Regions.TW);

    private Languages() {
    }
}