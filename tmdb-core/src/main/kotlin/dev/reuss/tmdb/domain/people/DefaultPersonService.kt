package dev.reuss.tmdb.domain.people

import dev.reuss.tmdb.common.external.ExternalIds
import dev.reuss.tmdb.common.image.PersonImages
import dev.reuss.tmdb.core.http.QueryParams
import dev.reuss.tmdb.core.http.TmdbHttpClient
import dev.reuss.tmdb.core.http.TmdbRequest
import dev.reuss.tmdb.domain.people.model.*
import dev.reuss.tmdb.domain.people.query.PopularPeopleQuery
import dev.reuss.tmdb.query.AppendToResponse
import dev.reuss.tmdb.query.ChangesQuery
import dev.reuss.tmdb.query.QueryValidation
import dev.reuss.tmdb.value.id.PersonId
import dev.reuss.tmdb.value.language.Language

/**
 * Default [PersonService] implementation backed by the TMDB HTTP client.
 */
internal class DefaultPersonService(
    private val httpClient: TmdbHttpClient
) : PersonService {

    override fun details(personId: PersonId): PersonDetails =
        httpClient.get(
            TmdbRequest.get(PeoplePaths.details(personId)),
            PersonDetails::class.java
        )

    override fun details(
        personId: PersonId,
        language: Language
    ): PersonDetails =
        httpClient.get(
            TmdbRequest.get(
                PeoplePaths.details(personId),
                QueryParams.create()
                    .add("language", language.value)
            ),
            PersonDetails::class.java
        )

    override fun details(
        personId: PersonId,
        appendToResponse: AppendToResponse<PersonAppend>
    ): PersonDetails =
        httpClient.get(
            TmdbRequest.get(
                PeoplePaths.details(personId),
                QueryParams.create()
                    .add("append_to_response", appendToResponse)
            ),
            PersonDetails::class.java
        )

    override fun details(
        personId: PersonId,
        language: Language,
        appendToResponse: AppendToResponse<PersonAppend>
    ): PersonDetails =
        httpClient.get(
            TmdbRequest.get(
                PeoplePaths.details(personId),
                QueryParams.create()
                    .add("language", language.value)
                    .add("append_to_response", appendToResponse)
            ),
            PersonDetails::class.java
        )

    override fun changes(personId: PersonId): PersonChanges =
        httpClient.get(
            TmdbRequest.get(PeoplePaths.changes(personId)),
            PersonChanges::class.java
        )

    override fun changes(
        personId: PersonId,
        query: ChangesQuery
    ): PersonChanges =
        httpClient.get(
            TmdbRequest.get(
                PeoplePaths.changes(personId),
                query.toQueryParams()
            ),
            PersonChanges::class.java
        )

    override fun combinedCredits(personId: PersonId): PersonCombinedCredits =
        httpClient.get(
            TmdbRequest.get(PeoplePaths.combinedCredits(personId)),
            PersonCombinedCredits::class.java
        )

    override fun combinedCredits(
        personId: PersonId,
        language: Language
    ): PersonCombinedCredits =
        httpClient.get(
            TmdbRequest.get(
                PeoplePaths.combinedCredits(personId),
                QueryParams.create()
                    .add("language", language.value)
            ),
            PersonCombinedCredits::class.java
        )

    override fun externalIds(personId: PersonId): ExternalIds =
        httpClient.get(
            TmdbRequest.get(PeoplePaths.externalIds(personId)),
            ExternalIds::class.java
        )

    override fun latest(): PersonDetails =
        httpClient.get(
            TmdbRequest.get(PeoplePaths.latest()),
            PersonDetails::class.java
        )

    override fun movieCredits(personId: PersonId): PersonMovieCredits =
        httpClient.get(
            TmdbRequest.get(PeoplePaths.movieCredits(personId)),
            PersonMovieCredits::class.java
        )

    override fun movieCredits(
        personId: PersonId,
        language: Language
    ): PersonMovieCredits =
        httpClient.get(
            TmdbRequest.get(
                PeoplePaths.movieCredits(personId),
                QueryParams.create()
                    .add("language", language.value)
            ),
            PersonMovieCredits::class.java
        )

    override fun tvCredits(personId: PersonId): PersonTvCredits =
        httpClient.get(
            TmdbRequest.get(PeoplePaths.tvCredits(personId)),
            PersonTvCredits::class.java
        )

    override fun tvCredits(
        personId: PersonId,
        language: Language
    ): PersonTvCredits =
        httpClient.get(
            TmdbRequest.get(
                PeoplePaths.tvCredits(personId),
                QueryParams.create()
                    .add("language", language.value)
            ),
            PersonTvCredits::class.java
        )

    override fun translations(personId: PersonId): PersonTranslations =
        httpClient.get(
            TmdbRequest.get(PeoplePaths.translations(personId)),
            PersonTranslations::class.java
        )

    override fun popular(): PopularPeopleResponse =
        httpClient.get(
            TmdbRequest.get(PeoplePaths.popular()),
            PopularPeopleResponse::class.java
        )

    override fun popular(language: Language): PopularPeopleResponse =
        httpClient.get(
            TmdbRequest.get(
                PeoplePaths.popular(),
                QueryParams.create()
                    .add("language", language.value)
            ),
            PopularPeopleResponse::class.java
        )

    override fun popular(page: Int): PopularPeopleResponse {
        QueryValidation.validatePage(page)

        return httpClient.get(
            TmdbRequest.get(
                PeoplePaths.popular(),
                QueryParams.create()
                    .add("page", page)
            ),
            PopularPeopleResponse::class.java
        )
    }

    override fun popular(query: PopularPeopleQuery): PopularPeopleResponse =
        httpClient.get(
            TmdbRequest.get(
                PeoplePaths.popular(),
                query.toQueryParams()
            ),
            PopularPeopleResponse::class.java
        )

    override fun images(personId: PersonId): PersonImages =
        httpClient.get(
            TmdbRequest.get(PeoplePaths.images(personId)),
            PersonImages::class.java
        )
}