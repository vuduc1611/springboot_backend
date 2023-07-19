package net.javaguides.springboot.controller;

import net.javaguides.springboot.dto.EmployeeDto;
import net.javaguides.springboot.model.Custom.CustomEmployee;
import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.service.impl.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        super();
        this.employeeService = employeeService;
    }

    // build get all employees REST API
    @GetMapping("")
    public List<Employee> getAllEmployees(){
        return employeeService.findAll();
    }

    // build get employee by id REST API
    // http://localhost:8080/api/employees/1
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long employeeId){
        return new ResponseEntity<Employee>(employeeService.findOne(employeeId), HttpStatus.OK);
    }

    // build create employee REST API
    @PostMapping("")
    public ResponseEntity<Employee> createEmployee(@RequestBody EmployeeDto employeeDto){
        return new ResponseEntity<Employee>(employeeService.create(employeeDto), HttpStatus.CREATED);
    }

    // build update employee REST API
    // http://localhost:8080/api/employees/1
    @PutMapping("")
    public ResponseEntity<Employee> updateEmployee(@RequestBody EmployeeDto employeeDto){
        return new ResponseEntity<Employee>(employeeService.update(employeeDto), HttpStatus.OK);
    }

    @GetMapping("/department/{id}")
    public ResponseEntity<List<CustomEmployee>> getEmpByDepartment(@PathVariable("id") long id) {
        return new ResponseEntity<List<CustomEmployee>>(employeeService.findEmployeesByDepartment(id), HttpStatus.OK);
    }

    @GetMapping("/positions/{id}")
    public ResponseEntity<List<CustomEmployee>> findEmployeeByPosition(@PathVariable("id") long id) {
        return new ResponseEntity<List<CustomEmployee>>(employeeService.findEmployeeByPosition(id), HttpStatus.OK);
    }



    // build delete employee REST API
    // http://localhost:8080/api/employees/1
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id){
        employeeService.delete(id);
        return new ResponseEntity<String>("Employee deleted successfully!.", HttpStatus.OK);
    }
}
