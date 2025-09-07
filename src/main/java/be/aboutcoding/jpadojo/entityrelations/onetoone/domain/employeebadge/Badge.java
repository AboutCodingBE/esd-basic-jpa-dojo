package be.aboutcoding.jpadojo.entityrelations.onetoone.domain.employeebadge;

import lombok.Getter;

@Getter
public class Badge {

    private Long id;

    private String badgeNumber;

    private String accessLevel;

    private String issueDate;

    private Employee assignedEmployee;
}