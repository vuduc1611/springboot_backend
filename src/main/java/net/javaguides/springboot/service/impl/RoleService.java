package net.javaguides.springboot.service.impl;

import net.javaguides.springboot.dto.RoleDto;
import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Department;
import net.javaguides.springboot.model.Role;
import net.javaguides.springboot.repository.DepartmentRepository;
import net.javaguides.springboot.repository.EmployeeRepository;
import net.javaguides.springboot.repository.RoleRepository;
import net.javaguides.springboot.service.iRoleService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RoleService implements iRoleService {

    private RoleRepository roleRepository;
    private EmployeeRepository employeeRepository;
    private DepartmentRepository departmentRepository;

    public RoleService(RoleRepository roleRepository, EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        super();
        this.departmentRepository = departmentRepository;
        this.roleRepository = roleRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role findOne(Long id) {
        return roleRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Role", "Id", id));
    }

//    @Override
//    public Set<Employee> findEmployeesByRoleId(long id) {
//        Role existingRole =  roleRepository.findById(id).orElseThrow(()->
//                new ResourceNotFoundException("Role", "Id", id));
//        return  existingRole.getEmployees();
//    }

    @Override
    public Role create(RoleDto roleDto) {
        Department department = departmentRepository.findById(roleDto.getDepartmentId()).orElseThrow(()->
                new ResourceNotFoundException("Department", "Id", roleDto.getDepartmentId()));
        Role newRole = new Role();
        newRole.setName(roleDto.getName());
        newRole.setSalaryRole(roleDto.getSalaryRole());
        newRole.setDepartment(department);
        return roleRepository.save(newRole);
    }

    @Override
    public Role update(RoleDto roleDto) {
        if(roleDto.getRoleId() == null) {
            throw new RuntimeException("Role Id is not found");
        }
        Role existingRole = roleRepository.findById(roleDto.getRoleId()).orElseThrow(
                () -> new ResourceNotFoundException("Role", "Id", roleDto.getRoleId()));
        Department department = departmentRepository.findById(roleDto.getDepartmentId()).orElseThrow(()->
                new ResourceNotFoundException("Department", "Id", roleDto.getDepartmentId()));

        existingRole.setId(roleDto.getRoleId());
        existingRole.setName(roleDto.getName());
        existingRole.setSalaryRole(roleDto.getSalaryRole());
        existingRole.setDepartment(department);

//        Set<Employee> employees= new HashSet<>();
//        String[] empIdStrParts= roleDto.getEmplToStr().split(",");
//        List<String> empIdList = Arrays.asList(empIdStrParts);
//        for(String empId : empIdList) employees.add(employeeRepository.findById(Long.valueOf(empId)).orElseThrow(()->
//                new ResourceNotFoundException("Employ", "Id", empId)));
//        existingRole.setEmployees(employees);
        return roleRepository.save(existingRole);


    }

    @Override
    public void delete(Long id) {
        roleRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Role", "Id", id));
        roleRepository.deleteById(id);
    }
    // OK
}
