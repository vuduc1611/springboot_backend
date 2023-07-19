package net.javaguides.springboot.controller;

import net.javaguides.springboot.dto.DepartmentDto;
import net.javaguides.springboot.dto.RoleDto;
import net.javaguides.springboot.model.Department;
import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.model.Role;
import net.javaguides.springboot.service.impl.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        super();
        this.departmentService = departmentService;
    }

    @GetMapping("")
    public List<Department> getAll(){
        return departmentService.findAll();
    }


//    @GetMapping("/get-roles/{id}")
//    public ResponseEntity<Set<Role>> getListRoleInDept(@PathVariable("id") long id) {
//        return new ResponseEntity<Set<Role>>(departmentService.findRolesByDeptId(id), HttpStatus.OK);
//    }
    @PostMapping("")
    public ResponseEntity<Department> create(@RequestBody DepartmentDto departmentDto){
        return new ResponseEntity<Department>(departmentService.create(departmentDto), HttpStatus.CREATED);
    }


    @PutMapping("")
    public ResponseEntity<Department> update(@RequestBody DepartmentDto departmentDto){
        return new ResponseEntity<Department>(departmentService.update(departmentDto), HttpStatus.OK);
    }



    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable("id") long id){
        departmentService.delete(id);
        return new ResponseEntity<String>("Department deleted successfully!.", HttpStatus.OK);
    }
    //ok
}
