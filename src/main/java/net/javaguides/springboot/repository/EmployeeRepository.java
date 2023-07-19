package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    @Query(value = "SELECT e FROM Employee e WHERE e.role.department.departmentId = :id")
    List<Employee> findEmployeeByRole(@Param("id") Long id);


    @Query("SELECT e FROM Employee e WHERE e.position.positionId = :id")
    List<Employee> findEmployeeByPosition(@Param("id") Long id);
}