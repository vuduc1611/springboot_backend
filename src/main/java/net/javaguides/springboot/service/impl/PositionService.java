package net.javaguides.springboot.service.impl;

import net.javaguides.springboot.dto.PositionDto;
import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Custom.CustomEmployee;
import net.javaguides.springboot.model.Department;
import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.model.Position;
import net.javaguides.springboot.model.Role;
import net.javaguides.springboot.repository.DepartmentRepository;
import net.javaguides.springboot.repository.EmployeeRepository;
import net.javaguides.springboot.repository.PositionRepository;
import net.javaguides.springboot.service.iPositionService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PositionService implements iPositionService {
    private PositionRepository positionRepository;
    private EmployeeRepository employeeRepository;

    public PositionService(PositionRepository positionRepository, EmployeeRepository employeeRepository) {
        super();
        this.positionRepository = positionRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Position> findAll() {
        return positionRepository.findAll();
    }

    @Override
    public Position findOne(Long id) {
        return positionRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Position", "Id", id));
    }


    @Override
    public Position create(PositionDto positionDto) {
        Position position = new Position();
        position.setName(positionDto.getName());
        position.setSalaryBonus(positionDto.getSalaryBonus());
        return positionRepository.save(position);
    }

    @Override
    public Position update(PositionDto positionDto) {
        if(positionDto.getPosId() == null) {
            throw new RuntimeException("Position Id is not found");
        }
        Position existingPos = positionRepository.findById(positionDto.getPosId()).orElseThrow(
                () -> new ResourceNotFoundException("Position", "Id", positionDto.getPosId()));

        existingPos.setName(positionDto.getName());
        existingPos.setSalaryBonus(positionDto.getSalaryBonus());
        return positionRepository.save(existingPos);
    }

    @Override
    public void delete(Long id) {
        positionRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Position", "Id", id));
        positionRepository.deleteById(id);
    }


}
