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
    @OneToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;
    @OneToOne
    @JoinColumn(name = "user_name")
    private User user;

    public CartDTO ToDto(){
        CartDTO cartDTO = new CartDTO();
        cartDTO.setId(this.id);
        cartDTO.setSubjectId(this.subject.getId());
        cartDTO.setPrice(this.subject.getPrice());
        cartDTO.setUserName(this.user.getUserName());
        return cartDTO;
    }
}