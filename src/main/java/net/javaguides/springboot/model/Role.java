package net.javaguides.springboot.model;

import lombok.Data;
import javax.persistence.*;



@Data
@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "salary_role")
    private Double salaryRole;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dept_id")
    private Department department;

}

