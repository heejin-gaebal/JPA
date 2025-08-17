package com.hj.prac01.board.repository;

import com.hj.prac01.board.entity.BoardEntity;
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
        String jpql = """
                SELECT b FROM BoardEntity b
                """;
        return em.createQuery(jpql, BoardEntity.class).getResultList();
    }

    public BoardEntity listOne(Long no) {
        return em.find(BoardEntity.class, no);
    }

    public void delete(BoardEntity entity) {
        em.remove(entity);
    }
}

