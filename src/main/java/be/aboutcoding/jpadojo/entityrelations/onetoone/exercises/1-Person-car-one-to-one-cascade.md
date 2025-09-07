# Exercise: One-to-One Relationship with Cascade Operations

You will find the classes to adjust in the `be.aboutcoding.jpadojo.entityrelations.onetoone.domain` package.

## Verify your solution with an AI agent: 

`verify my person-car-one-to-one relationship exercise`

## Context
You're building a system to track employees and their company cars. In this business context:
- Each person can have **at most one company car**
- Each company car can be assigned to **at most one person**
- When we save a person, any associated car should automatically be saved too
- We want to avoid having to explicitly save car objects

## Learning Objectives
After completing this exercise, you will understand:
- How to implement unidirectional One-to-One relationships in JPA
- The concept of **relationship ownership** and foreign keys
- How **cascade operations** work to automatically persist related entities
- The difference between bidirectional and unidirectional relationships

## The Challenge
You need to configure the JPA entities so that when you save a `Person` object (and only a Person object), any 
associated `Car` is automatically persisted to the database.

**Key Requirement**: You should **never explicitly call** `carRepository.save()` in your controller 
or service layer. The car should be saved automatically when saving the person.

## What You Need to Implement

### 1. Entity Annotations
Complete the JPA annotations in both `Person.java` and `Car.java`:

- Add the necessary `@Entity`, `@Id`, and `@GeneratedValue` annotations
- Configure the One-to-One relationship between Person and Car
- Decide who owns the relationship (who should have the foreign key?)
- Configure cascade operations so cars are automatically saved with persons

### 2. Key Questions to Consider

**Relationship Ownership:**
- Should the `persons` table have a `car_id` foreign key column?
- Or should the `cars` table have a `person_id` foreign key column?
- Who is the "owner" of this relationship in the business context?

**Cascade Configuration:**
- What cascade type should you use to automatically save cars when saving persons?
- Should updates to a person also update the associated car?
- What happens when you delete a person - should the car be deleted too?

**Bidirectional vs Unidirectional:**
- Should `Car` have a reference back to `Person`?
- What are the advantages and disadvantages of each approach?

## Expected Behavior

When you complete the exercise, these scenarios should work:

### Scenario 1: Create Person with Car
```http
PUT /jpa/training/person
{
  "firstName": "John",
  "lastName": "Doe", 
  "department": "Engineering",
  "currentCar": {
    "make": "Toyota",
    "model": "Camry",
    "numberPlate": "ABC-123"
  }
}
```
**Expected Result**: Both Person and Car are saved to database

### Scenario 2: Create Person without Car
```http
PUT /jpa/training/person
{
  "firstName": "Jane",
  "lastName": "Smith",
  "department": "Marketing",
  "currentCar": null
}
```
**Expected Result**: Only Person is saved to database

### Scenario 3: Retrieve All Persons
```http
GET /jpa/training/person
```
**Expected Result**: Returns all persons with their associated cars (if any)

## Success Criteria
- ✅ Person entities save successfully
- ✅ Car entities save automatically when associated with a person
- ✅ No explicit calls to `carRepository.save()` needed
- ✅ GET endpoint returns persons with their cars
- ✅ Database foreign key constraints are properly configured
- ✅ Application starts without JPA mapping errors

## Hints
- Think about who "owns" the company car in real life
- The owner of the relationship typically holds the foreign key
- Look into `CascadeType` options - which one fits this scenario?
- Consider using `@JoinColumn` to specify the foreign key column name

## Database Schema
You'll be working with these tables (created by Flyway migrations):
- `persons` table with columns: id, first_name, last_name, department
- `cars` table with columns: id, make, model, number_plate
- One of these tables will need a foreign key column to the other

Good luck! Remember: the goal is to understand relationship ownership and automatic persistence through cascading.