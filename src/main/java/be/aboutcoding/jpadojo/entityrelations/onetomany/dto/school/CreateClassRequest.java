package be.aboutcoding.jpadojo.entityrelations.onetomany.dto.school;

import java.util.List;

public record CreateClassRequest(
        String className,
        String teacher,
        String room,
        List<ChildRequest> children // List of children without IDs
) {

    // Inner record for child data without ID
    public record ChildRequest(
            String firstName,
            String lastName,
            int age,
            String studentNumber
    ) {
    }
}
