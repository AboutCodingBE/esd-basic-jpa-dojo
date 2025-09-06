package be.aboutcoding.jpadojo.entityrelations.onetoone.dto;


import be.aboutcoding.jpadojo.entityrelations.onetoone.domain.Car;

public record CreatePersonRequest(
        Long id, // Optional: for updates, null for new persons
        String firstName,
        String lastName,
        String department,
        Car currentCar
) {
}
