package org.example.backend.Service;

import org.example.backend.Dto.EmployeeDto;
import org.example.backend.Entity.Employee;
import org.example.backend.Exception.ResourceNotFoundException;
import org.example.backend.Mapper.EmployeeMapper;
import org.example.backend.Repository.EmployeeRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepo.findById(employeeId)
                .orElseThrow(
                ()-> new ResourceNotFoundException("employee is not exist with given id : "+employeeId)
        );
        return EmployeeMapper.toDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
         List<Employee> employees = employeeRepo.findAll();
        return employees.stream().map((employee)-> EmployeeMapper.toDto(employee))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
        Employee employee = employeeRepo.findById(employeeId)
                .orElseThrow(
                        ()-> new ResourceNotFoundException("employee is not exist with given id : "+employeeId));
        employee.setFirstname(updatedEmployee.getFirstname());
        employee.setLastname(updatedEmployee.getLastname());
        employee.setEmail(updatedEmployee.getEmail());
        Employee employeeSavedUpdate =  employeeRepo.save(employee);

        return EmployeeMapper.toDto(employeeSavedUpdate);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee = employeeRepo.findById(employeeId)
                .orElseThrow(
                        ()-> new ResourceNotFoundException("employee is not exist with given id : "+employeeId)
                );
        employeeRepo.delete(employee);

    }

}
