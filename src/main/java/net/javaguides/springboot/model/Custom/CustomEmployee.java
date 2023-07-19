package net.javaguides.springboot.model.Custom;

import lombok.Data;

@Data
public class CustomEmployee {
    private Long id;
    private String fname;
    private String lname;
    private int age;
    private boolean gender;
    private String email;
}
