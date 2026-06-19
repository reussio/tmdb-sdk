package dev.reuss.tmdb.domain.people;

import dev.reuss.tmdb.common.external.ExternalIds;
import dev.reuss.tmdb.common.image.PersonImages;
import dev.reuss.tmdb.core.http.QueryParams;
import dev.reuss.tmdb.core.http.TmdbHttpClient;
import dev.reuss.tmdb.core.http.TmdbRequest;
import dev.reuss.tmdb.domain.people.model.*;
import dev.reuss.tmdb.domain.people.query.PopularPeopleQuery;
import dev.reuss.tmdb.query.AppendToResponse;
import dev.reuss.tmdb.query.ChangesQuery;
import dev.reuss.tmdb.query.QueryValidation;
import dev.reuss.tmdb.value.id.PersonId;
import dev.reuss.tmdb.value.language.Language;

import java.util.Objects;

/**
 * Default {@link PersonService} implementation backed by the TMDB HTTP client.
 */
public final class DefaultPersonService implements PersonService {

    private final TmdbHttpClient httpClient;

    public DefaultPersonService(TmdbHttpClient httpClient) {
        this.httpClient = Objects.requireNonNull(httpClient, "TMDB HTTP client must not be null");
    }

    @Override
    public PersonDetails details(PersonId personId) {
        Objects.requireNonNull(personId, "Person id must not be null");

        return httpClient.get(
                TmdbRequest.get(PeoplePaths.details(personId)),
                PersonDetails.class
        );
    }

    @Override
    public PersonDetails details(PersonId personId, Language language) {
        Objects.requireNonNull(personId, "Person id must not be null");
        Objects.requireNonNull(language, "Language must not be null");

        return httpClient.get(
                TmdbRequest.get(
                        PeoplePaths.details(personId),
                        QueryParams.create().add("language", language)
                ),
                PersonDetails.class
        );
    }

    @Override
    public PersonDetails details(PersonId personId, AppendToResponse<PersonAppend> appendToResponse) {
        Objects.requireNonNull(personId, "Person id must not be null");
        Objects.requireNonNull(appendToResponse, "Append to response must not be null");

        return httpClient.get(
                TmdbRequest.get(
                        PeoplePaths.details(personId),
                        QueryParams.create().add("append_to_response", appendToResponse)
                ),
                PersonDetails.class
        );
    }

    @Override
    public PersonDetails details(PersonId personId, Language language, AppendToResponse<PersonAppend> appendToResponse) {
        Objects.requireNonNull(personId, "Person id must not be null");
        Objects.requireNonNull(language, "Language must not be null");
        Objects.requireNonNull(appendToResponse, "Append to response must not be null");

        return httpClient.get(
                TmdbRequest.get(
                        PeoplePaths.details(personId),
                        QueryParams.create()
                                .add("language", language)
                                .add("append_to_response", appendToResponse)
                ),
                PersonDetails.class
        );
    }

    @Override
    public PersonChanges changes(PersonId personId) {
        Objects.requireNonNull(personId, "Person id must not be null");

        return httpClient.get(
                TmdbRequest.get(PeoplePaths.changes(personId)),
                PersonChanges.class
        );
    }

    @Override
    public PersonChanges changes(PersonId personId, ChangesQuery query) {
        Objects.requireNonNull(personId, "Person id must not be null");
        Objects.requireNonNull(query, "Person changes query must not be null");

        return httpClient.get(
                TmdbRequest.get(
                        PeoplePaths.changes(personId),
                        query.toQueryParams()
                ),
                PersonChanges.class
        );
    }

    @Override
    public PersonCombinedCredits combinedCredits(PersonId personId) {
        Objects.requireNonNull(personId, "Person id must not be null");

        return httpClient.get(
                TmdbRequest.get(PeoplePaths.combinedCredits(personId)),
                PersonCombinedCredits.class
        );
    }

    @Override
    public PersonCombinedCredits combinedCredits(PersonId personId, Language language) {
        Objects.requireNonNull(personId, "Person id must not be null");
        Objects.requireNonNull(language, "Language must not be null");

        return httpClient.get(
                TmdbRequest.get(
                        PeoplePaths.combinedCredits(personId),
                        QueryParams.create().add("language", language)
                ),
                PersonCombinedCredits.class
        );
    }

    @Override
    public ExternalIds externalIds(PersonId personId) {
        Objects.requireNonNull(personId, "Person id must not be null");

        return httpClient.get(
                TmdbRequest.get(PeoplePaths.externalIds(personId)),
                ExternalIds.class
        );
    }

    @Override
    public PersonDetails latest() {
        return httpClient.get(
                TmdbRequest.get(PeoplePaths.latest()),
                PersonDetails.class
        );
    }

    @Override
    public PersonMovieCredits movieCredits(PersonId personId) {
        Objects.requireNonNull(personId, "Person id must not be null");

        return httpClient.get(
                TmdbRequest.get(PeoplePaths.movieCredits(personId)),
                PersonMovieCredits.class
        );
    }

    @Override
    public PersonMovieCredits movieCredits(PersonId personId, Language language) {
        Objects.requireNonNull(personId, "Person id must not be null");
        Objects.requireNonNull(language, "Language must not be null");

        return httpClient.get(
                TmdbRequest.get(
                        PeoplePaths.movieCredits(personId),
                        QueryParams.create().add("language", language)
                ),
                PersonMovieCredits.class
        );
    }

    @Override
    public PersonTvCredits tvCredits(PersonId personId) {
        Objects.requireNonNull(personId, "Person id must not be null");

        return httpClient.get(
                TmdbRequest.get(PeoplePaths.tvCredits(personId)),
                PersonTvCredits.class
        );
    }

    @Override
    public PersonTvCredits tvCredits(PersonId personId, Language language) {
        Objects.requireNonNull(personId, "Person id must not be null");
        Objects.requireNonNull(language, "Language must not be null");

        return httpClient.get(
                TmdbRequest.get(
                        PeoplePaths.tvCredits(personId),
                        QueryParams.create().add("language", language)
                ),
                PersonTvCredits.class
        );
    }

    @Override
    public PersonTranslations translations(PersonId personId) {
        Objects.requireNonNull(personId, "Person id must not be null");

        return httpClient.get(
                TmdbRequest.get(PeoplePaths.translations(personId)),
                PersonTranslations.class
        );
    }

    @Override
    public PopularPeopleResponse popular() {
        return httpClient.get(
                TmdbRequest.get(PeoplePaths.popular()),
                PopularPeopleResponse.class
        );
    }

    @Override
    public PopularPeopleResponse popular(Language language) {
        Objects.requireNonNull(language, "Language must not be null");

        return httpClient.get(
                TmdbRequest.get(
                        PeoplePaths.popular(),
                        QueryParams.create().add("language", language)
                ),
                PopularPeopleResponse.class
        );
    }

    @Override
    public PopularPeopleResponse popular(int page) {
        QueryValidation.validatePage(page);

        return httpClient.get(
                TmdbRequest.get(
                        PeoplePaths.popular(),
                        QueryParams.create().add("page", page)
                ),
                PopularPeopleResponse.class
        );
    }

    @Override
    public PopularPeopleResponse popular(PopularPeopleQuery query) {
        Objects.requireNonNull(query, "Popular people query must not be null");

        return httpClient.get(
                TmdbRequest.get(
                        PeoplePaths.popular(),
                        query.toQueryParams()
                ),
                PopularPeopleResponse.class
        );
    }

    @Override
    public PersonImages images(PersonId personId) {
        Objects.requireNonNull(personId, "Person id must not be null");

        return httpClient.get(
                TmdbRequest.get(PeoplePaths.images(personId)),
                PersonImages.class
        );
    }
}
