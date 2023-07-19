package net.javaguides.springboot.service;

import net.javaguides.springboot.dto.DepartmentDto;
import net.javaguides.springboot.dto.RoleDto;
import net.javaguides.springboot.model.Department;
import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.model.Role;

import java.util.List;
import java.util.Set;

public interface iDepartmentService {
    List<Department> findAll();
    Department create(DepartmentDto departmentDto);
    Department update(DepartmentDto departmentDto);
    void delete(Long id);

}
