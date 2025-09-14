package be.aboutcoding.jpadojo.entityrelations.onetomany.dto.library;


import be.aboutcoding.jpadojo.entityrelations.onetomany.domain.library.Book;
import be.aboutcoding.jpadojo.entityrelations.onetomany.domain.library.LibraryCard;

public record BookResponse(
        Long id,
        String title,
        String author,
        String isbn,
        String genre,
        LibraryCard libraryCard // Shows which library card has this book checked out
) {

    // Factory method to create from Book entity
    public static BookResponse from(Book book) {
        return new BookResponse(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getIsbn(),
                book.getGenre(),
                book.getLibraryCard()
        );
    }
}