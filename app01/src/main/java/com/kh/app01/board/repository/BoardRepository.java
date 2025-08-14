package com.kh.app01.board.repository;

import com.kh.app01.board.entity.BoardEntity;
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

    public BoardEntity getBoardByNo(Long no) {
        return em.find(BoardEntity.class, no);
    }

    public List<BoardEntity> getBoardAll() {
        String jpql = """
                SELECT b FROM BoardEntity b WHERE b.delYn = 'N' ORDER BY b.no DESC
                """; 
                //객체 그대로 조회 | 컬럼에 변수 달아주기
        return em.createQuery(jpql, BoardEntity.class).getResultList();
    }
}
