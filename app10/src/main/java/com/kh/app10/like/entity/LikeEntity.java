package com.kh.app10.like.entity;

import com.kh.app10.board.entity.BoardEntity;
import com.kh.app10.member.entity.MemberEntity;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "LIKES")
public class LikeEntity {
    //다대다 연결 해제해야하므로 두 테이블의 entity를 알고 있어야함

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;

    @ManyToOne
    @JoinColumn(name = "member_no")
    private MemberEntity memberEntity;
    //한사람이 여러개 좋아요

    @ManyToOne
    @JoinColumn(name = "boardNo")
    private BoardEntity boardEntity;
    //게시글하나에 여러개 좋아요

    public static LikeEntity from(MemberEntity memberEntity, BoardEntity boardEntity) {
        LikeEntity likeEntity = new LikeEntity();
        likeEntity.memberEntity = memberEntity;
        likeEntity.boardEntity = boardEntity;

        return likeEntity;
    }

}
