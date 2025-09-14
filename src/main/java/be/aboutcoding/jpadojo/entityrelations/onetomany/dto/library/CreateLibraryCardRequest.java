package be.aboutcoding.jpadojo.entityrelations.onetomany.dto.library;

import java.util.List;

public record CreateLibraryCardRequest(
        String cardNumber,
        String holderName,
        String email,
        List<BookRequest> checkedOutBooks // List of books without IDs
) {

    // Inner record for book data without ID
    public record BookRequest(
            String title,
            String author,
            String isbn,
            String genre
    ) {
    }
}