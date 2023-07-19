package net.javaguides.springboot.controller;

import net.javaguides.springboot.dto.QualificationDto;
import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.model.Qualification;
import net.javaguides.springboot.service.impl.QualificationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/qualifications")
public class QualificationController {
    private QualificationService qualificationService;

    public QualificationController(QualificationService qualificationService) {
        super();
        this.qualificationService = qualificationService;
    }

    @GetMapping("")
    public List<Qualification> getAll(){
        return qualificationService.findAll();
    }


    @GetMapping("{id}")
    public ResponseEntity<Qualification> getOne(@PathVariable("id") long id){
        return new ResponseEntity<Qualification>(qualificationService.findOne(id), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Qualification> create(@RequestBody QualificationDto qualificationDto){


        return new ResponseEntity<Qualification>(qualificationService.create(qualificationDto), HttpStatus.CREATED);
    }

    @PutMapping("")
    public ResponseEntity<Qualification> update(@RequestBody QualificationDto qualificationDto){
        return new ResponseEntity<Qualification>(qualificationService.update(qualificationDto), HttpStatus.OK);
    }



    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable("id") long id){
        qualificationService.delete(id);
        return new ResponseEntity<String>("Qualification deleted successfully!.", HttpStatus.OK);
    }
}
