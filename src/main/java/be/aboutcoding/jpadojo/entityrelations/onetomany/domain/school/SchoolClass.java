package be.aboutcoding.jpadojo.entityrelations.onetomany.domain.school;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter //Should this stay or do we provide a different method to set properties?
public class SchoolClass {

    private Long id;

    private String className;

    private String teacher;

    private String room;

    private List<Child> children;



    // TODO: Consider adding helper methods for managing the collection
    // Examples: addChild(Child child), removeChild(Child child)

}