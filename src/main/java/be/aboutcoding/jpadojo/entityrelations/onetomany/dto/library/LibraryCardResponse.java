package be.aboutcoding.jpadojo.entityrelations.onetomany.dto.library;

import be.aboutcoding.jpadojo.entityrelations.onetomany.domain.library.Book;
import be.aboutcoding.jpadojo.entityrelations.onetomany.domain.library.LibraryCard;
import jakarta.persistence.Column;

import java.util.List;

public record LibraryCardResponse(
        Long id,
        String cardNumber,
        String holderName,
        String email,
        List<BookResponse> checkedOutBooks
) {

    public record BookResponse(
            String title,
            String author,
            String isbn,
            String genre
    ){}

    // Factory method to create from LibraryCard entity
    public static LibraryCardResponse from(LibraryCard libraryCard) {
        return new LibraryCardResponse(
                libraryCard.getId(),
                libraryCard.getCardNumber(),
                libraryCard.getHolderName(),
                libraryCard.getEmail(),
                libraryCard.getCheckedOutBooks().stream()
                        .map(LibraryCardResponse::from)
                        .toList()
        );
    }

    private static BookResponse from(Book book) {
        return new BookResponse(
                book.getTitle(),
                book.getAuthor(),
                book.getIsbn(),
                book.getGenre()
        );
    }
}