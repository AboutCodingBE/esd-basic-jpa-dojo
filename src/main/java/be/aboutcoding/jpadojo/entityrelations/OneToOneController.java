package be.aboutcoding.jpadojo.entityrelations;


import be.aboutcoding.jpadojo.entityrelations.onetoone.domain.personcar.Person;
import be.aboutcoding.jpadojo.entityrelations.onetoone.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jpa/training/onetoone")
@RequiredArgsConstructor
public class OneToOneController {

    @Autowired
    private final PersonRepository personRepository;


    @GetMapping("/person")
    public ResponseEntity<List<Person>> getAllPersons() {
        List<Person> persons = personRepository.findAll();
        return ResponseEntity.ok(persons);
    }

    @PutMapping("/person")
    public ResponseEntity<Person> createOrUpdatePerson(@RequestBody Person person) {
        Person savedPerson = personRepository.save(person);
        return ResponseEntity.ok(savedPerson);
    }
}
