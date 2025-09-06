package be.aboutcoding.jpadojo.entityrelations.onetoone.dto;


import be.aboutcoding.jpadojo.entityrelations.onetoone.domain.Car;
import be.aboutcoding.jpadojo.entityrelations.onetoone.domain.Person;

public record PersonsResponse(
        Long id,
        String firstName,
        String lastName,
        String department,
        Car currentCar
) {

    // Factory method to create from Person entity
    public static PersonsResponse from(Person person) {
        return new PersonsResponse(
                person.getId(),
                person.getFirstName(),
                person.getLastName(),
                person.getDepartment(),
                person.getCurrentCar()
        );
    }
}