package com.kh.prac05.category;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "CATEGORY")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryNo;

    @Column(nullable = false)
    private String categoryName;

}
