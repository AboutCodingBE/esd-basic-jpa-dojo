package be.aboutcoding.jpadojo.entityrelations;


import be.aboutcoding.jpadojo.entityrelations.onetoone.domain.employeebadge.Badge;
import be.aboutcoding.jpadojo.entityrelations.onetoone.domain.employeebadge.Employee;
import be.aboutcoding.jpadojo.entityrelations.onetoone.dto.BadgeResponse;
import be.aboutcoding.jpadojo.entityrelations.onetoone.dto.CreateEmployeeRequest;
import be.aboutcoding.jpadojo.entityrelations.onetoone.dto.EmployeeResponse;
import be.aboutcoding.jpadojo.entityrelations.onetoone.repository.BadgeRepository;
import be.aboutcoding.jpadojo.entityrelations.onetoone.repository.EmployeeRepository;
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
    private final EmployeeRepository employeeRepository;

    @Autowired
    private final BadgeRepository badgeRepository;

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
