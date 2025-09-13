package be.aboutcoding.jpadojo.entityrelations.onetomany.domain.school;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Child {

    private Long id;

    private String firstName;

    private String lastName;

    private int age;

    private String studentNumber;

}
