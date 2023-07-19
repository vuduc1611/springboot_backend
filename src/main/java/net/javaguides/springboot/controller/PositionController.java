package net.javaguides.springboot.controller;

import net.javaguides.springboot.dto.PositionDto;
import net.javaguides.springboot.model.Custom.CustomEmployee;
import net.javaguides.springboot.model.Position;
import net.javaguides.springboot.service.impl.PositionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/positions")
public class PositionController {
    private PositionService positionService;

    public PositionController(PositionService positionService) {
        super();
        this.positionService = positionService;
    }

    @GetMapping("")
    public List<Position> getAll(){
        return positionService.findAll();
    }


    @GetMapping("{id}")
    public ResponseEntity<Position> getOne(@PathVariable("id") long id){
        return new ResponseEntity<Position>(positionService.findOne(id), HttpStatus.OK);
    }


    @PostMapping("")
    public ResponseEntity<Position> create(@RequestBody PositionDto positionDto){
        return new ResponseEntity<Position>(positionService.create(positionDto), HttpStatus.CREATED);
    }

    @PutMapping("")
    public ResponseEntity<Position> update(@RequestBody PositionDto positionDto){
        return new ResponseEntity<Position>(positionService.update(positionDto), HttpStatus.OK);
    }



    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable("id") long id){
        positionService.delete(id);
        return new ResponseEntity<String>("Posistion id  deleted successfully!.", HttpStatus.OK);
    }


    //ok
}
