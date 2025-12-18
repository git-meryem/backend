package org.example.backend.Service;

import org.example.backend.Dto.EmployeeDto;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {
    EmployeeDto create(EmployeeDto employeeDto);
}
