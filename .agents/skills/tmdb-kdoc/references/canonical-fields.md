# Canonical TMDB Field Documentation

Use these descriptions verbatim when the Kotlin property and JSON field carry the
same semantics. Scoped entries intentionally distinguish fields that share a name
but describe different concepts.

| Scope                                 | Kotlin property            | JSON field             | Canonical description                                              |
|---------------------------------------|----------------------------|------------------------|--------------------------------------------------------------------|
| Image-bearing models                  | `logoPath`                 | `logo_path`            | TMDB image path for the logo.                                      |
| Image-bearing models                  | `posterPath`               | `poster_path`          | TMDB image path for the poster.                                    |
| Image-bearing models                  | `backdropPath`             | `backdrop_path`        | TMDB image path for the backdrop.                                  |
| Person-bearing models                 | `profilePath`              | `profile_path`         | TMDB image path for the profile image.                             |
| Episode-bearing models                | `stillPath`                | `still_path`           | TMDB image path for the episode still.                             |
| Image metadata                        | `filePath`                 | `file_path`            | TMDB image path for this image.                                    |
| Media and person models               | `adult`                    | `adult`                | Whether TMDB marks the resource as adult content.                  |
| Movie and TV models                   | `originalLanguage`         | `original_language`    | ISO 639-1 code for the resource's original language.               |
| Models with one origin country        | `originCountry`            | `origin_country`       | ISO 3166-1 code for the resource's country of origin.              |
| Models with multiple origin countries | `originCountry`            | `origin_country`       | ISO 3166-1 codes for the resource's countries of origin.           |
| Search, discover, and list results    | `popularity`               | `popularity`           | Popularity score calculated by TMDB.                               |
| Media results                         | `voteAverage`              | `vote_average`         | Average user rating reported by TMDB.                              |
| Media results                         | `voteCount`                | `vote_count`           | Number of user ratings reported by TMDB.                           |
| Image metadata                        | `voteAverage`              | `vote_average`         | Average user rating for the image reported by TMDB.                |
| Image metadata                        | `voteCount`                | `vote_count`           | Number of user ratings for the image reported by TMDB.             |
| Mixed results                         | `mediaType`                | `media_type`           | TMDB media type discriminator, such as `movie`, `tv`, or `person`. |
| Paged responses                       | `page`                     | `page`                 | One-based index of this result page.                               |
| Paged responses                       | `totalPages`               | `total_pages`          | Total number of result pages reported by TMDB.                     |
| Paged responses                       | `totalResults`             | `total_results`        | Total number of matching results reported by TMDB.                 |
| Movie and TV results                  | `genreIds`                 | `genre_ids`            | TMDB genre identifiers assigned to the resource.                   |
| Localized media metadata              | `overview`                 | `overview`             | Localized overview when available.                                 |
| Movie-bearing models                  | `video`                    | `video`                | Whether TMDB marks the movie as having video content.              |
| Person-bearing models                 | `gender`                   | `gender`               | TMDB gender code for the person.                                   |
| Person-bearing models                 | `knownForDepartment`       | `known_for_department` | Department the person is primarily known for.                      |
| Media details                         | `runtime`                  | `runtime`              | Runtime in minutes when known.                                     |
| Episode-bearing models                | `episodeNumber`            | `episode_number`       | Episode number within its season.                                  |
| Season-bearing models                 | `seasonNumber`             | `season_number`        | Season number within its TV series.                                |
| Episode aggregates                    | `episodeCount`             | `episode_count`        | Number of associated episodes.                                     |
| Movie results                         | `releaseDate`              | `release_date`         | Movie release date in `YYYY-MM-DD` format when known.              |
| TV series results                     | `firstAirDate`             | `first_air_date`       | First air date in `YYYY-MM-DD` format when known.                  |
| Localized metadata                    | `iso6391`                  | `iso_639_1`            | ISO 639-1 language code associated with the value.                 |
| Regional metadata                     | `iso31661`                 | `iso_3166_1`           | ISO 3166-1 country code associated with the value.                 |
| Localized query types                 | `language`                 | `language`             | Language used to localize response metadata.                       |
| Paged query types                     | `page`                     | `page`                 | One-based result page; TMDB defaults to `1`.                       |
| Search and discover query types       | `includeAdult`             | `include_adult`        | Whether adult results may be included; TMDB defaults to `false`.   |
| Appended detail fields                | appended response property | endpoint-specific      | Response appended through `append_to_response` when requested.     |
| Video metadata                        | `key`                      | `key`                  | Provider-specific key used to locate the video.                    |
| Video metadata                        | `site`                     | `site`                 | Provider hosting the video, such as YouTube.                       |
| Video metadata                        | `size`                     | `size`                 | Video resolution reported by TMDB.                                 |
| Video metadata                        | `type`                     | `type`                 | TMDB video type, such as trailer or teaser.                        |
| Video metadata                        | `official`                 | `official`             | Whether TMDB marks the video as official.                          |
| Video metadata                        | `publishedAt`              | `published_at`         | Video publication timestamp.                                       |
