package net.javaguides.springboot.service.impl;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Department;
import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.repository.DepartmentRepository;
import net.javaguides.springboot.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        super();
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(long id) {
        return departmentRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Department", "Id", id));
    }

    @Override
    public Department updateDepartment(Department department, long id) {
        Department existingDepartment = departmentRepository.findById(id).orElseThrow(()->
            new ResourceNotFoundException("Department", "Id", id));
//        existingDepartment.setId(id);
        existingDepartment.setName(department.getName());
        departmentRepository.save(existingDepartment);
        return existingDepartment;
    }

    @Override
    public void deleteDepartment(long id) {
        departmentRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Department", "Id", id));
        departmentRepository.deleteById(id);
    }



    // chua viet dc
    @Override
    public List<Employee> getEmployeesByDepartmentId(long id) {
        return null;
    }
}
