# TMDB Java SDK

[![Maven Central Core](https://img.shields.io/maven-central/v/dev.reuss.tmdb/tmdb-core.svg?label=tmdb-core)](https://central.sonatype.com/artifact/dev.reuss.tmdb/tmdb-core)
[![Maven Central Spring Boot Starter](https://img.shields.io/maven-central/v/dev.reuss.tmdb/tmdb-spring-boot-starter.svg?label=spring-boot-starter)](https://central.sonatype.com/artifact/dev.reuss.tmdb/tmdb-spring-boot-starter)
[![Maven Central Quarkus Extension](https://img.shields.io/maven-central/v/dev.reuss.tmdb/quarkus-tmdb.svg?label=quarkus-tmdb)](https://central.sonatype.com/artifact/dev.reuss.tmdb/quarkus-tmdb)
[![Javadocs](https://img.shields.io/badge/Javadocs-online-blue.svg)](https://reussio.github.io/tmdb-sdk/)
[![Publish](https://github.com/reussio/tmdb-sdk/actions/workflows/publish.yml/badge.svg)](https://github.com/reussio/tmdb-sdk/actions/workflows/publish.yml)
[![Java 17](https://img.shields.io/badge/Java-17%2B-orange.svg)](https://openjdk.org/projects/jdk/17/)
[![License: MIT](https://img.shields.io/badge/License-MIT-green.svg)](LICENSE)

A modern Java client library for [The Movie Database API](https://developer.themoviedb.org/).

The SDK provides a typed Java API for TMDB resources such as movies, TV series, people, search, discovery, genres, watch
providers and configuration metadata.

## Features

* Typed Java client for TMDB API v3
* Java 17+
* Builder-based client configuration
* Domain-specific service interfaces
* Typed IDs, language codes and regions
* Query objects for complex request parameters
* SDK-specific exception hierarchy
* Optional Spring Boot starter with autoconfiguration
* Optional Quarkus extension with CDI, health checks, metrics, Dev UI and native-image support

## Modules

| Module                                                                                                      | Description                                  |
|-------------------------------------------------------------------------------------------------------------|----------------------------------------------|
| [`tmdb-core`](https://central.sonatype.com/artifact/dev.reuss.tmdb/tmdb-core)                               | Core Java SDK without framework dependencies |
| [`tmdb-spring-boot-starter`](https://central.sonatype.com/artifact/dev.reuss.tmdb/tmdb-spring-boot-starter) | Spring Boot auto-configuration for the SDK   |
| [`quarkus-tmdb`](https://central.sonatype.com/artifact/dev.reuss.tmdb/quarkus-tmdb)                         | Quarkus extension for the SDK                |

## Requirements

* Java 17 or newer
* A TMDB API read access token

## Installation

### Maven

```xml
<dependency>
    <groupId>dev.reuss.tmdb</groupId>
    <artifactId>tmdb-core</artifactId>
    <version>0.2.0</version>
</dependency>
```

### Spring Boot

```xml
<dependency>
    <groupId>dev.reuss.tmdb</groupId>
    <artifactId>tmdb-spring-boot-starter</artifactId>
    <version>0.2.0</version>
</dependency>
```

### Quarkus

```xml
<dependency>
    <groupId>dev.reuss.tmdb</groupId>
    <artifactId>quarkus-tmdb</artifactId>
    <version>0.2.0</version>
</dependency>
```

## Plain Java Usage

Create a `TmdbClient` through the builder:

```java
import dev.reuss.tmdb.TmdbClient;

TmdbClient tmdb = TmdbClient.builder()
        .accessToken("your-access-token")
        .build();
```

The client exposes domain services:

```java
ApiConfiguration configuration = tmdb.configuration().apiConfiguration();
MovieDetails movie = tmdb.movies().details(MovieId.of(550));
SearchMovieResponse results = tmdb.search().movies(MovieSearchQuery.of("Fight Club"));
```

## Client Configuration

```java
import dev.reuss.tmdb.TmdbClient;
import dev.reuss.tmdb.value.language.Language;
import dev.reuss.tmdb.value.region.Region;

import java.time.Duration;

TmdbClient tmdb = TmdbClient.builder()
        .accessToken("your-access-token")
        .defaultLanguage(Language.of("de-DE"))
        .defaultRegion(new Region("DE"))
        .connectTimeout(Duration.ofSeconds(5))
        .requestTimeout(Duration.ofSeconds(10))
        .build();
```

Default values:

| Option           | Default                        |
|------------------|--------------------------------|
| Base URL         | `https://api.themoviedb.org/3` |
| Default language | `en-US`                        |
| Connect timeout  | `5s`                           |
| Request timeout  | `10s`                          |

## Spring Boot Starter

The Spring Boot starter automatically configures a `TmdbClient` bean.

### Configuration

```yaml
tmdb:
  access-token: ${TMDB_ACCESS_TOKEN}
  default-language: de-DE
  default-region: DE
  connect-timeout: 5s
  request-timeout: 10s
```

### Inject the Client

```java
import dev.reuss.tmdb.TmdbClient;
import org.springframework.stereotype.Service;

@Service
class MovieLookupService {

    private final TmdbClient tmdbClient;

    MovieLookupService(TmdbClient tmdbClient) {
        this.tmdbClient = tmdbClient;
    }
}
```

### Inject Domain Services Directly

The starter also exposes the SDK domain services as Spring beans.

```java
import dev.reuss.tmdb.domain.movie.MovieService;
import org.springframework.stereotype.Service;

@Service
class MovieLookupService {

    private final MovieService movieService;

    MovieLookupService(MovieService movieService) {
        this.movieService = movieService;
    }
}
```

### Spring Boot Properties

| Property                | Default                        | Description                                          |
|-------------------------|--------------------------------|------------------------------------------------------|
| `tmdb.access-token`     | required                       | TMDB API read access token                           |
| `tmdb.base-url`         | `https://api.themoviedb.org/3` | TMDB API base URL                                    |
| `tmdb.default-language` | `en-US`                        | Default language tag, for example `en-US` or `de-DE` |
| `tmdb.default-region`   | none                           | Default region code, for example `US` or `DE`        |
| `tmdb.connect-timeout`  | `5s`                           | HTTP connection timeout                              |
| `tmdb.request-timeout`  | `10s`                          | HTTP request timeout                                 |

## Quarkus Extension

The Quarkus extension exposes `TmdbClient` and all SDK domain services as CDI beans.

```properties
tmdb.access-token=${TMDB_ACCESS_TOKEN}
tmdb.default-language=de-DE
tmdb.default-region=DE
tmdb.connect-timeout=5s
tmdb.request-timeout=10s
```

```java
import dev.reuss.tmdb.domain.movie.MovieService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
class MovieLookupService {

    @Inject
    MovieService movieService;
}
```

If `quarkus-smallrye-health` or a Quarkus metrics extension such as Micrometer is present, the extension registers
health checks and TMDB client metrics automatically. In dev mode, the TMDB card is available in the Quarkus Dev UI.

## Error Handling

The SDK maps transport, mapping and TMDB API errors to SDK-specific exceptions.

All SDK exceptions extend `TmdbException`.

Common exception types include:

* `TmdbClientException`
* `TmdbApiException`
* `TmdbUnauthorizedException`
* `TmdbNotFoundException`
* `TmdbRateLimitException`
* `TmdbServerException`
* `TmdbMappingException`

## Javadoc

The generated Javadoc is available at:

```text
https://reussio.github.io/tmdb-sdk/
```

To generate the Javadoc locally:

```sh
mvn -pl tmdb-core javadoc:javadoc
open tmdb-core/target/reports/apidocs/index.html
```

## License

This project is licensed under the MIT License.
