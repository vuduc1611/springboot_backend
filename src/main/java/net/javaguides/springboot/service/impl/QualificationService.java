package net.javaguides.springboot.service.impl;

import net.javaguides.springboot.dto.QualificationDto;
import net.javaguides.springboot.exception.ResourceNotFoundException;

import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.model.Qualification;
import net.javaguides.springboot.repository.EmployeeRepository;
import net.javaguides.springboot.repository.QualificationRepository;
import net.javaguides.springboot.service.iQualificationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QualificationService implements iQualificationService {

    private QualificationRepository qualificationRepository;

    public QualificationService(QualificationRepository qualificationRepository) {
        super();
        this.qualificationRepository = qualificationRepository;
    }

    @Override
    public List<Qualification> findAll() {
        return qualificationRepository.findAll();
    }

    @Override
    public Qualification findOne(Long id) {
        return qualificationRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Qualification", "Id", id));
    }

    @Override
    public Qualification create(QualificationDto qualificationDto) {
            if(qualificationDto.getName() == null ) {
                throw new Error("Flied Name is mandatory");
            }
            Qualification qualification = new Qualification();
            qualification.setName(qualificationDto.getName());
            qualification.setDescription(qualificationDto.getDescription());
        return qualificationRepository.save(qualification);
    }

    @Override
    public Qualification update(QualificationDto qualificationDto) {
        Qualification existingQual = qualificationRepository.findById(qualificationDto.getQualId()).orElseThrow(()->
                new ResourceNotFoundException("Qualification", "Id", qualificationDto.getQualId()));

        if(qualificationDto.getName() == null) {
            throw new Error("Flied name is mandatory");
        }
        existingQual.setQualId(qualificationDto.getQualId());
        existingQual.setName(qualificationDto.getName());
        existingQual.setDescription(qualificationDto.getDescription());
        return qualificationRepository.save(existingQual);
    }

    @Override
    public void delete(Long id) {

        qualificationRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Qualification", "Id", id));
        qualificationRepository.deleteById(id);
    }
}
