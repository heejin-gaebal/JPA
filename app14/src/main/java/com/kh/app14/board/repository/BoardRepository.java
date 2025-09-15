package com.kh.app14.board.repository;

import com.kh.app14.board.entity.BoardEntity;
import com.kh.app14.board.entity.QBoardEntity;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.kh.app14.board.entity.QBoardEntity.boardEntity;

@Repository
@RequiredArgsConstructor
public class BoardRepository {
    private final EntityManager em;
    private final JPAQueryFactory queryFactory;

    public void save(BoardEntity entity) {
        em.persist(entity);
    }

    //전체 목록 조회
    public List<BoardEntity> findAll() {
        BooleanExpression cond1 = boardEntity.title.contains(""); //조건문 변수로 빼서 관리 가능

        return queryFactory
                //.selectFrom(QBoardEntity.boardEntity) Q클래스 import해서 줄여주기
                .selectFrom(boardEntity)
                .where(
                        //boardEntity.title.contains("").or, //or조건
                        boardEntity.title.contains(""), //조건문1
                        boardEntity.content.contains("")  //조건문2

                )//%Like
                .orderBy(boardEntity.no.desc())
                .fetch();
        //sql 문이 메서드로 준비되어있음
    }
}
