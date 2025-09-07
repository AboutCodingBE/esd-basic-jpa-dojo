# Exercise 2: Bidirectional One-to-One Relationship with Security Badges

You will find the classes to adjust in the `be.aboutcoding.jpadojo.entityrelations.onetoone.domain` package.


## Verify your solution with an AI agent:

`verify my employee-badge one-to-one relationship exercise`

## Context
You're building a security badge management system for a corporate office. In this business context:
- Each employee can have **at most one active security badge**
- Each security badge can be assigned to **at most one employee**
- When we save an employee with a badge, the badge should automatically be saved too
- When we query a badge, we should be able to find out which employee it belongs to
- We need to handle scenarios where employees leave (badge becomes unassigned) or badges are lost/damaged

## Learning Objectives
After completing this exercise, you will understand:
- How to implement **bidirectional One-to-One relationships** in JPA
- The difference between **owning side** and **non-owning side** in bidirectional relationships
- How to use `mappedBy` to avoid duplicate foreign keys
- Different **cascade strategies** for complex business scenarios
- **Navigation in both directions** between related entities

## The Challenge
You need to configure the JPA entities so that:
1. You can navigate from Employee → Badge AND from Badge → Employee
2. When you save an Employee with a badge, the badge is automatically persisted
3. When you query a badge, you can immediately access the employee information
4. The relationship is properly maintained in both directions

**Key Requirement**: You should **never explicitly call** `badgeRepository.save()` in your controller. The badge should be saved automatically when saving the employee.

## What You Need to Implement

### 1. Bidirectional Entity Mapping
Complete the JPA annotations in both `Employee.java` and `Badge.java`:

- Configure the **owning side** of the relationship (who has the foreign key?)
- Configure the **non-owning side** using `mappedBy`
- Add appropriate cascade operations
- Ensure navigation works in both directions

### 2. Key Questions to Consider

**Relationship Ownership:**
- Should the `employees` table have a `badge_id` foreign key column?
- Or should the `badges` table have an `employee_id` foreign key column?
- Think about the business process: who controls badge assignment?

**Bidirectional Navigation:**
- How do you avoid creating two separate foreign keys?
- What is the `mappedBy` attribute and why is it important?
- Which side should be the owning side vs the non-owning side?

**Cascade Configuration:**
- Should deleting an employee also delete their badge?
- Should creating an employee automatically create a badge?
- What happens when a badge is lost or damaged?

**Business Scenarios:**
- Employee joins company → gets new badge
- Employee leaves company → badge becomes available for reassignment
- Badge is lost/damaged → employee gets replacement badge

## Expected Behavior

When you complete the exercise, these scenarios should work:

### Scenario 1: Create Employee with Badge
```http
PUT /jpa/training/employee
{
  "firstName": "Alice",
  "lastName": "Johnson", 
  "department": "Security",
  "securityBadge": {
    "badgeNumber": "SEC-001",
    "accessLevel": "HIGH",
    "issueDate": "2024-01-15"
  }
}
```
**Expected Result**: Both Employee and Badge are saved, relationship works in both directions

### Scenario 2: Create Employee without Badge
```http
PUT /jpa/training/employee
{
  "firstName": "Bob",
  "lastName": "Smith",
  "department": "Facilities",
  "securityBadge": null
}
```
**Expected Result**: Only Employee is saved

### Scenario 3: Retrieve Employee (shows badge info)
```http
GET /jpa/training/employee
```
**Expected Result**: Returns employees with their badges

### Scenario 4: Retrieve Badge (shows employee info)
```http
GET /jpa/training/badge
```
**Expected Result**: Returns badges with their assigned employees

## Success Criteria
- ✅ Employee entities save successfully
- ✅ Badge entities save automatically when associated with an employee
- ✅ Bidirectional navigation works (Employee → Badge AND Badge → Employee)
- ✅ No duplicate foreign keys in database
- ✅ GET endpoints work for both employees and badges
- ✅ Only one side of the relationship holds the foreign key
- ✅ `mappedBy` is correctly configured on the non-owning side

## Hints
- **Ownership decision**: Think about who initiates the badge assignment process
- **mappedBy**: Points to the field name on the owning side, not the table column
- **Avoid circular references**: Use `@JsonIgnore` or `@JsonBackReference`/`@JsonManagedReference` if needed
- **Cascade carefully**: Consider what should happen in each business scenario

## Advanced Challenge
Once you have the basic relationship working, consider:
- What cascade types make sense for employee termination?
- How would you handle badge replacement scenarios?
- Should there be validation to prevent duplicate badge assignments?

## Database Schema
You'll be working with these tables (created by Flyway migrations):
- `employees` table with columns: id, first_name, last_name, department
- `badges` table with columns: id, badge_number, access_level, issue_date
- One of these tables will need a foreign key column to the other

Good luck! Remember: **bidirectional** means you can navigate in both directions, but only **one side owns** the relationship in the database.