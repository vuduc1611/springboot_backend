package net.javaguides.springboot.service;

import net.javaguides.springboot.dto.QualificationDto;
import net.javaguides.springboot.model.Qualification;

import java.util.List;

public interface iQualificationService {

    List<Qualification> findAll();
    Qualification findOne(Long id);
    Qualification create(QualificationDto qualificationDto);
    Qualification update(QualificationDto qualificationDto);
    void delete(Long id);
}
