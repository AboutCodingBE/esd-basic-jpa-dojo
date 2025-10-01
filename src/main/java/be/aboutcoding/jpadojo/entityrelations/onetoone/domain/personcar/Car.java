package be.aboutcoding.jpadojo.entityrelations.onetoone.domain.personcar;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "make")
    private String make;

    @Column(name = "model")
    private String model;

    @Column(name = "number_plate")
    private String numberPlate;

    public Car() {
    }
}
