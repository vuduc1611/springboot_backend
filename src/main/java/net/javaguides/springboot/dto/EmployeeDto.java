package net.javaguides.springboot.dto;

import lombok.Data;

@Data
public class EmployeeDto {
    private Long empId;
    private String fname;
    private String lname;
    private Boolean gender;
    private int age;
    private String contactAdd;
    private String empEmail;
    private String empPass;
    private Long roleId;
    private Long positionId;
    private String qualToStr;
    //OK

}
