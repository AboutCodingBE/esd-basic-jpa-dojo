package be.aboutcoding.jpadojo.entityrelations.onetoone.domain.employeebadge;

import lombok.Getter;

@Getter
public class Employee {

    private Long id;

    private String firstName;

    private String lastName;

    private String department;

    private Badge currentBadge;
}
