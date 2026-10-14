package org.example.ss04btth.models.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "animals")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "breed")
    private String breed;

    @Column(name = "age")
    private Integer age;

    @Column(name = "weight", columnDefinition = "NUMERIC(10,2)")
    private Double weight;


    @Enumerated(EnumType.STRING)
    private AnimalStatus status;// 0 , 1 , 2
}
