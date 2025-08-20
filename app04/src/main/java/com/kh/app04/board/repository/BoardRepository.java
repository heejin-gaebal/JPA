package com.kh.app04.board.repository;

import com.kh.app04.board.entity.BoardEntity;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardRepository {
    private final EntityManager em;

    public void insert(BoardEntity entity) {
        em.persist(entity);
    }

    public List<BoardEntity> list() {
        String jpql = "SELECT b FROM BoardEntity b";
        return em.createQuery(jpql, BoardEntity.class).getResultList();
    }
}
