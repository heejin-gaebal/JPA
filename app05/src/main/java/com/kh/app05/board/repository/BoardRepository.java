package com.kh.app05.board.repository;

import com.kh.app05.board.entity.BoardEntity;
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

    public List<BoardEntity> findBoardAll() {
        String jpql = "SELECT b FROM BoardEntity b WHERE b.delYn = 'N'";
        return em
                .createQuery(jpql, BoardEntity.class)
                .getResultList();
    }

    public BoardEntity findBoardByNo(Long no) {
        return em.find(BoardEntity.class, no);
    }
}
