package com.kh.app10.board.repository;

import com.kh.app10.board.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
    //join fetch를 위한 쿼리문 생성
    @Query("""
            SELECT b
            FROM BoardEntity b
            JOIN FETCH b.writer
            LEFT JOIN FETCH b.likeEntityList l
            LEFT JOIN FETCH l.memberEntity
            """)
    //좋아요 안눌린 게시물도 나와야 하므로 left join 해야함
    List<BoardEntity> findAllWithLikeEntityAndMemberEntity();
}
