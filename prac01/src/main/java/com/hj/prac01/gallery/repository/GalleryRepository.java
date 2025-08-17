package com.hj.prac01.gallery.repository;

import com.hj.prac01.gallery.entity.GalleryEntity;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class GalleryRepository {
    private final EntityManager em;

    public void insert(GalleryEntity entity) {
        em.persist(entity);
    }

    public List<GalleryEntity> list() {
        String jpql = "SELECT g FROM GalleryEntity g";
        return em.createQuery(jpql, GalleryEntity.class).getResultList();
    }

    public GalleryEntity listOne(Long no) {
        return em.find(GalleryEntity.class, no);
    }

    public void delete(GalleryEntity entity) {
        em.remove(entity);
    }
}
