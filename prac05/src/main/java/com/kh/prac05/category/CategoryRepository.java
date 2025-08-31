package com.kh.prac05.category;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CategoryRepository {
    private final EntityManager em;


    public CategoryEntity findByCateNo(Long categoryNo) {
        return em.find(CategoryEntity.class, categoryNo);
    }
}
