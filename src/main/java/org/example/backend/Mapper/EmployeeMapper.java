package org.example.backend.Mapper;

import org.example.backend.Dto.EmployeeDto;
import org.example.backend.Entity.Employee;

public class EmployeeMapper {
    //Entity --> Dto

     public static EmployeeDto toDto(Employee employee){
         EmployeeDto e = new EmployeeDto();
         e.setId(employee.getId());
         e.setFirstname(employee.getFirstname());
         e.setLastname(employee.getLastname());
         e.setEmail(employee.getEmail());
         return e;
     }

    //Dto --> Entity

    public static Employee toEntity(EmployeeDto employeeDto){
         Employee e = new Employee();
         e.setId(employeeDto.getId());
         e.setFirstname(employeeDto.getFirstname());
         e.setLastname(employeeDto.getLastname());
         e.setEmail(employeeDto.getEmail());
         return e;
    }
}
