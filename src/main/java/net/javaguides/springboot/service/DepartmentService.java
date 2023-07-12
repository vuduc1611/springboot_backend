package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Department;
import net.javaguides.springboot.model.Employee;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);
    List<Department> getAllDepartments();
    Department getDepartmentById(long id);
    Department  updateDepartment(Department department, long id);
    void deleteDepartment(long id);
    List<Employee> getEmployeesByDepartmentId(long id);
}
