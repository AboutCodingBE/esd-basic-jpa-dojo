package be.aboutcoding.jpadojo.entityrelations.onetoone.dto;

import be.aboutcoding.jpadojo.entityrelations.onetoone.domain.employeebadge.Employee;

public record EmployeeResponse(
        Long id,
        String firstName,
        String lastName,
        String department,
        BadgeResponse currentBadge
) {

    public record BadgeResponse(
            String badgeNumber,
            String accessLevel,
            String issueDate
    ) {}

    // Factory method to create from Employee entity
    public static EmployeeResponse from(Employee employee) {
        return new EmployeeResponse(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getDepartment(),
                new BadgeResponse(
                        employee.getCurrentBadge().getBadgeNumber(),
                        employee.getCurrentBadge().getAccessLevel(),
                        employee.getCurrentBadge().getIssueDate())
                );
    }
}