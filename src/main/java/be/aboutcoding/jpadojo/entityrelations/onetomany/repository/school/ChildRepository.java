package be.aboutcoding.jpadojo.entityrelations.onetomany.repository.school;

import be.aboutcoding.jpadojo.entityrelations.onetomany.domain.school.Child;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChildRepository extends JpaRepository<Child, Long> {

    // TODO: Add custom query methods if needed for the exercises
    // Examples:
    // List<Child> findByAge(int age);
    // List<Child> findByStudentNumber(String studentNumber);
    // Note: In unidirectional relationships, you cannot easily query by class

}
