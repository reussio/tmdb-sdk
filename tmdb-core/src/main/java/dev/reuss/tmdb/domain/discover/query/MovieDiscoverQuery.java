package dev.reuss.tmdb.domain.discover.query;

import dev.reuss.tmdb.core.http.QueryParams;
import dev.reuss.tmdb.domain.discover.model.MovieDiscoverSortBy;
import dev.reuss.tmdb.query.PagedQuery;
import dev.reuss.tmdb.query.QueryValidation;
import dev.reuss.tmdb.value.language.Language;
import dev.reuss.tmdb.value.region.Region;

import java.time.LocalDate;

/**
 * Query parameters for TMDB movie discovery.
 */
public final class MovieDiscoverQuery implements PagedQuery<MovieDiscoverQuery> {

    private String certification;
    private String certificationGte;
    private String certificationLte;
    private String certificationCountry;

    private Boolean includeAdult;
    private Boolean includeVideo;

    private Language language;
    private Integer page;

    private Integer primaryReleaseYear;
    private LocalDate primaryReleaseDateGte;
    private LocalDate primaryReleaseDateLte;

    private Region region;

    private LocalDate releaseDateGte;
    private LocalDate releaseDateLte;

    private MovieDiscoverSortBy sortBy;

    private Double voteAverageGte;
    private Double voteAverageLte;
    private Double voteCountGte;
    private Double voteCountLte;

    private Region watchRegion;

    private String withCast;
    private String withCompanies;
    private String withCrew;
    private String withGenres;
    private String withKeywords;
    private String withOriginCountry;
    private String withOriginalLanguage;
    private String withPeople;
    private String withReleaseType;

    private Integer withRuntimeGte;
    private Integer withRuntimeLte;

    private String withWatchMonetizationTypes;
    private String withWatchProviders;

    private String withoutCompanies;
    private String withoutGenres;
    private String withoutKeywords;
    private String withoutWatchProviders;

    private Integer year;

    private MovieDiscoverQuery() {
    }

    public static MovieDiscoverQuery create() {
        return new MovieDiscoverQuery();
    }

    public MovieDiscoverQuery certification(String certification) {
        this.certification = certification;
        return this;
    }

    public MovieDiscoverQuery certificationGte(String certificationGte) {
        this.certificationGte = certificationGte;
        return this;
    }

    public MovieDiscoverQuery certificationLte(String certificationLte) {
        this.certificationLte = certificationLte;
        return this;
    }

    public MovieDiscoverQuery certificationCountry(String certificationCountry) {
        this.certificationCountry = certificationCountry;
        return this;
    }

    public MovieDiscoverQuery includeAdult(boolean includeAdult) {
        this.includeAdult = includeAdult;
        return this;
    }

    public MovieDiscoverQuery includeVideo(boolean includeVideo) {
        this.includeVideo = includeVideo;
        return this;
    }

    public MovieDiscoverQuery language(Language language) {
        this.language = language;
        return this;
    }

    public MovieDiscoverQuery page(Integer page) {
        QueryValidation.validatePage(page);
        this.page = page;
        return this;
    }

    public MovieDiscoverQuery primaryReleaseYear(int primaryReleaseYear) {
        QueryValidation.validateYear(primaryReleaseYear, "Primary release year");
        this.primaryReleaseYear = primaryReleaseYear;
        return this;
    }

    public MovieDiscoverQuery primaryReleaseDateGte(LocalDate primaryReleaseDateGte) {
        this.primaryReleaseDateGte = primaryReleaseDateGte;
        return this;
    }

    public MovieDiscoverQuery primaryReleaseDateLte(LocalDate primaryReleaseDateLte) {
        this.primaryReleaseDateLte = primaryReleaseDateLte;
        return this;
    }

    public MovieDiscoverQuery region(Region region) {
        this.region = region;
        return this;
    }

    public MovieDiscoverQuery releaseDateGte(LocalDate releaseDateGte) {
        this.releaseDateGte = releaseDateGte;
        return this;
    }

    public MovieDiscoverQuery releaseDateLte(LocalDate releaseDateLte) {
        this.releaseDateLte = releaseDateLte;
        return this;
    }

    public MovieDiscoverQuery sortBy(MovieDiscoverSortBy sortBy) {
        this.sortBy = sortBy;
        return this;
    }

    public MovieDiscoverQuery voteAverageGte(double voteAverageGte) {
        this.voteAverageGte = voteAverageGte;
        return this;
    }

    public MovieDiscoverQuery voteAverageLte(double voteAverageLte) {
        this.voteAverageLte = voteAverageLte;
        return this;
    }

    public MovieDiscoverQuery voteCountGte(double voteCountGte) {
        this.voteCountGte = voteCountGte;
        return this;
    }

    public MovieDiscoverQuery voteCountLte(double voteCountLte) {
        this.voteCountLte = voteCountLte;
        return this;
    }

    public MovieDiscoverQuery watchRegion(Region watchRegion) {
        this.watchRegion = watchRegion;
        return this;
    }

    public MovieDiscoverQuery withCast(String withCast) {
        this.withCast = withCast;
        return this;
    }

    public MovieDiscoverQuery withCompanies(String withCompanies) {
        this.withCompanies = withCompanies;
        return this;
    }

    public MovieDiscoverQuery withCrew(String withCrew) {
        this.withCrew = withCrew;
        return this;
    }

    public MovieDiscoverQuery withGenres(String withGenres) {
        this.withGenres = withGenres;
        return this;
    }

    public MovieDiscoverQuery withKeywords(String withKeywords) {
        this.withKeywords = withKeywords;
        return this;
    }

    public MovieDiscoverQuery withOriginCountry(String withOriginCountry) {
        this.withOriginCountry = withOriginCountry;
        return this;
    }

    public MovieDiscoverQuery withOriginalLanguage(String withOriginalLanguage) {
        this.withOriginalLanguage = withOriginalLanguage;
        return this;
    }

    public MovieDiscoverQuery withPeople(String withPeople) {
        this.withPeople = withPeople;
        return this;
    }

    public MovieDiscoverQuery withReleaseType(String withReleaseType) {
        this.withReleaseType = withReleaseType;
        return this;
    }

    public MovieDiscoverQuery withRuntimeGte(int withRuntimeGte) {
        this.withRuntimeGte = withRuntimeGte;
        return this;
    }

    public MovieDiscoverQuery withRuntimeLte(int withRuntimeLte) {
        this.withRuntimeLte = withRuntimeLte;
        return this;
    }

    public MovieDiscoverQuery withWatchMonetizationTypes(String withWatchMonetizationTypes) {
        this.withWatchMonetizationTypes = withWatchMonetizationTypes;
        return this;
    }

    public MovieDiscoverQuery withWatchProviders(String withWatchProviders) {
        this.withWatchProviders = withWatchProviders;
        return this;
    }

    public MovieDiscoverQuery withoutCompanies(String withoutCompanies) {
        this.withoutCompanies = withoutCompanies;
        return this;
    }

    public MovieDiscoverQuery withoutGenres(String withoutGenres) {
        this.withoutGenres = withoutGenres;
        return this;
    }

    public MovieDiscoverQuery withoutKeywords(String withoutKeywords) {
        this.withoutKeywords = withoutKeywords;
        return this;
    }

    public MovieDiscoverQuery withoutWatchProviders(String withoutWatchProviders) {
        this.withoutWatchProviders = withoutWatchProviders;
        return this;
    }

    public MovieDiscoverQuery year(int year) {
        QueryValidation.validateYear(year, "Year");
        this.year = year;
        return this;
    }

    @Override
    public QueryParams toQueryParams() {
        return QueryParams.create()
                .add("certification", certification)
                .add("certification.gte", certificationGte)
                .add("certification.lte", certificationLte)
                .add("certification_country", certificationCountry)
                .add("include_adult", includeAdult)
                .add("include_video", includeVideo)
                .add("language", language)
                .add("page", page)
                .add("primary_release_year", primaryReleaseYear)
                .add("primary_release_date.gte", primaryReleaseDateGte)
                .add("primary_release_date.lte", primaryReleaseDateLte)
                .add("region", region)
                .add("release_date.gte", releaseDateGte)
                .add("release_date.lte", releaseDateLte)
                .add("sort_by", sortBy == null ? null : sortBy.value())
                .add("vote_average.gte", voteAverageGte)
                .add("vote_average.lte", voteAverageLte)
                .add("vote_count.gte", voteCountGte)
                .add("vote_count.lte", voteCountLte)
                .add("watch_region", watchRegion)
                .add("with_cast", withCast)
                .add("with_companies", withCompanies)
                .add("with_crew", withCrew)
                .add("with_genres", withGenres)
                .add("with_keywords", withKeywords)
                .add("with_origin_country", withOriginCountry)
                .add("with_original_language", withOriginalLanguage)
                .add("with_people", withPeople)
                .add("with_release_type", withReleaseType)
                .add("with_runtime.gte", withRuntimeGte)
                .add("with_runtime.lte", withRuntimeLte)
                .add("with_watch_monetization_types", withWatchMonetizationTypes)
                .add("with_watch_providers", withWatchProviders)
                .add("without_companies", withoutCompanies)
                .add("without_genres", withoutGenres)
                .add("without_keywords", withoutKeywords)
                .add("without_watch_providers", withoutWatchProviders)
                .add("year", year);
    }
}
