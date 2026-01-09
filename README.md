# Tic Tac Toe – Android Code Kata

## Table of Contents

- [Context](#context)
- [Objective](#objective)
- [Tech Stack](#tech-stack)
- [Design](#design)
- [How to Run](#how-to-run)
- [Tests](#tests)
- [Development Approach](#development-approach)
- [Possible Improvements](#possible-improvements)


## Context

This project is an Android code kata developed as part of a technical interview process.
The goal is not to build a complex game or a polished UI, but to demonstrate software craftsmanship,
code quality, and reasoning through a simple and well-known problem.


## Objective

The objective of this kata is to implement a Tic Tac Toe game while focusing on:
- clear domain modeling
- separation of responsibilities
- test-driven development
- readable and maintainable code

The game rules themselves are intentionally simple in order to keep the focus on design and code quality.


## Tech Stack

- Kotlin
- Jetpack Compose
- Android ViewModel
- JUnit (unit tests)


## Design

The application is structured around a small, explicit domain model.
The game logic is independent from Android and UI concerns, which allows it to be tested in isolation.

The main concepts are:
- a game aggregate responsible for orchestrating state changes
- an immutable board representing the current game state
- a rules evaluator responsible for determining the game status

### Domain Model

The following class diagram illustrates the core domain model and relationships:
- [`Domain Model`](docs/domain-model.md)

### Main Interaction Flow

The following sequence diagram shows the main interaction flow when a player makes a move:
- [`Sequence Play Move`](docs/sequence-play-move.md)


## How to Run

1. Open the project in Android Studio
2. Sync Gradle
3. Run the application on an emulator or a physical device


## Tests

The game logic is covered by unit tests focusing on behavior rather than implementation details.

Tests can be run using:
- Android Studio test runner
- Gradle command line

The tests were written following a test-driven approach to guide the design of the domain.


## Development Approach

This repository history reflects the incremental steps taken during development.
Each change was committed with the intent to keep the evolution of the solution readable,
rather than squashing commits into a single final state.


## Possible Improvements

- Support for different board sizes
- Improved error feedback in the UI
- Optional AI opponent

