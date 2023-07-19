package net.javaguides.springboot.service;

import net.javaguides.springboot.dto.EmployeeDto;
import net.javaguides.springboot.model.Custom.CustomEmployee;
import net.javaguides.springboot.model.Employee;

import java.util.List;

public interface iEmployeeService {
    List<Employee> findAll();
    Employee findOne(Long id);
    Employee create(EmployeeDto employeeDto);
    Employee update(EmployeeDto employeeDto);
    void delete(Long id);
    List<CustomEmployee> findEmployeesByDepartment(Long id);
    List<CustomEmployee> findEmployeeByPosition(Long id);
}
