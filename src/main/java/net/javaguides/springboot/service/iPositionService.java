package net.javaguides.springboot.service;

import net.javaguides.springboot.dto.PositionDto;
import net.javaguides.springboot.dto.QualificationDto;
import net.javaguides.springboot.model.Custom.CustomEmployee;
import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.model.Position;
import net.javaguides.springboot.model.Qualification;

import java.util.List;
import java.util.Set;

public interface iPositionService {
    List<Position> findAll();
    Position findOne(Long id);
    Position create(PositionDto positionDto);
    Position update(PositionDto positionDto);
    void delete(Long id);
}
