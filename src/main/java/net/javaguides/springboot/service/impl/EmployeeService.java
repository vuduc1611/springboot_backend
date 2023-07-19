package net.javaguides.springboot.service.impl;

import net.javaguides.springboot.dto.EmployeeDto;
import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Custom.CustomEmployee;
import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.model.Qualification;
import net.javaguides.springboot.repository.EmployeeRepository;
import net.javaguides.springboot.repository.PositionRepository;
import net.javaguides.springboot.repository.QualificationRepository;
import net.javaguides.springboot.repository.RoleRepository;
import net.javaguides.springboot.service.iEmployeeService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService implements iEmployeeService {
    private EmployeeRepository employeeRepository;
    private RoleRepository roleRepository;
    private PositionRepository positionRepository;
    private QualificationRepository qualificationRepository;

    public EmployeeService(EmployeeRepository employeeRepository,
                           RoleRepository roleRepository,
                           PositionRepository positionRepository,
                           QualificationRepository qualificationRepository) {

        super();
        this.employeeRepository = employeeRepository;
        this.roleRepository = roleRepository;
        this.positionRepository = positionRepository;
        this.qualificationRepository = qualificationRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findOne(Long id) {
        return employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee", "Id", id));
    }

    @Override
    public Employee create(EmployeeDto employeeDto) {
        if (employeeDto.getRoleId() == null && employeeDto.getPositionId() == null && employeeDto.getQualToStr() == null) {
            throw new Error("Re-check: roleId, positionId and qualification are mandatory");
        }
        roleRepository.findById(employeeDto.getRoleId()).orElseThrow(()->
                new ResourceNotFoundException("Role", "Id",employeeDto.getRoleId()));
        positionRepository.findById(employeeDto.getPositionId()).orElseThrow(()->
                new ResourceNotFoundException("Position", "Id",employeeDto.getPositionId()));
        Employee employee = new Employee();

        employee.setFname(employeeDto.getFname());
        employee.setLname(employeeDto.getLname());
        employee.setGender(employeeDto.getGender());
        employee.setAge(employeeDto.getAge());
        employee.setContactAdd(employeeDto.getContactAdd());
        employee.setEmpEmail(employeeDto.getEmpEmail());
        employee.setEmpPass(employeeDto.getEmpPass());

        employee.setRole(roleRepository.findById(employeeDto.getRoleId()).orElseThrow(()->
                new ResourceNotFoundException("Role", "Id",employeeDto.getRoleId())));
        employee.setPosition(positionRepository.findById(employeeDto.getPositionId()).orElseThrow(()->
                new ResourceNotFoundException("Position", "Id",employeeDto.getPositionId())));

        Set<Qualification> qualifications = new HashSet<>();
        String[] qualIdStrParts= employeeDto.getQualToStr().split(",");
        List<String> qualIdList = Arrays.asList(qualIdStrParts);
        for(String qualId : qualIdList) qualifications.add(qualificationRepository.findById(Long.valueOf(qualId)).orElseThrow(()->
                new ResourceNotFoundException("Qualification", "Id", qualId)));
        employee.setQualifications(qualifications);

        return employeeRepository.save(employee);
    }

    @Override
    public Employee update(EmployeeDto employeeDto) {


        Employee existingEmployee = employeeRepository.findById(employeeDto.getEmpId()).orElseThrow(
                () -> new ResourceNotFoundException("Employee", "Id", employeeDto.getEmpId()));
        existingEmployee.setFname(employeeDto.getFname());
        existingEmployee.setLname(employeeDto.getLname());
        existingEmployee.setGender(employeeDto.getGender());
        existingEmployee.setAge(employeeDto.getAge());
        existingEmployee.setContactAdd(employeeDto.getContactAdd());
        existingEmployee.setEmpEmail(employeeDto.getEmpEmail());
        existingEmployee.setEmpPass(employeeDto.getEmpPass());

        existingEmployee.setRole(roleRepository.findById(employeeDto.getRoleId()).orElseThrow(()->
                new ResourceNotFoundException("Role", "Id",employeeDto.getRoleId())));
        existingEmployee.setPosition(positionRepository.findById(employeeDto.getPositionId()).orElseThrow(()->
                new ResourceNotFoundException("Position", "Id",employeeDto.getPositionId())));

        Set<Qualification> qualifications = new HashSet<>();
        String[] qualIdStrParts= employeeDto.getQualToStr().split(",");
        List<String> qualIdList = Arrays.asList(qualIdStrParts);
        for(String qualId : qualIdList) qualifications.add(qualificationRepository.findById(Long.valueOf(qualId)).orElseThrow(()->
                new ResourceNotFoundException("Qualification", "Id", qualId)));
        existingEmployee.setQualifications(qualifications);

        return employeeRepository.save(existingEmployee);
    }

    @Override
    public void delete(Long id) {
        employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee", "Id", id));
        employeeRepository.deleteById(id);
    }

    @Override
    public List<CustomEmployee> findEmployeesByDepartment(Long id) {
        List<CustomEmployee> customEmployees = new ArrayList<>();

        employeeRepository.findEmployeeByRole(id).forEach(e -> {
            CustomEmployee ce = new CustomEmployee();
            ce.setId(e.getEmpId());
            ce.setLname(e.getLname());
            ce.setFname(e.getFname());
            ce.setAge(e.getAge());
            ce.setGender(e.getGender());
            ce.setEmail(e.getEmpEmail());
            customEmployees.add(ce);
        });
        return customEmployees;
    }
    @Override
    public List<CustomEmployee> findEmployeeByPosition(Long id) {
        List<CustomEmployee> customEmployees = new ArrayList<>();
        employeeRepository.findEmployeeByPosition(id).forEach(e -> {
            CustomEmployee ce = new CustomEmployee();
            ce.setId(e.getEmpId());
            ce.setLname(e.getLname());
            ce.setFname(e.getFname());
            ce.setAge(e.getAge());
            ce.setGender(e.getGender());
            ce.setEmail(e.getEmpEmail());
            customEmployees.add(ce);
        });
        return customEmployees;
    }
}
