<div align="center">
    <img alt="TMDB JVM SDK" src="https://shieldcn.dev/header/gradient.svg?title=TMDB+JVM+SDK&subtitle=Typed+TMDB+API+client+for+Kotlin+%26+Java&mode=dark">

[![Release](https://shieldcn.dev/github/reussio/tmdb-sdk/release.svg)](https://github.com/reussio/tmdb-sdk/releases)
[![CI](https://shieldcn.dev/github/reussio/tmdb-sdk/ci.svg)](https://github.com/reussio/tmdb-sdk/actions/workflows/ci.yml)
[![License: MIT](https://shieldcn.dev/github/reussio/tmdb-sdk/license.svg)](LICENSE)
</div>

A modern Kotlin/JVM client library for [The Movie Database API](https://developer.themoviedb.org/).

The SDK provides a typed API for TMDB resources such as movies, TV series, people, search, discovery, genres, watch
providers and configuration metadata.

The SDK is implemented in Kotlin and targets JVM 17 while remaining fully consumable from both Kotlin and Java.

## Features

* Typed Kotlin/JVM client for TMDB API v3
* Kotlin-first API with Java interoperability
* JVM 17+
* Builder-based client configuration
* Domain-specific service interfaces
* Typed resource IDs, language codes and regions
* Query objects for complex request parameters
* SDK-specific exception hierarchy
* Jackson integration with Kotlin support
* Optional Spring Boot starter with autoconfiguration
* Optional Quarkus extension with CDI, health checks, metrics, Dev UI and native-image support
* Dokka-generated API documentation

## Modules

| Module                                                                                                      | Description                                        |
|-------------------------------------------------------------------------------------------------------------|----------------------------------------------------|
| [`tmdb-core`](https://central.sonatype.com/artifact/dev.reuss.tmdb/tmdb-core)                               | Core Kotlin/JVM SDK without framework dependencies |
| [`tmdb-spring-boot-starter`](https://central.sonatype.com/artifact/dev.reuss.tmdb/tmdb-spring-boot-starter) | Spring Boot auto-configuration for the SDK         |
| [`quarkus-tmdb`](https://central.sonatype.com/artifact/dev.reuss.tmdb/quarkus-tmdb)                         | Quarkus extension for the SDK                      |

## Requirements

* JVM 17 or newer
* A TMDB API read access token

## Installation

### Maven

```xml

<dependency>
    <groupId>dev.reuss.tmdb</groupId>
    <artifactId>tmdb-core</artifactId>
    <version>2.0.0</version>
</dependency>
```

### Spring Boot

```xml

<dependency>
    <groupId>dev.reuss.tmdb</groupId>
    <artifactId>tmdb-spring-boot-starter</artifactId>
    <version>2.0.0</version>
</dependency>
```

### Quarkus

```xml

<dependency>
    <groupId>dev.reuss.tmdb</groupId>
    <artifactId>quarkus-tmdb</artifactId>
    <version>2.0.0</version>
</dependency>
```

## Kotlin Usage

Create a `TmdbClient` through the builder:

```kotlin
import dev.reuss.tmdb.TmdbClient

val tmdb = TmdbClient.builder()
    .accessToken("your-access-token")
    .build()
```

The client exposes domain-specific services:

```kotlin
val configuration = tmdb.configuration().apiConfiguration()
val movie = tmdb.movies().details(MovieId.of(550))
val results = tmdb.search().movies(MovieSearchQuery.of("Fight Club"))
```

## Java Usage

The SDK remains directly usable from Java:

```java
import dev.reuss.tmdb.TmdbClient;

TmdbClient tmdb = TmdbClient.builder()
    .accessToken("your-access-token")
    .build();
```

Domain services can be used in the same way:

```java
ApiConfiguration configuration = tmdb.configuration().apiConfiguration();
MovieDetails movie = tmdb.movies().details(MovieId.of(550));
SearchMovieResponse results = tmdb.search().movies(MovieSearchQuery.of("Fight Club"));
```

## Client Configuration

### Kotlin

```kotlin
import dev.reuss.tmdb.TmdbClient
import dev.reuss.tmdb.value.language.Language
import dev.reuss.tmdb.value.region.Region
import java.time.Duration

val tmdb = TmdbClient.builder()
    .accessToken("your-access-token")
    .defaultLanguage(Language.of("de-DE"))
    .defaultRegion(Region.of("DE"))
    .connectTimeout(Duration.ofSeconds(5))
    .requestTimeout(Duration.ofSeconds(10))
    .build()
```

### Java

```java
import dev.reuss.tmdb.TmdbClient;
import dev.reuss.tmdb.value.language.Language;
import dev.reuss.tmdb.value.region.Region;

import java.time.Duration;

TmdbClient tmdb = TmdbClient.builder()
    .accessToken("your-access-token")
    .defaultLanguage(Language.of("de-DE"))
    .defaultRegion(Region.of("DE"))
    .connectTimeout(Duration.ofSeconds(5))
    .requestTimeout(Duration.ofSeconds(10))
    .build();
```

Default values:

| Option           | Default                        |
|------------------|--------------------------------|
| Base URL         | `https://api.themoviedb.org/3` |
| Default language | `en-US`                        |
| Default region   | none                           |
| Connect timeout  | `5s`                           |
| Request timeout  | `10s`                          |

## Spring Boot Starter

The Spring Boot starter automatically configures a `TmdbClient` bean and exposes the SDK domain services as Spring
beans.

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

#### Kotlin

```kotlin
import dev.reuss.tmdb.TmdbClient
import org.springframework.stereotype.Service

@Service
class MovieLookupService(
    private val tmdbClient: TmdbClient
)
```

#### Java

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

#### Kotlin

```kotlin
import dev.reuss.tmdb.domain.movie.MovieService
import org.springframework.stereotype.Service

@Service
class MovieLookupService(
    private val movieService: MovieService
)
```

#### Java

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

### Actuator Health

If Spring Boot Actuator is on the classpath, the starter registers a `tmdb` health indicator automatically.

The health indicator reports whether the `TmdbClient` is available. It does not perform an external request to the TMDB
API.

```properties
management.health.tmdb.enabled=true
```

### Actuator Metrics

If Micrometer is available, the starter records TMDB client request metrics automatically.

With Spring Boot Actuator, metrics are available through the regular actuator endpoints.

```properties
management.endpoints.web.exposure.include=health,metrics,prometheus
```

For Prometheus output, add `micrometer-registry-prometheus` to your application and expose `/actuator/prometheus`.

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

### Configuration

```properties
tmdb.access-token=${TMDB_ACCESS_TOKEN}
tmdb.default-language=de-DE
tmdb.default-region=DE
tmdb.connect-timeout=5s
tmdb.request-timeout=10s
```

### Inject a Domain Service

#### Kotlin

```kotlin
import dev.reuss.tmdb.domain.movie.MovieService
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class MovieLookupService(
    private val movieService: MovieService
)
```

#### Java

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
health checks and TMDB client metrics automatically.

In development mode, the TMDB extension is also available in the Quarkus Dev UI.

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

## API Documentation

The API documentation for `tmdb-core` is generated with [Dokka](https://kotlinlang.org/docs/dokka-introduction.html) and
published at:

```text
https://reussio.github.io/tmdb-sdk/
```

To generate the API documentation locally:

```sh
mvn -B -ntp -pl tmdb-core dokka:dokka
open tmdb-core/target/dokka/index.html
```

## Migrating from 1.x to 2.0

Version 2.0 migrates the SDK implementation and public JVM API from Java sources to Kotlin.

The project is now positioned as a Kotlin/JVM SDK rather than a Java-only SDK.

The Maven coordinates remain unchanged:

```text
dev.reuss.tmdb:tmdb-core
dev.reuss.tmdb:tmdb-spring-boot-starter
dev.reuss.tmdb:quarkus-tmdb
```

The SDK continues to target JVM 17 and remains usable from Java.

Notable migration changes include:

* SDK implementation migrated from Java to Kotlin
* Models migrated to Kotlin data classes and JVM records where appropriate
* Kotlin consumers can use idiomatic property access
* Java interoperability is preserved for the public API where applicable
* Language and region values use validated factory methods
* Jackson uses the Kotlin module for Kotlin model deserialization
* Spring Boot integration migrated to Kotlin
* Quarkus runtime and deployment modules migrated to Kotlin
* API documentation migrated from Javadoc to Dokka
* Formatting is enforced through Spotless and ktlint

Because 2.0 is a major release, applications upgrading from 1.x should compile and run their existing integration
against
the new version and review any public API changes surfaced by the compiler.

## License

This project is licensed under the MIT License.
