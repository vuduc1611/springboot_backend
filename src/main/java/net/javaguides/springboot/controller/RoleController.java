package net.javaguides.springboot.controller;

import net.javaguides.springboot.dto.RoleDto;
import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.model.Role;
import net.javaguides.springboot.service.impl.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/roles")
public class RoleController
{
    private RoleService roleService;

    public RoleController(RoleService roleService) {
        super();
        this.roleService = roleService;
    }
    // build get all employees REST API
    @GetMapping("")
    public List<Role> getAll(){
        return roleService.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Role> getOne(@PathVariable("id") long id){
        return new ResponseEntity<Role>(roleService.findOne(id), HttpStatus.OK);
    }

//    @GetMapping("/get-employees/{id}")
//    public ResponseEntity<Set<Employee>> getListEmpInRole(@PathVariable("id") long id) {
//        return new ResponseEntity<Set<Employee>>(roleService.findEmployeesByRoleId(id), HttpStatus.OK);
//    }
    @PostMapping("")
    public ResponseEntity<Role> create(@RequestBody RoleDto roleDto){
        return new ResponseEntity<Role>(roleService.create(roleDto), HttpStatus.CREATED);
    }


    @PutMapping("")
    public ResponseEntity<Role> update(@RequestBody RoleDto roleDto){
        return new ResponseEntity<Role>(roleService.update(roleDto), HttpStatus.OK);
    }



    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable("id") long id){
        roleService.delete(id);
        return new ResponseEntity<String>("Employee deleted successfully!.", HttpStatus.OK);
    }
    // ok
}
