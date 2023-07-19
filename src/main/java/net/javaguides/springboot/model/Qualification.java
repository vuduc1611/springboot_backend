package net.javaguides.springboot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table (name = "qualification")
public class Qualification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "qual_id")
    private Long qualId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

}
