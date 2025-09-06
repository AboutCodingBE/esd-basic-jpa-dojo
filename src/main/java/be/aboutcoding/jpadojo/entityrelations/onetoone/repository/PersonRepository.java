package be.aboutcoding.jpadojo.entityrelations.onetoone.repository;

import be.aboutcoding.jpadojo.entityrelations.onetoone.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}