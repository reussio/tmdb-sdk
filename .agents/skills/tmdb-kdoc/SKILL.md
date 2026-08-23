---
name: tmdb-kdoc
description: Audit, add, rewrite, and standardize Kotlin KDoc documentation for the TMDB JVM SDK. Use when improving KDoc, documenting public APIs, reviewing Dokka output, documenting TMDB endpoints or models, migrating JavaDoc to KDoc, or standardizing repeated TMDB field descriptions. For every implemented TMDB endpoint, consult the corresponding official TMDB Markdown reference before documenting it. Keep recurring field descriptions consistent across the entire SDK.
---

# TMDB KDoc Documentation

Improve and standardize the KDoc documentation of the TMDB JVM SDK.

This skill is specifically tailored to this repository and its public Kotlin/JVM API.

The goal is NOT maximum documentation coverage.

The goal is high-quality API documentation that:

- accurately reflects the official TMDB API
- explains the SDK's public contracts
- documents important semantics and constraints
- remains useful to both Kotlin and Java consumers
- renders cleanly with Dokka
- uses consistent terminology across the entire SDK
- avoids redundant or obvious documentation
- does not invent behavior
- does not merely paraphrase Kotlin declarations

Documentation changes must not modify production behavior.

# Core Principle

Document the API from the perspective of an SDK consumer.

KDoc should primarily explain information that cannot be understood immediately from the declaration itself.

Prefer documenting:

- semantic meaning
- TMDB-specific behavior
- endpoint behavior
- constraints
- validation rules
- normalization
- defaults
- special values
- optional behavior
- error behavior
- relationships between API types
- relevant side effects
- important usage information
- interoperability considerations
- distinctions between similar overloads or endpoints

Avoid documentation that merely translates code into prose.

Bad:

```kotlin
/**
 * Returns the movie ID.
 */
val movieId: MovieId
```

Better:

```kotlin
/**
 * Identifies the movie requested from TMDB.
 */
val movieId: MovieId
```

Even better: if the declaration is already completely obvious and adds no value, omit the KDoc entirely.

# Scope

When invoked, inspect the requested:

- file
- package
- module
- diff
- feature
- endpoint
- or repository

If no narrower scope is provided, inspect the relevant production Kotlin sources under:

```text
src/main/kotlin/**
```

Relevant modules include:

```text
tmdb-core
tmdb-spring-boot-starter
quarkus-tmdb/runtime
quarkus-tmdb/deployment
```

Do not modify tests unless necessary to understand intended behavior or explicitly requested.

Do not modify production behavior.

This is a documentation task.

If a discrepancy between documentation and implementation reveals a possible production bug, report it instead of silently fixing it.

# Official TMDB Documentation

The official TMDB developer documentation is the primary source of truth for TMDB API semantics.

Documentation root:

```text
https://developer.themoviedb.org/docs/getting-started
```

Individual TMDB API reference pages are also available as Markdown.

Example:

```text
https://developer.themoviedb.org/reference/company-details.md
```

For EVERY implemented TMDB endpoint encountered in the requested scope, reading the corresponding official TMDB endpoint documentation is mandatory.

Do not document endpoint semantics purely from:

- the SDK method name
- existing KDoc
- tests
- models
- request builders
- assumptions
- memory
- similar endpoints

Always consult the official TMDB reference first.

# Mandatory Endpoint Documentation Audit

For every implemented TMDB endpoint in scope:

1. Identify the corresponding official TMDB API reference.
2. Open the official `.md` version of that reference.
3. Read the complete relevant endpoint documentation.
4. Inspect its summary.
5. Inspect its description.
6. Inspect all path parameters.
7. Inspect all query parameters.
8. Inspect parameter constraints and defaults.
9. Inspect the response description.
10. Inspect response fields when they are relevant to SDK documentation.
11. Inspect endpoint-specific warnings or notes.
12. Inspect examples when they clarify semantics.
13. Compare the official TMDB contract with the SDK implementation.
14. Improve the SDK KDoc based on that comparison.

Example mapping:

```text
SDK:
CompanyService.details(...)

TMDB:
https://developer.themoviedb.org/reference/company-details.md
```

Do not consider an endpoint audited until its official TMDB reference has been read.

If the correct official reference cannot be identified confidently:

- do not guess
- do not fabricate documentation
- report the unresolved endpoint in the final summary

If network access to the official documentation is unavailable:

- do not invent missing information
- document only what can be established from reliable repository sources
- explicitly report which endpoint documentation could not be verified

# Endpoint Coverage

When auditing a service or module, create an internal endpoint checklist.

For each public SDK endpoint method, track:

```text
SDK method
TMDB endpoint
Official Markdown reference
KDoc status
Issues found
```

The checklist does not need to be committed unless explicitly requested.

Its purpose is to prevent endpoint documentation from being accidentally skipped.

Do not stop after documenting only the first few obvious service methods.

# Documentation Source Priority

When determining semantics, use this priority:

1. Official TMDB endpoint reference
2. Official TMDB guides and documentation
3. SDK implementation
4. SDK tests
5. Existing KDoc

Existing KDoc is never authoritative when it contradicts current official TMDB documentation.

Tests may help identify intended SDK behavior, but they do not override the official TMDB contract.

If the SDK intentionally transforms, validates, normalizes, or abstracts TMDB behavior, document the SDK-facing contract while keeping the underlying TMDB concept accurate.

# Never Invent Behavior

Every factual documentation statement must be supported by:

- official TMDB documentation
- actual SDK implementation
- or an established SDK contract

Never invent:

- validation rules
- defaults
- supported values
- format requirements
- ordering guarantees
- nullability semantics beyond the type system
- performance characteristics
- caching behavior
- error behavior
- TMDB semantics

If something cannot be established confidently, omit it or report the ambiguity.

# Existing Documentation Is Not Sacred

Existing KDoc may be:

- rewritten
- shortened
- expanded
- merged
- standardized
- corrected
- removed entirely

Do not preserve weak documentation merely because it already exists.

Actively improve:

- outdated Java terminology
- JavaDoc syntax in Kotlin
- descriptions copied from old Java code
- stale examples
- incorrect assumptions
- inconsistent terminology
- duplicate descriptions
- verbose filler
- comments that simply restate symbol names
- broken KDoc links

Prefer concise and accurate documentation over verbose documentation.

# Documentation Audit Classification

Before editing declarations, classify them internally as:

A. KDoc required or highly useful
B. Existing KDoc is already sufficient
C. Existing KDoc should be improved
D. KDoc provides little or no value
E. Existing KDoc is misleading and should be removed or rewritten

Do not blindly add documentation to every declaration.

# Public API Priority

Prioritize documentation for:

- public classes
- public interfaces
- public objects
- public service APIs
- public functions
- public factory methods
- public builders
- public configuration APIs
- public query APIs
- public value objects
- public exceptions
- public extension functions
- public annotations intended for consumers
- public properties with non-obvious semantics

Internal APIs should only receive KDoc when their behavior is sufficiently complex that documentation materially helps maintainers.

Do not document private helpers mechanically.

# Trivial Declarations

Usually do NOT add KDoc to:

- obvious private helpers
- trivial getters
- obvious constants
- simple implementation details
- generated Kotlin behavior
- framework boilerplate
- trivial overrides
- straightforward delegation
- basic data holders whose names and types fully explain them

Do not document generated:

- `copy`
- `componentN`
- `equals`
- `hashCode`
- `toString`

unless a custom implementation introduces meaningful behavior.

# Models

Do NOT mechanically add documentation to every TMDB model property.

Many models exist primarily to represent TMDB JSON responses.

For such types:

- concise class-level KDoc may be useful
- obvious properties may remain undocumented
- non-obvious TMDB concepts should be documented
- repeated fields must use canonical descriptions
- fields with special semantics should be documented

Example of unnecessary documentation:

```kotlin
/**
 * The name.
 */
val name: String
```

This adds no value.

Example where documentation may be useful:

```kotlin
/**
 * TMDB image path for the company logo.
 */
val logoPath: String?
```

However, recurring fields must follow the canonical field rules below.

# Canonical Field Documentation

Repeated TMDB concepts MUST use consistent wording across the entire SDK.

Do not independently invent a new description each time the same semantic field appears.

Examples of recurring fields include:

```text
logoPath
posterPath
backdropPath
profilePath
stillPath
originalLanguage
originCountry
adult
popularity
voteAverage
voteCount
mediaType
language
region
page
totalPages
totalResults
```

This list is not exhaustive.

Whenever a recurring property is encountered:

1. Search the entire repository for all occurrences of the property.
2. Determine whether those occurrences represent the same semantic TMDB concept.
3. Inspect existing KDoc descriptions.
4. Consult the official TMDB documentation.
5. Select or create one canonical description.
6. Use that exact description everywhere the semantics are identical.

Do not intentionally vary wording for stylistic diversity.

Consistency is more important than prose variation.

Bad:

```text
Path to the company logo.
```

in one class,

```text
Relative path of the logo image.
```

in another,

and:

```text
Logo path returned by TMDB.
```

in another.

If all three represent the same concept, use one canonical description everywhere.

# Canonical Field Dictionary

Maintain repository-specific canonical field descriptions in:

```text
.agents/skills/tmdb-kdoc/references/canonical-fields.md
```

Read this file before documenting models or repeated TMDB properties.

If the file does not yet exist and the requested work involves recurring fields, create it.

When a field is already present in the dictionary:

- use its description verbatim
- do not paraphrase it
- do not shorten it
- do not embellish it
- do not create local wording variants

Example structure:

```markdown
# Canonical TMDB Field Documentation

| Kotlin property | JSON field | Canonical description |
|---|---|---|
| `logoPath` | `logo_path` | TMDB image path for the logo. |
| `posterPath` | `poster_path` | TMDB image path for the poster. |
| `backdropPath` | `backdrop_path` | TMDB image path for the backdrop. |
| `profilePath` | `profile_path` | TMDB image path for the profile image. |
| `voteAverage` | `vote_average` | Average user rating reported by TMDB. |
| `voteCount` | `vote_count` | Number of user ratings reported by TMDB. |
```

The descriptions above are structural examples only.

Before adopting a canonical description, verify that it accurately represents the official TMDB semantics and the SDK type.

# Adding Canonical Fields

When a recurring field is not yet in the canonical dictionary:

1. Search all repository occurrences.
2. Compare their JSON field names.
3. Determine whether they have identical semantics.
4. Consult relevant official TMDB references.
5. Consult official TMDB guides if necessary.
6. Create one concise canonical description.
7. Add it to `canonical-fields.md`.
8. Apply it consistently across all matching declarations in the requested scope.

When practical and clearly safe, also normalize matching descriptions outside the immediate file so that the repository does not retain inconsistent definitions.

Do not force one description onto fields that merely share a Kotlin name but have different semantics.

If semantics differ, use scoped entries.

Example:

```text
Company.logoPath
Network.logoPath
```

only share one canonical description if the underlying TMDB concept is actually equivalent.

# Canonical Terminology

Use the same terminology for the same concepts throughout the SDK.

Prefer established terminology:

- TMDB
- SDK
- client
- service
- endpoint
- resource
- query
- movie
- TV series
- season
- episode
- person
- company
- network
- collection
- language
- region
- image path
- result page

Do not alternate unnecessarily between terms such as:

```text
TV show
TV series
television show
series
```

when the project has already standardized on one term.

# Image Fields

Image-related fields require special consistency.

Examples:

```text
logoPath
posterPath
backdropPath
profilePath
stillPath
```

Do not repeatedly explain the complete TMDB image URL construction mechanism on every model property.

Property documentation should remain concise and describe what the path represents.

Detailed explanation of:

- image base URL
- available image sizes
- full URL construction
- secure base URL

belongs in the appropriate image/configuration abstraction or higher-level documentation.

If an image property has context-specific semantics that materially differ, document that difference.

# Service Documentation

For domain services:

- document what TMDB resource area the service represents
- document endpoint semantics that are not obvious from method names
- document meaningful parameters
- document overload differences
- document relevant defaults
- link related query or value types
- document TMDB-specific concepts when necessary

Do not expose internal HTTP implementation details unnecessarily.

Avoid documenting internal route construction unless the actual endpoint path is useful to consumers.

Example:

```kotlin
/**
 * Provides access to movie-related TMDB endpoints.
 */
interface MovieService
```

Endpoint method documentation should be based on the official endpoint reference.

# Endpoint Methods

For every endpoint method:

- identify the matching official TMDB reference
- understand the operation before editing KDoc
- describe the operation from the caller's perspective
- document meaningful path parameters
- document meaningful query objects
- document important TMDB-specific behavior
- document meaningful return semantics
- document endpoint-specific errors or restrictions when relevant

Avoid vague wording such as:

```text
Gets movie details.
```

Prefer a meaningful description based on the actual endpoint contract.

Do not copy large sections of TMDB documentation verbatim.

Paraphrase accurately and concisely.

# Overloads

When several overloads expose the same endpoint:

- avoid duplicating large KDoc blocks
- put the primary semantic documentation on the most representative API
- keep convenience overload documentation concise
- explain only what differs
- use KDoc links where useful

Do not let overload documentation drift into different descriptions of the same endpoint.

# Query Types

For query types, document:

- which endpoint or operation they configure
- meaningful defaults
- constraints
- parameter interactions
- special TMDB semantics

Do not document every obvious property.

Example:

```kotlin
/**
 * Parameters used when searching TMDB for movies.
 */
data class MovieSearchQuery(...)
```

Individual properties deserve KDoc when they involve:

- constraints
- defaults
- non-obvious semantics
- TMDB-specific behavior
- meaningful interaction with other parameters

# Value Objects

Value objects deserve careful documentation because they often enforce domain invariants.

Examples include:

- resource IDs
- language codes
- regions
- season numbers
- episode numbers
- media types

Document:

- what the value represents
- accepted values
- normalization
- validation
- special cases
- relevant standards

Example:

```kotlin
/**
 * Identifies a TMDB region using an ISO 3166-1 country code.
 */
```

Only state standards when they are actually supported by the implementation and TMDB contract.

# Factory Methods

Factories such as:

```text
of(...)
from(...)
parse(...)
```

deserve special attention.

Document when relevant:

- accepted input
- normalization
- validation
- special values
- result semantics
- invalid-input behavior

Do not expose implementation details such as regex structure unless that regex itself forms part of the public contract.

Example:

```kotlin
/**
 * Creates a validated TMDB region.
 *
 * @param value Region code accepted by TMDB.
 * @return The normalized region.
 * @throws IllegalArgumentException if [value] is not a valid region.
 */
fun of(value: String): Region
```

Descriptions must match actual behavior.

# Builders

For builders, document:

- required configuration
- defaults
- validation performed by `build()`
- interactions between settings
- externally observable behavior

Do not repeat identical documentation:

- on the builder class
- on every setter
- on backing properties
- on the resulting client

Put information at the most useful API level.

# Configuration

Configuration documentation should accurately describe:

- defaults
- optional values
- required values
- parsing
- normalization
- framework behavior
- fallback behavior

Relevant areas may include:

- base URL
- access token
- language
- region
- connect timeout
- request timeout
- metrics
- health integration

Do not guess framework defaults.

Inspect the actual implementation.

# Exceptions

Document meaningful exceptions that callers can reasonably encounter or react to.

Use:

```text
@throws
```

when the exception behavior is part of the public contract.

Do not mechanically repeat the entire SDK exception hierarchy on every service method.

Common error behavior should be documented at the appropriate abstraction level.

Endpoint-specific error behavior may be documented on the endpoint.

# Parameters

Use `@param` when the parameter requires meaningful explanation.

Good:

```text
@param page One-based result page.
```

Bad:

```text
@param page The page.
```

Document:

- constraints
- ranges
- special values
- defaults
- formatting
- normalization
- parameter interactions

Do not add `@param` merely because a parameter exists.

# Return Values

Use `@return` only when it adds information beyond the return type.

Bad:

```text
@return The movie details.
```

if that is already obvious from the function and return type.

Better:

```text
@return Details returned by TMDB for the requested movie.
```

when this adds useful semantic context.

For factory methods, describe the semantic result.

Do not place complete executable examples inside `@return`.

# Nullability

Kotlin already exposes nullability.

Do not write redundant documentation such as:

```text
@return The region or null.
```

Instead document the condition when it matters:

```text
@return The region component, or `null` when the language tag does not specify one.
```

Similarly, do not repeatedly state:

```text
May be null.
```

when `String?` already communicates that fact.

# Collections

Do not document obvious collection types.

Document relevant guarantees only when supported, such as:

- ordering
- uniqueness
- empty instead of absent
- normalization
- filtering
- TMDB-defined ordering

Do not invent immutability or ordering guarantees.

# Defaults

Document defaults when they materially affect caller behavior.

Examples:

- default language
- optional region
- request timeout
- connect timeout
- pagination
- endpoint-specific defaults

If a default is already obvious from the declaration, avoid redundant prose unless it is an important part of the public contract.

# KDoc Style

Use idiomatic Kotlin KDoc.

Use Kotlin symbol links:

```text
[TmdbClient]
[MovieService]
[MovieId]
[MovieId.of]
```

Do NOT use JavaDoc links:

```text
{@link TmdbClient}
```

Use Markdown supported by KDoc.

Use backticks for literal values:

```text
`en-US`
`DE`
`0`
`true`
```

Use code blocks only when an actual usage example materially improves understanding.

Do not add examples everywhere.

# KDoc Links

Use links to connect related API concepts when useful.

Example:

```kotlin
/**
 * Default language used by requests that do not provide their own language.
 *
 * Requests can override this value through endpoint-specific query options.
 */
```

or:

```kotlin
/**
 * Creates a movie identifier accepted by [MovieService].
 */
```

Only link symbols that actually exist.

Do not create broken links.

# `@see`

Prefer natural inline links over large `@see` sections.

Use `@see` only when the relationship is useful but awkward to express naturally in prose.

# Inheritance and Overrides

Do not repeat inherited documentation when the inherited contract applies unchanged.

Add KDoc to an override only when:

- behavior differs
- additional constraints exist
- implementation-specific semantics matter
- framework integration makes the behavior non-obvious

Otherwise rely on inherited documentation.

# Java Interoperability

This is a Kotlin/JVM SDK and may be consumed from both Kotlin and Java.

Public documentation should therefore describe API behavior rather than relying unnecessarily on Kotlin-only syntax or concepts.

Do not add JavaDoc syntax to Kotlin sources.

When Java interoperability introduces meaningful API behavior, document it where useful.

Examples may include intentional:

- static factory exposure
- JVM records
- Java-friendly overloads
- Java Optional at framework boundaries

Do not document implementation annotations merely because they exist.

# Spring Boot

For Spring Boot integration, prioritize documentation of:

- auto-configuration behavior
- configuration properties
- defaults
- conditional beans
- health behavior
- metrics behavior
- bean exposure
- override behavior

Do not add KDoc to trivial Spring plumbing without semantic value.

Where behavior corresponds directly to SDK core configuration, reuse terminology consistently.

# Quarkus

For Quarkus integration, prioritize documentation of:

- extension behavior
- configuration
- CDI exposure
- health integration
- metrics integration
- Dev UI behavior
- native-image support
- conditional capabilities

Do not document Quarkus build internals unless useful to extension maintainers.

Public-facing runtime APIs deserve higher priority than trivial build-step plumbing.

# Documentation Smells

Actively identify and improve or remove documentation such as:

```text
Gets the ...
Sets the ...
Returns the ...
Represents the ...
The name.
The ID.
The value.
```

when these phrases merely repeat the declaration.

Also remove or improve:

- duplicate descriptions
- vague generic descriptions
- stale Java terminology
- obsolete JavaDoc
- outdated examples
- inconsistent TMDB terminology
- implementation details
- broken links
- repeated type information
- comments explaining obvious syntax
- excessive `@param`
- excessive `@return`
- documentation copied blindly between unrelated models
- stylistic variations of canonical field descriptions

# Do Not Copy TMDB Documentation Verbatim

Official TMDB documentation is the semantic authority, but SDK KDoc should remain concise and tailored to SDK consumers.

Do not copy entire endpoint descriptions or large passages verbatim.

Instead:

1. understand the official semantics
2. identify what matters to SDK consumers
3. express it concisely in original wording
4. preserve important TMDB terminology

# Repository Search Is Mandatory

Before documenting a repeated concept, search the repository.

For example, before editing:

```text
logoPath
```

search all occurrences of:

```text
logoPath
logo_path
```

Review existing descriptions before deciding on the canonical wording.

The same applies to other recurring concepts.

This prevents semantic and terminology drift.

# Cross-Repository Consistency

When improving one file reveals inconsistent KDoc elsewhere for the exact same concept, prefer making the descriptions consistent across the repository when doing so is safe and within reasonable scope.

Examples:

```text
logoPath
posterPath
voteAverage
voteCount
originalLanguage
page
totalPages
```

Do not leave known conflicting canonical descriptions solely because they occur in another package.

However, do not turn a narrowly scoped documentation request into an unrelated rewrite of the entire repository.

Use judgment.

# Documentation vs. Implementation Conflicts

If official TMDB documentation and the SDK implementation appear to disagree:

1. verify the TMDB reference
2. inspect the SDK implementation
3. inspect relevant tests
4. determine whether the SDK intentionally abstracts the difference

Do NOT silently alter documentation to hide the discrepancy.

Do NOT silently modify production behavior.

Report the mismatch.

Examples:

```text
SDK accepts a value TMDB documentation describes as invalid.
```

or:

```text
TMDB documents a query parameter that the SDK does not expose.
```

These findings should appear in the final report.

# Potential Missing SDK Features

While reading every official endpoint document, you may notice TMDB parameters or behavior not represented in the SDK.

Do not automatically implement them.

Record relevant discrepancies in the final report.

Examples:

- missing query parameter
- incorrect default
- missing endpoint overload
- unsupported TMDB option
- mismatched response type
- stale enum/value object
- undocumented endpoint behavior

The documentation task should not expand into API development without explicit permission.

# Dokka

The public API documentation is rendered using Dokka.

All KDoc must render cleanly with Dokka.

For `tmdb-core`, validate documentation with:

```bash
mvn -B -ntp -pl tmdb-core dokka:dokka
```

Expected output:

```text
tmdb-core/target/dokka
```

When other project validation is appropriate, use the repository's normal Maven build.

Do not introduce a new documentation generator.

# Formatting

Respect the repository formatting configuration.

Use the existing:

- Spotless
- ktlint
- `.editorconfig`

If formatting is required:

```bash
mvn spotless:apply
```

Do not perform unrelated formatting changes.

# Workflow

When invoked, follow this process.

## Phase 1: Inventory

Identify all relevant production Kotlin files in the requested scope.

Identify:

- services
- endpoint methods
- models
- query types
- value objects
- builders
- configuration APIs
- exceptions
- framework integrations

Inspect existing KDoc.

## Phase 2: Endpoint Mapping

For every SDK endpoint in scope:

1. identify its TMDB endpoint
2. locate its official TMDB Markdown reference
3. read the reference
4. compare it with the SDK implementation
5. record relevant semantics and discrepancies

Do this before rewriting endpoint KDoc.

## Phase 3: Canonical Field Audit

Search recurring properties.

Load:

```text
.agents/skills/tmdb-kdoc/references/canonical-fields.md
```

If appropriate and missing, create it.

Identify:

- existing canonical fields
- missing recurring fields
- inconsistent descriptions
- semantically different fields with the same name

Update the dictionary when necessary.

## Phase 4: Documentation Audit

Classify declarations as:

```text
A - documentation useful or required
B - existing documentation sufficient
C - existing documentation should be improved
D - documentation unnecessary
E - existing documentation misleading or redundant
```

Do not mechanically document category D.

## Phase 5: Edit

Improve KDoc.

Prioritize:

1. public service APIs
2. endpoint methods
3. public value objects
4. public query APIs
5. configuration
6. public exceptions
7. non-obvious model fields
8. meaningful internal APIs

Apply canonical field descriptions consistently.

## Phase 6: Cross-Check

After editing:

- search recurring fields again
- verify canonical descriptions
- verify terminology
- verify KDoc links
- verify constraints against implementation
- verify endpoint descriptions against official references
- remove documentation filler
- ensure no behavior was invented

## Phase 7: Validate

Run relevant formatting and documentation generation.

For core API documentation:

```bash
mvn -B -ntp -pl tmdb-core dokka:dokka
```

When appropriate, also run:

```bash
mvn -B -ntp clean verify
```

Do not claim validation succeeded unless the command actually completed successfully.

# Full-Scope Audit Rule

If the user requests an entire module or repository audit, do not stop after the first few files.

Continue until every relevant production file in that scope has been considered.

For every undocumented public declaration, internally answer:

```text
Why does this declaration not need KDoc?
```

Valid answers include:

- obvious model property
- trivial implementation detail
- inherited contract already documents it
- declaration is self-explanatory
- framework boilerplate
- no additional semantic information exists

Invalid answer:

```text
It was overlooked.
```

# Final Review

Before completing the task, verify:

- every implemented endpoint in scope was checked against official TMDB documentation
- no endpoint documentation was invented from assumptions
- KDoc describes contracts instead of syntax
- relevant TMDB constraints are documented
- relevant defaults are documented
- recurring fields use canonical descriptions
- canonical terminology is consistent
- models were not mechanically over-documented
- public APIs have useful documentation
- trivial APIs were not filled with noise
- KDoc links point to real symbols
- JavaDoc syntax was not introduced
- documentation renders appropriately with Dokka
- production behavior was not changed
- detected TMDB/SDK discrepancies were not silently hidden

# Final Report

Provide a concise report containing:

## Scope

What was audited.

Example:

```text
- CompanyService
- Company models
- company-related value types
```

## Official TMDB References

List the endpoint references that were consulted.

Example:

```text
CompanyService.details
→ https://developer.themoviedb.org/reference/company-details.md
```

Do this concisely.

## Documentation Changes

Summarize:

- important KDoc added
- important KDoc rewritten
- redundant KDoc removed
- canonical descriptions standardized

## Canonical Fields

List canonical field descriptions added or changed.

Example:

```text
logoPath
posterPath
```

Do not dump the entire dictionary unless requested.

## Discrepancies

Report any mismatch found between:

- official TMDB documentation
- SDK implementation
- existing KDoc

If none:

```text
No relevant TMDB/SDK documentation discrepancies found.
```

## Validation

Report commands actually executed and their result.

Example:

```text
mvn -B -ntp -pl tmdb-core dokka:dokka
BUILD SUCCESS
```

Do not claim success without running the command.

# Most Important Rules

1. Read the official TMDB Markdown documentation for every endpoint before documenting it.
2. Never invent TMDB semantics.
3. Keep identical concepts identically documented across the SDK.
4. Maintain canonical recurring field descriptions.
5. Do not add low-value KDoc merely for coverage.
6. Prefer concise semantic documentation over verbose prose.
7. Existing KDoc may be rewritten or removed.
8. Do not change production behavior.
9. Report discrepancies instead of hiding them.
10. Audit the complete requested scope before finishing.
