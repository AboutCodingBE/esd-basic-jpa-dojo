package be.aboutcoding.jpadojo.entityrelations.onetoone.repository;

import be.aboutcoding.jpadojo.entityrelations.onetoone.domain.employeebadge.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
