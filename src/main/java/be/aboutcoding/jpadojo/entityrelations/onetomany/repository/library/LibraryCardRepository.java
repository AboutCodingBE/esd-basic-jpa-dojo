package be.aboutcoding.jpadojo.entityrelations.onetomany.repository.library;

import be.aboutcoding.jpadojo.entityrelations.onetomany.domain.library.LibraryCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryCardRepository extends JpaRepository<LibraryCard, Long> {

}