package be.aboutcoding.jpadojo.entityrelations.onetomany.domain.library;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book {

    private Long id;

    private String title;

    private String author;

    private String isbn;

    private String genre;

    private LibraryCard libraryCard;

}