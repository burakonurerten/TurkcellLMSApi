package com.turkcell.spring.intro.dtos;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BorrowerDTO {
    private String name;
    private String email;
    private String phoneNumber;
}
