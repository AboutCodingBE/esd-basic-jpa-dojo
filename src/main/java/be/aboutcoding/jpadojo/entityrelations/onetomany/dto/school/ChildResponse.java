package be.aboutcoding.jpadojo.entityrelations.onetomany.dto.school;

import be.aboutcoding.jpadojo.entityrelations.onetomany.domain.school.Child;

public record ChildResponse(
        Long id,
        String firstName,
        String lastName,
        int age,
        String studentNumber
        // Note: No class information - this is a unidirectional relationship!
        // Child doesn't know about SchoolClass
) {

    // Factory method to create from Child entity
    public static ChildResponse from(Child child) {
        return new ChildResponse(
                child.getId(),
                child.getFirstName(),
                child.getLastName(),
                child.getAge(),
                child.getStudentNumber()
        );
    }
}
