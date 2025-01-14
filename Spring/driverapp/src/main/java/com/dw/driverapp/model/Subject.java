package com.dw.driverapp.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="과목")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="title")
    private String title;
    @Column(name="explanation")
    private String explanation;
    @OneToMany
    @JoinColumn(name="image_id")
    private List<Image> imageList = new ArrayList<>();


<<<<<<< HEAD:driverapp/src/main/java/com/dw/driverapp/model/Subject.java

=======
>>>>>>> 7ec4261332130e13f83b0eb73886cdfa083bbeb1:Spring/driverapp/src/main/java/com/dw/driverapp/model/Subject.java
    @ManyToMany
    @JoinTable(name = "subject_type",
            joinColumns = @JoinColumn(name = "subject_id"),
            inverseJoinColumns = @JoinColumn(name = "type_id"))
    private List<Type> typeList = new ArrayList<>();

    @Column(name="price")
    private double price;
<<<<<<< HEAD:driverapp/src/main/java/com/dw/driverapp/model/Subject.java
    
=======

<<<<<<< HEAD
>>>>>>> 7ec4261332130e13f83b0eb73886cdfa083bbeb1:Spring/driverapp/src/main/java/com/dw/driverapp/model/Subject.java

=======
>>>>>>> 63db3f52693baf4e1ff38e8610a66374842400de
    @ManyToOne
    @JoinColumn(name="instructor_name")
    private User user_fk;

}
