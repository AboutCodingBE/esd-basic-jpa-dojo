package be.aboutcoding.jpadojo.entityrelations.onetoone.dto;


import be.aboutcoding.jpadojo.entityrelations.onetoone.domain.employeebadge.Badge;

public record BadgeResponse(
        Long id,
        String badgeNumber,
        String accessLevel,
        String issueDate,
        EmployeeReponse assignedEmployee
) {

    public record EmployeeReponse(
            String firstName,
            String lastName,
            String department
    ) {}

    // Factory method to create from Badge entity
    public static BadgeResponse from(Badge badge) {
        return new BadgeResponse(
                badge.getId(),
                badge.getBadgeNumber(),
                badge.getAccessLevel(),
                badge.getIssueDate(),
                new EmployeeReponse(
                        badge.getAssignedEmployee().getFirstName(),
                        badge.getAssignedEmployee().getLastName(),
                        badge.getAssignedEmployee().getDepartment()
                )
        );
    }
}
