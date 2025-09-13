# Exercise 3: One-to-Many Unidirectional Relationship with School Classes

## Verify your solution with an AI agent:

`verify my class-children one-to-many relationship exercise`

## Context
You're building a school management system to track students and their class assignments. In this educational context:
- Each class can have **multiple children (students)**
- Each child can be assigned to **exactly one class**
- When we save a class with students, all students should automatically be saved too
- We manage students through their class assignments (class-centric approach)
- Navigation is unidirectional: we can find students from a class, but not the class from a student directly

## Learning Objectives
After completing this exercise, you will understand:
- How to implement **One-to-Many unidirectional relationships** in JPA
- The use of **@OneToMany** and **@ManyToOne** annotations
- How **@JoinColumn** works in One-to-Many relationships
- **Collection handling** in JPA entities and DTOs
- **Cascade operations** for automatically persisting collections
- The difference between **unidirectional One-to-Many** vs **bidirectional**

## The Challenge
You need to configure the JPA entities so that:
1. A Class can contain a collection of Children
2. Each Child belongs to exactly one Class (but Child doesn't know about Class)
3. When you save a Class with children, all children are automatically persisted
4. You can query classes and see all their students
5. Children are managed through class operations, not independently

**Key Requirement**: You should **never explicitly call** `childRepository.save()` in your controller. Children should be saved automatically when saving the class.

## What You Need to Implement

### 1. One-to-Many Entity Mapping
Complete the JPA annotations in both `SchoolClass.java` and `Child.java`:

- Configure the **@OneToMany** relationship on the class side
- Configure the **@ManyToOne** relationship on the child side
- Use **@JoinColumn** to specify the foreign key
- Add appropriate cascade operations
- Handle **Collection** types properly (List, Set, etc.)

### 2. Key Questions to Consider

**Relationship Ownership:**
- Should the `classes` table have a collection foreign key? (Not possible!)
- Should the `children` table have a `class_id` foreign key column?
- In One-to-Many, which side always owns the relationship?

**Collection Handling:**
- What Collection type should you use? List? Set? Why?
- How do you initialize the collection?
- How do you handle adding/removing children from a class?

**Cascade Configuration:**
- Should adding a child to a class automatically save the child?
- What happens when you delete a class - should children be deleted too?
- What cascade types make sense for school management?

**Unidirectional Design:**
- Why doesn't Child have a reference back to SchoolClass?
- How would you find which class a child belongs to?
- What are the trade-offs of unidirectional vs bidirectional?

## Expected Behavior

When you complete the exercise, these scenarios should work:

### Scenario 1: Create Class with Children
```http
PUT /jpa/training/class
{
  "className": "Grade 3A",
  "teacher": "Mrs. Johnson",
  "room": "101",
  "children": [
    {
      "firstName": "Emma",
      "lastName": "Wilson",
      "age": 8,
      "studentNumber": "STU-001"
    },
    {
      "firstName": "Liam",
      "lastName": "Brown",
      "age": 9,
      "studentNumber": "STU-002"
    }
  ]
}
```
**Expected Result**: Both SchoolClass and all Children are saved to database

### Scenario 2: Create Empty Class
```http
PUT /jpa/training/class
{
  "className": "Grade 1B",
  "teacher": "Mr. Davis",
  "room": "203",
  "children": []
}
```
**Expected Result**: Only SchoolClass is saved with empty student list

### Scenario 3: Retrieve All Classes
```http
GET /jpa/training/class
```
**Expected Result**: Returns all classes with their complete student lists

### Scenario 4: Query Individual Children
```http
GET /jpa/training/child
```
**Expected Result**: Returns all children (but without class information - unidirectional!)

## Success Criteria
- ✅ SchoolClass entities save successfully
- ✅ Child entities save automatically when associated with a class
- ✅ Collections are properly handled (no lazy loading issues in API)
- ✅ GET class endpoint returns classes with their children
- ✅ GET child endpoint works but doesn't show class info (unidirectional)
- ✅ No explicit calls to `childRepository.save()` needed
- ✅ Database foreign key constraints are properly configured

## Hints
- **Collection initialization**: Always initialize collections in the entity constructor
- **@JoinColumn**: Specifies the foreign key column name in the child table
- **Cascade types**: Consider `CascadeType.PERSIST` and `CascadeType.MERGE`
- **Fetch strategy**: You might need `@OneToMany(fetch = FetchType.EAGER)` for REST APIs
- **Collection type**: `List<Child>` is usually a good choice for ordered collections

## Advanced Challenges
Once you have the basic relationship working, consider:
- How would you handle class capacity limits?
- What happens when a student transfers between classes?
- How would you implement student enrollment/withdrawal?
- Should there be validation to prevent duplicate student numbers?

## Database Schema
You'll be working with these tables (created by Flyway migrations):
- `classes` table with columns: id, class_name, teacher, room
- `children` table with columns: id, first_name, last_name, age, student_number, class_id
- The `children` table will have a foreign key to the `classes` table

## Real-World Application
This pattern is common in many domains:
- **Order → OrderItems** (e-commerce)
- **Invoice → LineItems** (accounting)
- **Project → Tasks** (project management)
- **Playlist → Songs** (music applications)

Good luck! Remember: **One-to-Many** means one parent entity manages a collection of child entities, and the **many side** always owns the relationship with the foreign key.