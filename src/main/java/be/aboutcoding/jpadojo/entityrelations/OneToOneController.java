package be.aboutcoding.jpadojo.entityrelations;


import be.aboutcoding.jpadojo.entityrelations.onetoone.domain.employeebadge.Badge;
import be.aboutcoding.jpadojo.entityrelations.onetoone.domain.employeebadge.Employee;
import be.aboutcoding.jpadojo.entityrelations.onetoone.domain.personcar.Person;
import be.aboutcoding.jpadojo.entityrelations.onetoone.dto.BadgeResponse;
import be.aboutcoding.jpadojo.entityrelations.onetoone.dto.CreateEmployeeRequest;
import be.aboutcoding.jpadojo.entityrelations.onetoone.dto.EmployeeResponse;
import be.aboutcoding.jpadojo.entityrelations.onetoone.repository.BadgeRepository;
import be.aboutcoding.jpadojo.entityrelations.onetoone.repository.EmployeeRepository;
import be.aboutcoding.jpadojo.entityrelations.onetoone.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jpa/training/onetoone")
public class OneToOneController {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private BadgeRepository badgeRepository;


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

    @GetMapping("/employee")
    public ResponseEntity<List<EmployeeResponse>> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeResponse> response = employees.stream()
                .map(EmployeeResponse::from)
                .toList();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/employee")
    public ResponseEntity<EmployeeResponse> createOrUpdateEmployee(@RequestBody CreateEmployeeRequest request) {
        // Convert DTO to entity
        Employee employee = convertToEntity(request);

        // Save entity
        Employee savedEmployee = employeeRepository.save(employee);

        // Convert back to response DTO
        EmployeeResponse response = EmployeeResponse.from(savedEmployee);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/badge")
    public ResponseEntity<List<BadgeResponse>> getAllBadges() {
        List<Badge> badges = badgeRepository.findAll();
        List<BadgeResponse> response = badges.stream()
                .map(BadgeResponse::from)
                .toList();
        return ResponseEntity.ok(response);
    }

    private Employee convertToEntity(CreateEmployeeRequest request) {
        Employee employee = new Employee();
        // TODO: fill this in
        return employee;
    }
}
