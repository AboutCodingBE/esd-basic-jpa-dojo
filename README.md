# The basic JPA dojo 



## Introduction
I believe in relentless practice by repeating with intent and purpose. I think that is a great way to hone your skills. This
dojo has some straightforward exercises which can be repeated over and over agian. The goal is of course not to memorise the
exercises but to become fluent in certain basic aspects of JPA. 

## About the exercises

There is a total of 5 branches. The main branch holds the solution concerning the relationships. It might be that you need to
code a little bit more to get the application running smoothly. The exercises are grouped per topic in a folder / package. 
For example: the exercises on entity relations are in the following package: `be.aboutcoding.jpadojo.entityrelations`.

## How to Do the Exercises

### Setup
1. **Start the database**: `docker-compose up -d` to start the PostgreSQL database
2. **Run the application**: `./mvnw spring-boot:run` to start the Spring Boot application

### Exercise Workflow

Each exercise is available on its own branch. Follow this workflow:

1. **Switch to one of the following branches**:
   ```bash
   git checkout ex/one-on-one-bidirectional
   git checkout ex/one-on-one-unidirectional
   git checkout ex/one-to-many-bidirectional
   git checkout ex/one-to-many-unidirectional
   ```

2. **Find the exercise description**: Each exercise has a markdown file in the `exercises` folder explaining:
    - The business context and requirements
    - Learning objectives
    - What JPA concepts you need to implement
    - Expected REST API behavior

3. **Implement your solution**: Complete the JPA entity mappings according to the exercise requirements

4. **Test your implementation**:
    - Start the application: `./mvnw spring-boot:run`
    - Use the REST endpoints to test your entities work correctly
    - Check the console for SQL queries and any errors

5. **Verify your solution**: Use Claude Code to verify your implementation:
   ```
   verify my [exercise-name] exercise
   ```
   Each exercise markdown file contains the exact verification command.

6. **Iterate until perfect**: Based on the feedback, refine your solution and re-verify

### Available Exercises

The exercises progress from simple to complex JPA relationship concepts:

**One-to-One Relationships:**
- `exercise/person-car-one-to-one` - Unidirectional one-to-one with cascade operations
- `exercise/employee-badge-one-to-one` - Bidirectional one-to-one with proper ownership

**One-to-Many Relationships:**
- `exercise/class-children-one-to-many` - Unidirectional one-to-many with collection management
- `exercise/library-card-books-one-to-many` - Bidirectional one-to-many with smart cascading

### Exercise Goals

- **Master JPA annotations**: `@Entity`, `@OneToOne`, `@OneToMany`, `@ManyToOne`, `@JoinColumn`, `mappedBy`
- **Understand relationship ownership**: Who owns the foreign key and why
- **Learn cascade operations**: When and how to automatically persist related entities
- **Practice fetch strategies**: EAGER vs LAZY loading for different scenarios
- **Handle bidirectional navigation**: Maintaining consistency in both directions

### Tips for Success

- **Read the business context carefully** - Understanding the domain helps make the right technical decisions
- **Think about ownership** - In the real world, who controls the relationship?
- **Test with real data** - Use the REST endpoints to verify your mappings work correctly
- **Use Claude Code verification** - Get immediate feedback on your implementation
- **Practice repeatedly** - Switch between branches and redo exercises to build muscle memory 