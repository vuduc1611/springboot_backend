package net.javaguides.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoleDto {
    private Long roleId;
    private String name;
    private Double salaryRole;
    private Long departmentId;

    //OK

}
