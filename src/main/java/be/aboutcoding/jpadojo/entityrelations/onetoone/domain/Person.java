package be.aboutcoding.jpadojo.entityrelations.onetoone.domain;

import lombok.Getter;

@Getter
public class Person {

    private Long id;

    private String firstName;

    private String lastName;

    private String department;

    private Car currentCar;
}
