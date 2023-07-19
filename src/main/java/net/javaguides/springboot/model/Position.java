package net.javaguides.springboot.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "position")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "position_id")
    private Long positionId;

    @Column(name = "name")
    private String name;

    @Column(name = "salary_bonus")
    private Double salaryBonus;
}
