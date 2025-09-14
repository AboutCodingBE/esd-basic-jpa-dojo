# Exercise 4: Bidirectional One-to-Many Relationship with Library Management

## Verify your solution with an AI agent:

`verify my library card books bidirectional one-to-many exercise`

## Context
You're building a library management system to track library cards and borrowed books. In this library context:
- Each library card can have **multiple books checked out**
- Each book can be checked out to **exactly one library card** (or be available)
- When we save a library card with books, all books should automatically be saved too
- We need bidirectional navigation: find books from a card AND find the cardholder from a book
- Librarians need to answer both "What books does John have?" and "Who has this overdue book?"

## Learning Objectives
After completing this exercise, you will understand:
- How to implement **bidirectional One-to-Many relationships** in JPA
- The use of **@OneToMany** with `mappedBy` and **@ManyToOne** with `@JoinColumn`
- How to avoid **duplicate foreign keys** in bidirectional relationships
- **Collection handling** in bidirectional scenarios
- **JSON serialization challenges** with bidirectional collections
- **Different cascade strategies** for collection relationships

## The Challenge
You need to configure the JPA entities so that:
1. A LibraryCard can contain a collection of checked-out Books
2. Each Book knows which LibraryCard it's checked out to (bidirectional navigation)
3. When you save a LibraryCard with books, all books are automatically persisted
4. You can query cards to see their books AND query books to see their cardholder
5. Only one side of the relationship controls the database foreign key

**Key Requirement**: You should **never explicitly call** `bookRepository.save()` in your controller when creating library cards. Books should be saved automatically when saving the library card.

## What You Need to Implement

### 1. Bidirectional One-to-Many Mapping
Complete the JPA annotations in both `LibraryCard.java` and `Book.java`:

- Configure the **@OneToMany** relationship on the library card side with `mappedBy`
- Configure the **@ManyToOne** relationship on the book side with `@JoinColumn`
- Add appropriate cascade operations
- Handle **Collection** types and bidirectional references properly

### 2. Key Questions to Consider

**Relationship Ownership:**
- Should LibraryCard own the relationship or should Book own it?
- Which entity should have the `@JoinColumn` annotation?
- Which entity should use `mappedBy`?
- Think: In the real world, do books get assigned to cards, or do cards claim books?

**Bidirectional Navigation:**
- How do you ensure both sides of the relationship stay in sync?
- What happens when you add a book to a card's collection?
- Should you provide helper methods to maintain the relationship?

**Cascade Configuration:**
- Should deleting a library card also delete the books? (Probably not!)
- Should returning books (removing from collection) delete the books? (No!)
- What cascade types make sense for library management?

**JSON Serialization:**
- How do you prevent infinite loops when serializing bidirectional relationships?
- Should both sides include the full related entity in JSON responses?

## Expected Behavior

When you complete the exercise, these scenarios should work:

### Scenario 1: Create Library Card with Books
```http
PUT /jpa/training/librarycard
{
  "cardNumber": "LIB-001",
  "holderName": "Alice Johnson",
  "email": "alice@example.com",
  "checkedOutBooks": [
    {
      "title": "Spring Boot in Action",
      "author": "Craig Walls",
      "isbn": "978-1617292545",
      "genre": "Technology"
    },
    {
      "title": "Clean Code",
      "author": "Robert Martin",
      "isbn": "978-0132350884",
      "genre": "Technology"
    }
  ]
}
```
**Expected Result**: Both LibraryCard and all Books are saved, bidirectional relationship established

### Scenario 2: Create Empty Library Card
```http
PUT /jpa/training/librarycard
{
  "cardNumber": "LIB-002",
  "holderName": "Bob Smith",
  "email": "bob@example.com",
  "checkedOutBooks": []
}
```
**Expected Result**: Only LibraryCard is saved with empty book collection

### Scenario 3: Retrieve All Library Cards (shows books)
```http
GET /jpa/training/librarycard
```
**Expected Result**: Returns all library cards with their checked-out books

### Scenario 4: Retrieve All Books (shows cardholders)
```http
GET /jpa/training/book
```
**Expected Result**: Returns all books with their library card assignments (bidirectional!)

## Success Criteria
- ✅ LibraryCard entities save successfully
- ✅ Book entities save automatically when associated with a library card
- ✅ Bidirectional navigation works (LibraryCard → Books AND Book → LibraryCard)
- ✅ Only one foreign key in database (books table has library_card_id)
- ✅ GET endpoints work for both library cards and books
- ✅ JSON serialization doesn't cause circular references
- ✅ `mappedBy` is correctly configured on the non-owning side

## Hints
- **Ownership decision**: Think about which entity is more "permanent" - cards or books?
- **mappedBy**: Points to the field name on the owning side (the @ManyToOne side)
- **Collection initialization**: Always initialize collections in constructors
- **JSON handling**: Use `@JsonIgnore` or `@JsonBackReference`/`@JsonManagedReference` if needed
- **Helper methods**: Consider adding `addBook()` and `removeBook()` methods to maintain both sides

## Advanced Challenges
Once you have the basic relationship working, consider:
- How would you handle book returns (removing books from a card)?
- What happens when a library card expires but has unreturned books?
- How would you implement due dates and overdue tracking?
- Should there be validation to prevent duplicate book checkouts?

## Database Schema
You'll be working with these tables (created by Flyway migrations):
- `library_cards` table with columns: id, card_number, holder_name, email
- `books` table with columns: id, title, author, isbn, genre, library_card_id
- The `books` table will have a foreign key to the `library_cards` table

## Real-World Applications
This bidirectional One-to-Many pattern is common in many domains:
- **Customer → Orders** (e-commerce)
- **Department → Employees** (HR systems)
- **Project → Tasks** (project management)
- **Playlist → Songs** (music applications)

## Key Learning Point
Understanding that in bidirectional One-to-Many relationships:
- **One side owns** (uses @JoinColumn)
- **One side maps** (uses mappedBy)
- **Both sides can navigate** to each other
- **Only one foreign key** exists in the database

Good luck! Remember: **bidirectional** means you can navigate in both directions, but the **Many side always owns the foreign key**.