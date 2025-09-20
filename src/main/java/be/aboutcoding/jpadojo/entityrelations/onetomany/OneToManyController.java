package be.aboutcoding.jpadojo.entityrelations.onetomany;

import be.aboutcoding.jpadojo.entityrelations.onetomany.domain.library.Book;
import be.aboutcoding.jpadojo.entityrelations.onetomany.domain.library.LibraryCard;
import be.aboutcoding.jpadojo.entityrelations.onetomany.dto.library.BookResponse;
import be.aboutcoding.jpadojo.entityrelations.onetomany.dto.library.CreateLibraryCardRequest;
import be.aboutcoding.jpadojo.entityrelations.onetomany.dto.library.LibraryCardResponse;
import be.aboutcoding.jpadojo.entityrelations.onetomany.repository.library.BookRepository;
import be.aboutcoding.jpadojo.entityrelations.onetomany.repository.library.LibraryCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/jpa/training/manytoone")
public class OneToManyController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private LibraryCardRepository libraryCardRepository;

    @GetMapping("/librarycard")
    public ResponseEntity<List<LibraryCardResponse>> getAllLibraryCards() {
        List<LibraryCard> libraryCards = libraryCardRepository.findAll();
        List<LibraryCardResponse> response = libraryCards.stream()
                .map(LibraryCardResponse::from)
                .toList();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/librarycard")
    public ResponseEntity<LibraryCardResponse> createOrUpdateLibraryCard(@RequestBody CreateLibraryCardRequest request) {
        // Convert DTO to entity
        LibraryCard libraryCard = convertToEntity(request);

        // Save entity (books should be saved automatically via cascade)
        LibraryCard savedLibraryCard = libraryCardRepository.save(libraryCard);

        // Convert back to response DTO
        LibraryCardResponse response = LibraryCardResponse.from(savedLibraryCard);
        return ResponseEntity.ok(response);
    }

    private LibraryCard convertToEntity(CreateLibraryCardRequest request) {
        LibraryCard libraryCard = new LibraryCard();
        libraryCard.setCardNumber(request.cardNumber());
        libraryCard.setHolderName(request.holderName());
        libraryCard.setEmail(request.email());

        // Convert list of BookRequest to list of Book entities
        List<Book> books = new ArrayList<>();
        if (request.checkedOutBooks() != null) {
            for (CreateLibraryCardRequest.BookRequest bookRequest : request.checkedOutBooks()) {
                Book book = new Book();
                book.setTitle(bookRequest.title());
                book.setAuthor(bookRequest.author());
                book.setIsbn(bookRequest.isbn());
                book.setGenre(bookRequest.genre());
                // Set the bidirectional relationship
                book.setLibraryCard(libraryCard);
                books.add(book);
            }
        }
        libraryCard.setCheckedOutBooks(books);

        return libraryCard;
    }

    @GetMapping("/book")
    public ResponseEntity<List<BookResponse>> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        List<BookResponse> response = books.stream()
                .map(BookResponse::from)
                .toList();
        return ResponseEntity.ok(response);
    }
}
