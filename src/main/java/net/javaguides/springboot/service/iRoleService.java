package net.javaguides.springboot.service;

import net.javaguides.springboot.dto.RoleDto;
import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.model.Role;

import java.util.List;
import java.util.Set;

public interface iRoleService {
    List<Role> findAll();
    Role findOne(Long id);
    Role create(RoleDto roleDto);
    Role update(RoleDto roleDto);
    void delete(Long id);
    //OK
}
