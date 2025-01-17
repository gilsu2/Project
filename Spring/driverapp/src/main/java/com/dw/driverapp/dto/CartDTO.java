package com.dw.driverapp.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CartDTO {
    private Long id;
    private Long subjectId;
    private String userName;
    private double price;


}
