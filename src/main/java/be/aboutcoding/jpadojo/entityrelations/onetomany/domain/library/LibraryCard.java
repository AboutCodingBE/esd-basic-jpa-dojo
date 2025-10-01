package be.aboutcoding.jpadojo.entityrelations.onetomany.domain.library;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "library_cards")
public class LibraryCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "holder_name")
    private String holderName;

    @Column(name = "email")
    private String email;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "libraryCard")
    private List<Book> checkedOutBooks = new ArrayList<>();

    public void addBook(Book book) {
        this.checkedOutBooks.add(book);
    }

}
