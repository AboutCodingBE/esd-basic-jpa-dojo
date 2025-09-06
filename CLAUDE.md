# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This is a Spring Boot JPA dojo for practicing basic JPA concepts and relationships. The project uses:

- **Spring Boot 3.5.5** with Java 21
- **Spring Data JPA** for database operations
- **PostgreSQL** as the database
- **Lombok** for reducing boilerplate code
- **Maven** for build management

## Key Commands

### Build and Run
```bash
# Build the project
./mvnw clean compile

# Run the application
./mvnw spring-boot:run

# Package the application
./mvnw clean package
```

### Testing
```bash
# Run all tests
./mvnw test

# Run a specific test class
./mvnw test -Dtest=JpadojoApplicationTests

# Run tests with coverage
./mvnw test jacoco:report
```

### Development
```bash
# Clean and build
./mvnw clean compile

# Skip tests during build
./mvnw clean package -DskipTests
```

## Architecture

**Package Structure:**
- `be.aboutcoding.jpadojo` - Main application package
- Standard Spring Boot structure with `src/main/java` and `src/test/java`

**Technology Stack:**
- Uses PostgreSQL database (configured via `application.properties`)
- Leverages Spring Data JPA for ORM
- Lombok annotations for entity classes
- Maven compiler plugin configured for Lombok annotation processing

**Database Configuration:**
- Database connection details should be configured in `src/main/resources/application.properties`
- Currently configured with basic Spring application name only

## Development Notes

- This is a learning/dojo project focused on JPA relationships and concepts
- The codebase is minimal and designed for practicing JPA skills
- Lombok is configured in Maven for annotation processing during compilation