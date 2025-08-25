package com.kh.app07.board;

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

    public BoardEntity findBoardByNo(Long no) {
        return em.find(BoardEntity.class,no);
    }

    public List<BoardEntity> findBoardAll() {
        //패치조인 사용 - 관계 조인
        String jpql = "SELECT b FROM BoardEntity b join fetch b.writer WHERE b.delYn = 'N'";
        return em
                .createQuery(jpql, BoardEntity.class)
                .getResultList();
        //쿼리만드는 조건이 createQuery 이므로 실행시 계속 jpql 생성
    }
}
