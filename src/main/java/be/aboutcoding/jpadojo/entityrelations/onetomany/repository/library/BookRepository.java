package be.aboutcoding.jpadojo.entityrelations.onetomany.repository.library;

import be.aboutcoding.jpadojo.entityrelations.onetomany.domain.library.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}