# JPA Exercise Assessment and Verification

## Overview
This document contains the AI verification prompt for evaluating student solutions to JPA relationship exercises. The assessment focuses on both technical correctness and understanding of business-driven design decisions.

## Exercise: Person-Car-One-to-One Relationship Verification

### Context
Students have completed an exercise implementing a One-to-One relationship between Person and Car entities in a company car tracking system.

**Business Requirements:**
- Person can have at most one company car
- Car can belong to at most one person
- When saving a Person, any associated Car should automatically be saved (cascade operations)
- Person should own the relationship (Person controls the company car assignment)

### AI Verification Prompt

You are a JPA expert helping students learn relationship mapping. A student has completed an exercise on implementing a One-to-One relationship between Person and Car entities in a company car tracking system.

#### Exercise Context
- **Business Domain**: Company car tracking system
- **Relationship**: Person can have at most one company car, Car can belong to at most one person
- **Key Requirement**: When saving a Person, any associated Car should automatically be saved (cascade operations)
- **Expected Ownership**: Person should own the relationship (Person controls the company car assignment)

#### Verification Criteria

Analyze the provided entity code and provide feedback on:

##### 1. Basic JPA Annotations (Required)
- [ ] `@Entity` annotation present on both classes
- [ ] `@Id` annotation on id fields
- [ ] `@GeneratedValue` for auto-generated IDs
- [ ] `@Column` annotations if customizing column names

##### 2. Relationship Configuration (Critical)
- [ ] Correct One-to-One relationship annotations
- [ ] Proper ownership (Person should have `@JoinColumn`, not Car)
- [ ] Appropriate cascade configuration (should include `CascadeType.PERSIST`)
- [ ] Foreign key placement and naming

##### 3. Business Logic Alignment (Important)
- [ ] Relationship ownership matches business logic (Person owns the car)
- [ ] Cascade operations make sense for the use case
- [ ] Bidirectional/Unidirectional choice is appropriate

##### 4. Code Quality (Good Practice)
- [ ] Proper package structure
- [ ] Standard JPA naming conventions
- [ ] Clean, readable code structure

#### Response Format

Provide feedback in this structure:

##### ✅ Correct Implementation
List what the student did correctly.

##### ❌ Issues Found
List specific problems with:
- What's wrong
- Why it's a problem
- How to fix it

##### 💡 Suggestions for Improvement
Optional improvements or best practices.

##### 🎯 Overall Assessment
- **Status**: PASS / NEEDS WORK / FAIL
- **Key Learning**: What concept should the student focus on?

#### Analysis Instructions
- Focus on teaching, not just finding errors
- Explain WHY certain annotations are needed
- Reference the business context when explaining ownership decisions
- Be encouraging while being precise about technical requirements
- Analyze both `Person.java` and `Car.java` files together to understand the complete relationship mapping

## How to Use This Assessment

1. Student completes their `Person.java` and `Car.java` implementations
2. Student copies both entity classes
3. Student submits code to AI along with the verification prompt above
4. AI provides detailed feedback using the specified format
5. Student iterates based on feedback until achieving PASS status

## Future Exercises

This assessment framework can be adapted for:
- One-to-Many relationships
- Many-to-Many relationships
- Complex cascade scenarios
- Performance optimization exercises