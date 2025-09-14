package be.aboutcoding.jpadojo.entityrelations.onetomany.dto.library;

import be.aboutcoding.jpadojo.entityrelations.onetomany.domain.library.Book;
import be.aboutcoding.jpadojo.entityrelations.onetomany.domain.library.LibraryCard;

import java.util.List;

public record LibraryCardResponse(
        Long id,
        String cardNumber,
        String holderName,
        String email,
        List<Book> checkedOutBooks
) {

    // Factory method to create from LibraryCard entity
    public static LibraryCardResponse from(LibraryCard libraryCard) {
        return new LibraryCardResponse(
                libraryCard.getId(),
                libraryCard.getCardNumber(),
                libraryCard.getHolderName(),
                libraryCard.getEmail(),
                libraryCard.getCheckedOutBooks()
        );
    }
}