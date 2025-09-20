package be.aboutcoding.jpadojo.entityrelations.onetomany;

import be.aboutcoding.jpadojo.entityrelations.onetomany.domain.library.Book;
import be.aboutcoding.jpadojo.entityrelations.onetomany.domain.library.LibraryCard;
import be.aboutcoding.jpadojo.entityrelations.onetomany.domain.school.Child;
import be.aboutcoding.jpadojo.entityrelations.onetomany.domain.school.SchoolClass;
import be.aboutcoding.jpadojo.entityrelations.onetomany.dto.library.BookResponse;
import be.aboutcoding.jpadojo.entityrelations.onetomany.dto.library.CreateLibraryCardRequest;
import be.aboutcoding.jpadojo.entityrelations.onetomany.dto.library.LibraryCardResponse;
import be.aboutcoding.jpadojo.entityrelations.onetomany.dto.school.ChildResponse;
import be.aboutcoding.jpadojo.entityrelations.onetomany.dto.school.ClassResponse;
import be.aboutcoding.jpadojo.entityrelations.onetomany.dto.school.CreateClassRequest;
import be.aboutcoding.jpadojo.entityrelations.onetomany.repository.library.BookRepository;
import be.aboutcoding.jpadojo.entityrelations.onetomany.repository.library.LibraryCardRepository;
import be.aboutcoding.jpadojo.entityrelations.onetomany.repository.school.ChildRepository;
import be.aboutcoding.jpadojo.entityrelations.onetomany.repository.school.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/jpa/training/manytoone")
public class OneToManyController {

    @Autowired
    private ClassRepository classRepository;

    @Autowired
    private ChildRepository childRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private LibraryCardRepository libraryCardRepository;

    @GetMapping("/class")
    public ResponseEntity<List<ClassResponse>> getAllClasses() {
        List<SchoolClass> classes = classRepository.findAll();
        List<ClassResponse> response = classes.stream()
                .map(ClassResponse::from)
                .toList();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/class")
    public ResponseEntity<ClassResponse> createOrUpdateClass(@RequestBody CreateClassRequest request) {
        // Convert DTO to entity
        SchoolClass schoolClass = convertToEntity(request);

        // Save entity (children should be saved automatically via cascade)
        SchoolClass savedClass = classRepository.save(schoolClass);

        // Convert back to response DTO
        ClassResponse response = ClassResponse.from(savedClass);
        return ResponseEntity.ok(response);
    }

    private SchoolClass convertToEntity(CreateClassRequest request) {
        SchoolClass schoolClass = new SchoolClass();
        schoolClass.setClassName(request.className());
        schoolClass.setTeacher(request.teacher());
        schoolClass.setRoom(request.room());

        // Convert list of ChildRequest to list of Child entities
        List<Child> children = new ArrayList<>();
        if (request.children() != null) {
            for (CreateClassRequest.ChildRequest childRequest : request.children()) {
                Child child = new Child();
                child.setFirstName(childRequest.firstName());
                child.setLastName(childRequest.lastName());
                child.setAge(childRequest.age());
                child.setStudentNumber(childRequest.studentNumber());
                children.add(child);
            }
        }
        schoolClass.setChildren(children);

        return schoolClass;
    }

    @GetMapping("/child")
    public ResponseEntity<List<ChildResponse>> getAllChildren() {
        List<Child> children = childRepository.findAll();
        List<ChildResponse> response = children.stream()
                .map(ChildResponse::from)
                .toList();
        return ResponseEntity.ok(response);
    }

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
