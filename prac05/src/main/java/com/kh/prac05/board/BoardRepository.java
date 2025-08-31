package com.kh.prac05.board;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardRepository {
    private final EntityManager em;
    public void insert(BoardEntity boardEntity) {
        em.persist(boardEntity);
    }

    public BoardEntity listOne(Long no) {
        return em.find(BoardEntity.class, no);
    }

    public List<BoardEntity> list() {
        String jpql = "SELECT b FROM BoardEntity b WHERE b.delYn = 'N' ORDER BY b.no DESC";
        return em
                .createQuery(jpql, BoardEntity.class)
                .getResultList();
    }
}
