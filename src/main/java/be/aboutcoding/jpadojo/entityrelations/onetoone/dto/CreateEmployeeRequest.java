package be.aboutcoding.jpadojo.entityrelations.onetoone.dto;

public record CreateEmployeeRequest(
        String firstName,
        String lastName,
        String department,
        BadgeRequest currentBadge // Can be null if employee has no badge
) {

    // Inner record for badge data without ID
    public record BadgeRequest(
            String badgeNumber,
            String accessLevel,
            String issueDate
    ) {
    }
}
