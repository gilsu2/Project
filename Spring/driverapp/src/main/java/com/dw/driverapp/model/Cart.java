package com.dw.driverapp.model;

import com.dw.driverapp.dto.CartDTO;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "장바구니")

public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_name")
    private User user;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;



    public CartDTO ToDto(){
        CartDTO cartDTO = new CartDTO();
        cartDTO.setId(this.id);
        cartDTO.setSubjectName(this.subject.getTitle());
        cartDTO.setPrice(this.subject.getPrice());
        return cartDTO;
    }
}