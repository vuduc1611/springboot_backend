package net.javaguides.springboot.controller;

import net.javaguides.springboot.model.Department;
import net.javaguides.springboot.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController
{
    //
    private DepartmentService departmentService;
    public DepartmentController(DepartmentService departmentService) {
        super();
        this.departmentService = departmentService;
    }
    @PostMapping("")
    public ResponseEntity<Department> saveDepartment(@RequestBody Department department) {
        return new ResponseEntity<Department>(departmentService.saveDepartment(department), HttpStatus.CREATED);
    }
    @GetMapping("")
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable("id") long departmentId) {
        return new ResponseEntity<Department>(departmentService.getDepartmentById(departmentId), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable("id") long departmentId, @RequestBody Department department) {
        return new ResponseEntity<Department>(departmentService.updateDepartment(department, departmentId), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable("id") long departmentId) {
        departmentService.deleteDepartment(departmentId);
        return new ResponseEntity<String>("Department deleted successfully", HttpStatus.OK);
    }

}
