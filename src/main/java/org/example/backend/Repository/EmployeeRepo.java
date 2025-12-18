package org.example.backend.Repository;

import org.example.backend.Dto.EmployeeDto;
import org.example.backend.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    Employee save(Employee employee);
}
