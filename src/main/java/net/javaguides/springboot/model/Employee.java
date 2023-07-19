package net.javaguides.springboot.model;

import javax.persistence.*;

import lombok.Data;

import java.util.*;


@Data
@Entity
@Table (name = "employee")
public class Employee {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private Long empId;

    @Column(name = "fname")
    private String fname;

    @Column(name = "lname")
    private String lname;

    @Column(name = "gender")
    private Boolean gender;

    @Column(name = "age")
    private int age;

    @Column(name = "contact_add")
    private String contactAdd;

    @Column(name = "emp_email")
    private String empEmail;

    @Column(name = "emp_pass")
    private String empPass;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private Role role;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "position_id")
    private Position position;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "empl_qual",
            joinColumns = @JoinColumn(name = "emp_id"),
            inverseJoinColumns = @JoinColumn(name = "qual_id"))
    private Set<Qualification> qualifications;


}
