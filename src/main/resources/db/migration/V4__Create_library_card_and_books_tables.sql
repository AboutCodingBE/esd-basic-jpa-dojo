-- Flyway migration script
-- File: src/main/resources/db/migration/V4__Create_library_card_and_books_tables.sql

-- Create library_cards table first (no foreign key dependencies)
CREATE TABLE library_cards (
    id BIGSERIAL PRIMARY KEY,
    card_number VARCHAR(20) NOT NULL UNIQUE,
    holder_name VARCHAR(100) NOT NULL,
    email VARCHAR(255) NOT NULL
);

-- Create books table with foreign key to library_cards
CREATE TABLE books (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(100) NOT NULL,
    isbn VARCHAR(20) NOT NULL UNIQUE,
    genre VARCHAR(50) NOT NULL,
    library_card_id BIGINT

    -- Foreign key constraint (Many-to-One: many books can be checked out to one library card)
    CONSTRAINT fk_book_library_card FOREIGN KEY (library_card_id) REFERENCES library_cards(id)
);