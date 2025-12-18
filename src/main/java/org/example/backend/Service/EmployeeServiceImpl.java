package org.example.backend.Service;

import org.example.backend.Dto.EmployeeDto;
import org.example.backend.Entity.Employee;
import org.example.backend.Mapper.EmployeeMapper;
import org.example.backend.Repository.EmployeeRepo;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeRepo employeeRepo;

    public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public EmployeeDto create(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.toEntity(employeeDto);
        Employee employeeSaved = employeeRepo.save(employee);
        return EmployeeMapper.toDto(employeeSaved);
    }
}
