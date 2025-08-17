package com.hj.prac01.notice.repository;

import com.hj.prac01.notice.entity.NoticeEntity;
import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class NoticeRepository {
    private final EntityManager em;
    public void insert(NoticeEntity entity) {
        em.persist(entity);
    }

    public List<NoticeEntity> list() {
        String jpql = "SELECT n FROM NoticeEntity n";
        return em.createQuery(jpql, NoticeEntity.class).getResultList();
    }

    public NoticeEntity listOne(Long no) {
        return em.find(NoticeEntity.class, no);
    }

    public void delete(NoticeEntity entity) {
        em.remove(entity);
    }
}
