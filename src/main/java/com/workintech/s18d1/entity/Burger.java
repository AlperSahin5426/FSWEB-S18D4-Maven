package com.workintech.s18d1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="burger")
public class Burger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name",nullable = false)
    private String name;
    @Column(name="price",nullable = false)
    private Double price;
    @Column(name="is_vegan")
    private boolean isVegan;
    @Enumerated(EnumType.STRING)
    @Column(name="bread_type")
    private BreadType breadType;
    @Column(name="contents")
    private String contents;

    public Boolean getIsVegan() {
        return this.isVegan;
    }

    public void setIsVegan(Boolean isVegan) {
        this.isVegan = isVegan;
    }
}
