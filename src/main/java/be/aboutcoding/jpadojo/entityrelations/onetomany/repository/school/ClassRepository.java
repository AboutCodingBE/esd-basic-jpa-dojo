package be.aboutcoding.jpadojo.entityrelations.onetomany.repository.school;

import be.aboutcoding.jpadojo.entityrelations.onetomany.domain.school.SchoolClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository extends JpaRepository<SchoolClass, Long> {

    // TODO: Add custom query methods if needed for the exercises
    // Examples:
    // List<SchoolClass> findByTeacher(String teacher);
    // List<SchoolClass> findByRoom(String room);

}
