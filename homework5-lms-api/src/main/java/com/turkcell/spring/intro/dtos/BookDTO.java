package com.turkcell.spring.intro.dtos;


import java.util.Date;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
    private String name;
    private String author;
    private String pageNo;
    private Date borrowDate;
    private Date returnDate;
    private boolean isAvailable;
}
