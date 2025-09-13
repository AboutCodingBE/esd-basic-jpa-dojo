package be.aboutcoding.jpadojo.entityrelations.onetomany.dto.school;

import be.aboutcoding.jpadojo.entityrelations.onetomany.domain.school.Child;
import be.aboutcoding.jpadojo.entityrelations.onetomany.domain.school.SchoolClass;

import java.util.List;

public record ClassResponse(
        Long id,
        String className,
        String teacher,
        String room,
        List<Child> children
) {

    // Factory method to create from SchoolClass entity
    public static ClassResponse from(SchoolClass schoolClass) {
        return new ClassResponse(
                schoolClass.getId(),
                schoolClass.getClassName(),
                schoolClass.getTeacher(),
                schoolClass.getRoom(),
                schoolClass.getChildren()
        );
    }
}
