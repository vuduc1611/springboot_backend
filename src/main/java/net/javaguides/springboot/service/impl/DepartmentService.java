package net.javaguides.springboot.service.impl;

import net.javaguides.springboot.dto.DepartmentDto;
import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Department;
import net.javaguides.springboot.model.Role;
import net.javaguides.springboot.repository.DepartmentRepository;
import net.javaguides.springboot.repository.RoleRepository;
import net.javaguides.springboot.service.iDepartmentService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartmentService implements iDepartmentService {
    private DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        super();
        this.departmentRepository = departmentRepository;
    }

    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }


    @Override
    public Department create(DepartmentDto departmentDto) {
//        Set<Role> roles= new HashSet<>();
//        String[] rolesIdStrParts= departmentDto.getRolesToStr().split(",");
//
//        List<String> roleIdList = Arrays.asList(rolesIdStrParts);
//        roleIdList.forEach(empId -> roles.add(roleRepository.findById(Long.valueOf(empId)).get()));
        Department department = new Department();
        department.setName(departmentDto.getName());
        department.setDescription(departmentDto.getDescription());
        return departmentRepository.save(department);
    }

    @Override
    public Department update(DepartmentDto departmentDto) {
        if(departmentDto.getDept_id() == null) {
            throw new RuntimeException("Department Id is mandatory");
        }
        Department existingDept = departmentRepository.findById(departmentDto.getDept_id()).orElseThrow(
                () -> new ResourceNotFoundException("Department", "Id", departmentDto.getDept_id()));

        existingDept.setName(departmentDto.getName());
        existingDept.setDescription(departmentDto.getDescription());

//        Set<Role> roles= new HashSet<>();
//        String[] rolesIdStrParts= departmentDto.getRolesToStr().split(",");
//        List<String> rolesIdList = Arrays.asList(rolesIdStrParts);
//        for(String roleId : rolesIdList) roles.add(roleRepository.findById(Long.valueOf(roleId)).orElseThrow(()->
//                new ResourceNotFoundException("Role", "Id", roleId)));
//        existingDept.setRoles(roles);
        return departmentRepository.save(existingDept);
    }

    @Override
    public void delete(Long id) {
        departmentRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Department", "Id", id));
        departmentRepository.deleteById(id);
    }
}
