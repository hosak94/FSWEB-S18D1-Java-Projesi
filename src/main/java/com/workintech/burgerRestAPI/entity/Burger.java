package com.workintech.burgerRestAPI.entity;


import com.fasterxml.jackson.annotation.JsonTypeId;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
 @NoArgsConstructor
@Table(name = "burgers", schema = "burgerdb")
public class Burger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @NotNull
    @NotBlank
    private String name;

    @Column(name = "price")
    @DecimalMin("20")
    private double price;

    @Column(name = "is_vegan")
    private boolean isVegan;

    @Enumerated(EnumType.STRING)
    private BreadType breadType;

    @Column(name = "contents")
    private List<String> contents;
}
