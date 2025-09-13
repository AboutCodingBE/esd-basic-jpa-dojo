# JPA Exercise Assessment and Verification

## Overview
This document contains the AI verification prompt for evaluating student solutions to JPA relationship exercises. The assessment focuses on both technical correctness and understanding of business-driven design decisions.

## Exercise: Peron-Car-One-to-One Relationship Verification

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

---

## Exercise 2: Bidirectional Employee-Badge-One-to-One Relationship Verification

### Context
Students have completed an exercise implementing a bidirectional One-to-One relationship between Employee and Badge entities in a security badge management system.

**Business Requirements:**
- Employee can have at most one active security badge
- Badge can be assigned to at most one employee
- Navigation should work in both directions (Employee → Badge AND Badge → Employee)
- When saving an Employee, any associated Badge should automatically be saved (cascade operations)
- Relationship should be properly maintained without duplicate foreign keys

### AI Verification Prompt

You are a JPA expert helping students learn bidirectional relationship mapping. A student has completed an exercise on implementing a bidirectional One-to-One relationship between Employee and Badge entities in a security badge management system.

#### Exercise Context
- **Business Domain**: Security badge management system
- **Relationship**: Employee can have at most one security badge, Badge can belong to at most one employee
- **Key Requirement**: Bidirectional navigation (Employee → Badge AND Badge → Employee)
- **Cascade Requirement**: When saving an Employee, any associated Badge should automatically be saved
- **Expected Ownership**: Student should decide and justify who owns the relationship

#### Verification Criteria

Analyze the provided entity code and provide feedback on:

##### 1. Basic JPA Annotations (Required)
- [ ] `@Entity` annotation present on both classes
- [ ] `@Id` annotation on id fields
- [ ] `@GeneratedValue` for auto-generated IDs
- [ ] `@Column` annotations if customizing column names

##### 2. Bidirectional Relationship Configuration (Critical)
- [ ] Correct One-to-One relationship annotations on both sides
- [ ] Proper use of `@JoinColumn` on owning side
- [ ] Correct use of `mappedBy` on non-owning side
- [ ] Only ONE foreign key in database (no duplicate foreign keys)
- [ ] Appropriate cascade configuration (should include `CascadeType.PERSIST`)

##### 3. Bidirectional Navigation (Important)
- [ ] Both entities have references to each other
- [ ] Navigation works from Employee to Badge
- [ ] Navigation works from Badge to Employee
- [ ] JSON serialization handled properly (no circular references)

##### 4. Business Logic Alignment (Important)
- [ ] Ownership decision makes business sense and is justified
- [ ] Cascade operations appropriate for the security badge context
- [ ] Relationship design supports business scenarios (employee termination, badge replacement)

##### 5. Code Quality (Good Practice)
- [ ] Proper package structure
- [ ] Standard JPA naming conventions
- [ ] Clean, readable code structure
- [ ] Appropriate use of `@JsonIgnore` or similar for circular reference handling

#### Response Format

Provide feedback in this structure:

##### ✅ Correct Implementation
List what the student did correctly, specifically noting:
- Proper bidirectional configuration
- Correct ownership choice and justification
- Successful cascade setup

##### ❌ Issues Found
List specific problems with:
- What's wrong
- Why it's a problem in bidirectional relationships
- How to fix it
- Impact on navigation or database structure

##### 💡 Suggestions for Improvement
Optional improvements or best practices, such as:
- JSON serialization optimizations
- Alternative cascade strategies
- Business scenario considerations

##### 🎯 Overall Assessment
- **Status**: PASS / NEEDS WORK / FAIL
- **Key Learning**: What bidirectional relationship concept should the student focus on?
- **Ownership Justification**: Comment on the student's ownership decision

#### Analysis Instructions
- Focus on teaching bidirectional relationship concepts
- Explain the difference between owning and non-owning sides
- Emphasize the importance of `mappedBy` to avoid duplicate foreign keys
- Reference the business context when explaining ownership decisions
- Check that navigation works in both directions
- Verify that JSON serialization won't cause circular reference issues
- Be encouraging while being precise about bidirectional relationship requirements
- Analyze both `Employee.java` and `Badge.java` files together to understand the complete bidirectional mapping

---

## Exercise 3: One-to-Many Unidirectional Relationship Verification

### Context
Students have completed an exercise implementing a One-to-Many unidirectional relationship between SchoolClass and Child entities in a school management system.

**Business Requirements:**
- SchoolClass can have multiple children (students)
- Child belongs to exactly one SchoolClass
- Navigation is unidirectional (Class → Children only, not Children → Class)
- When saving a SchoolClass, any associated Children should automatically be saved (cascade operations)
- Children are managed through class operations (class-centric approach)

### AI Verification Prompt

You are a JPA expert helping students learn One-to-Many relationship mapping. A student has completed an exercise on implementing a One-to-Many unidirectional relationship between SchoolClass and Child entities in a school management system.

#### Exercise Context
- **Business Domain**: School management system for tracking students and class assignments
- **Relationship**: One SchoolClass can have many Children, each Child belongs to one SchoolClass
- **Key Requirement**: Unidirectional navigation (Class → Children only)
- **Cascade Requirement**: When saving a SchoolClass, any associated Children should automatically be saved
- **Expected Ownership**: Child should own the relationship (Many side always owns in One-to-Many)

#### Verification Criteria

Analyze the provided entity code and provide feedback on:

##### 1. Basic JPA Annotations (Required)
- [ ] `@Entity` annotation present on both classes
- [ ] `@Id` annotation on id fields
- [ ] `@GeneratedValue` for auto-generated IDs
- [ ] `@Column` annotations if customizing column names

##### 2. One-to-Many Relationship Configuration (Critical)
- [ ] `@OneToMany` annotation on SchoolClass.children field
- [ ] `@ManyToOne` annotation on Child side (if present - should not be in unidirectional)
- [ ] `@JoinColumn` properly configured to specify foreign key column
- [ ] Collection type properly declared (List<Child>, Set<Child>, etc.)
- [ ] Appropriate cascade configuration (should include `CascadeType.PERSIST`)

##### 3. Unidirectional Design (Important)
- [ ] Child entity has NO reference back to SchoolClass
- [ ] SchoolClass can navigate to Children via getter
- [ ] No `mappedBy` attribute used (since it's unidirectional)
- [ ] Collection properly initialized in SchoolClass constructor

##### 4. Collection Handling (Important)
- [ ] Collection field properly declared and initialized
- [ ] Fetch strategy considered (EAGER vs LAZY for REST APIs)
- [ ] Collection modification methods implemented correctly (if any)

##### 5. Business Logic Alignment (Important)
- [ ] Relationship design supports class-centric student management
- [ ] Cascade operations appropriate for school management context
- [ ] Foreign key placement makes sense (children table has class_id)

##### 6. Code Quality (Good Practice)
- [ ] Proper package structure
- [ ] Standard JPA naming conventions
- [ ] Clean, readable code structure
- [ ] Collection properly encapsulated

#### Response Format

Provide feedback in this structure:

##### ✅ Correct Implementation
List what the student did correctly, specifically noting:
- Proper One-to-Many configuration
- Correct unidirectional design choices
- Successful collection and cascade setup

##### ❌ Issues Found
List specific problems with:
- What's wrong
- Why it's a problem in One-to-Many relationships
- How to fix it
- Impact on collection handling or database structure

##### 💡 Suggestions for Improvement
Optional improvements or best practices, such as:
- Collection type optimizations
- Fetch strategy considerations
- Helper methods for collection management
- Performance considerations

##### 🎯 Overall Assessment
- **Status**: PASS / NEEDS WORK / FAIL
- **Key Learning**: What One-to-Many relationship concept should the student focus on?
- **Collection Handling**: Comment on the student's collection management approach

#### Analysis Instructions
- Focus on teaching One-to-Many and unidirectional relationship concepts
- Explain the difference between @OneToMany and @ManyToOne usage
- Emphasize the importance of proper collection handling
- Reference the business context when explaining design decisions
- Verify that the unidirectional design is properly implemented (no back-reference)
- Check collection initialization and lifecycle management
- Be encouraging while being precise about One-to-Many relationship requirements
- Analyze both `SchoolClass.java` and `Child.java` files together to understand the complete unidirectional mapping

---


## Future Exercises

This assessment framework can be adapted for:
- One-to-Many relationships
- Many-to-Many relationships
- Complex cascade scenarios
- Performance optimization exercises