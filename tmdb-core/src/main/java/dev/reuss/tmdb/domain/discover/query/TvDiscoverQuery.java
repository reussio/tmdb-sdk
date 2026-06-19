package dev.reuss.tmdb.domain.discover.query;

import dev.reuss.tmdb.core.http.QueryParams;
import dev.reuss.tmdb.domain.discover.model.TvDiscoverSortBy;
import dev.reuss.tmdb.query.PagedQuery;
import dev.reuss.tmdb.query.QueryValidation;
import dev.reuss.tmdb.value.language.Language;
import dev.reuss.tmdb.value.region.Region;

import java.time.LocalDate;

/**
 * Query parameters for TMDB TV discovery.
 */
public final class TvDiscoverQuery implements PagedQuery<TvDiscoverQuery> {

    private LocalDate airDateGte;
    private LocalDate airDateLte;

    private Integer firstAirDateYear;
    private LocalDate firstAirDateGte;
    private LocalDate firstAirDateLte;

    private Boolean includeAdult;
    private Boolean includeNullFirstAirDates;

    private Language language;
    private Integer page;

    private Boolean screenedTheatrically;

    private TvDiscoverSortBy sortBy;

    private String timezone;

    private Double voteAverageGte;
    private Double voteAverageLte;
    private Double voteCountGte;
    private Double voteCountLte;

    private Region watchRegion;

    private String withCompanies;
    private String withGenres;
    private String withKeywords;
    private Integer withNetworks;
    private String withOriginCountry;
    private String withOriginalLanguage;

    private Integer withRuntimeGte;
    private Integer withRuntimeLte;

    private String withStatus;
    private String withWatchMonetizationTypes;
    private String withWatchProviders;

    private String withoutCompanies;
    private String withoutGenres;
    private String withoutKeywords;
    private String withoutWatchProviders;

    private String withType;

    private TvDiscoverQuery() {
    }

    public static TvDiscoverQuery create() {
        return new TvDiscoverQuery();
    }

    public TvDiscoverQuery airDateGte(LocalDate airDateGte) {
        this.airDateGte = airDateGte;
        return this;
    }

    public TvDiscoverQuery airDateLte(LocalDate airDateLte) {
        this.airDateLte = airDateLte;
        return this;
    }

    public TvDiscoverQuery firstAirDateYear(int firstAirDateYear) {
        QueryValidation.validateYear(firstAirDateYear, "First air date year");
        this.firstAirDateYear = firstAirDateYear;
        return this;
    }

    public TvDiscoverQuery firstAirDateGte(LocalDate firstAirDateGte) {
        this.firstAirDateGte = firstAirDateGte;
        return this;
    }

    public TvDiscoverQuery firstAirDateLte(LocalDate firstAirDateLte) {
        this.firstAirDateLte = firstAirDateLte;
        return this;
    }

    public TvDiscoverQuery includeAdult(boolean includeAdult) {
        this.includeAdult = includeAdult;
        return this;
    }

    public TvDiscoverQuery includeNullFirstAirDates(boolean includeNullFirstAirDates) {
        this.includeNullFirstAirDates = includeNullFirstAirDates;
        return this;
    }

    public TvDiscoverQuery language(Language language) {
        this.language = language;
        return this;
    }

    public TvDiscoverQuery page(Integer page) {
        QueryValidation.validatePage(page);
        this.page = page;
        return this;
    }

    public TvDiscoverQuery screenedTheatrically(boolean screenedTheatrically) {
        this.screenedTheatrically = screenedTheatrically;
        return this;
    }

    public TvDiscoverQuery sortBy(TvDiscoverSortBy sortBy) {
        this.sortBy = sortBy;
        return this;
    }

    public TvDiscoverQuery timezone(String timezone) {
        this.timezone = timezone;
        return this;
    }

    public TvDiscoverQuery voteAverageGte(double voteAverageGte) {
        this.voteAverageGte = voteAverageGte;
        return this;
    }

    public TvDiscoverQuery voteAverageLte(double voteAverageLte) {
        this.voteAverageLte = voteAverageLte;
        return this;
    }

    public TvDiscoverQuery voteCountGte(double voteCountGte) {
        this.voteCountGte = voteCountGte;
        return this;
    }

    public TvDiscoverQuery voteCountLte(double voteCountLte) {
        this.voteCountLte = voteCountLte;
        return this;
    }

    public TvDiscoverQuery watchRegion(Region watchRegion) {
        this.watchRegion = watchRegion;
        return this;
    }

    public TvDiscoverQuery withCompanies(String withCompanies) {
        this.withCompanies = withCompanies;
        return this;
    }

    public TvDiscoverQuery withGenres(String withGenres) {
        this.withGenres = withGenres;
        return this;
    }

    public TvDiscoverQuery withKeywords(String withKeywords) {
        this.withKeywords = withKeywords;
        return this;
    }

    public TvDiscoverQuery withNetworks(int withNetworks) {
        this.withNetworks = withNetworks;
        return this;
    }

    public TvDiscoverQuery withOriginCountry(String withOriginCountry) {
        this.withOriginCountry = withOriginCountry;
        return this;
    }

    public TvDiscoverQuery withOriginalLanguage(String withOriginalLanguage) {
        this.withOriginalLanguage = withOriginalLanguage;
        return this;
    }

    public TvDiscoverQuery withRuntimeGte(int withRuntimeGte) {
        this.withRuntimeGte = withRuntimeGte;
        return this;
    }

    public TvDiscoverQuery withRuntimeLte(int withRuntimeLte) {
        this.withRuntimeLte = withRuntimeLte;
        return this;
    }

    public TvDiscoverQuery withStatus(String withStatus) {
        this.withStatus = withStatus;
        return this;
    }

    public TvDiscoverQuery withWatchMonetizationTypes(String withWatchMonetizationTypes) {
        this.withWatchMonetizationTypes = withWatchMonetizationTypes;
        return this;
    }

    public TvDiscoverQuery withWatchProviders(String withWatchProviders) {
        this.withWatchProviders = withWatchProviders;
        return this;
    }

    public TvDiscoverQuery withoutCompanies(String withoutCompanies) {
        this.withoutCompanies = withoutCompanies;
        return this;
    }

    public TvDiscoverQuery withoutGenres(String withoutGenres) {
        this.withoutGenres = withoutGenres;
        return this;
    }

    public TvDiscoverQuery withoutKeywords(String withoutKeywords) {
        this.withoutKeywords = withoutKeywords;
        return this;
    }

    public TvDiscoverQuery withoutWatchProviders(String withoutWatchProviders) {
        this.withoutWatchProviders = withoutWatchProviders;
        return this;
    }

    public TvDiscoverQuery withType(String withType) {
        this.withType = withType;
        return this;
    }

    @Override
    public QueryParams toQueryParams() {
        return QueryParams.create()
                .add("air_date.gte", airDateGte)
                .add("air_date.lte", airDateLte)
                .add("first_air_date_year", firstAirDateYear)
                .add("first_air_date.gte", firstAirDateGte)
                .add("first_air_date.lte", firstAirDateLte)
                .add("include_adult", includeAdult)
                .add("include_null_first_air_dates", includeNullFirstAirDates)
                .add("language", language)
                .add("page", page)
                .add("screened_theatrically", screenedTheatrically)
                .add("sort_by", sortBy == null ? null : sortBy.value())
                .add("timezone", timezone)
                .add("vote_average.gte", voteAverageGte)
                .add("vote_average.lte", voteAverageLte)
                .add("vote_count.gte", voteCountGte)
                .add("vote_count.lte", voteCountLte)
                .add("watch_region", watchRegion)
                .add("with_companies", withCompanies)
                .add("with_genres", withGenres)
                .add("with_keywords", withKeywords)
                .add("with_networks", withNetworks)
                .add("with_origin_country", withOriginCountry)
                .add("with_original_language", withOriginalLanguage)
                .add("with_runtime.gte", withRuntimeGte)
                .add("with_runtime.lte", withRuntimeLte)
                .add("with_status", withStatus)
                .add("with_watch_monetization_types", withWatchMonetizationTypes)
                .add("with_watch_providers", withWatchProviders)
                .add("without_companies", withoutCompanies)
                .add("without_genres", withoutGenres)
                .add("without_keywords", withoutKeywords)
                .add("without_watch_providers", withoutWatchProviders)
                .add("with_type", withType);
    }
}
