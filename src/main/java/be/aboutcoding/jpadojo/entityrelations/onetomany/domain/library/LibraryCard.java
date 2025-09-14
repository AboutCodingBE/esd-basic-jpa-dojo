package be.aboutcoding.jpadojo.entityrelations.onetomany.domain.library;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class LibraryCard {

    private Long id;

    private String cardNumber;

    private String holderName;

    private String email;

    private List<Book> checkedOutBooks;

}
