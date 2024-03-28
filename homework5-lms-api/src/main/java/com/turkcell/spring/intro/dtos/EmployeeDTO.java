package com.turkcell.spring.intro.dtos;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    private String name;
    private String email;
    private String phoneNumber;
}
