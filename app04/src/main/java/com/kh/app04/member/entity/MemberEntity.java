package com.kh.app04.member.entity;

import com.kh.app04.board.entity.BoardEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "MEMBER")
@SequenceGenerator(name = "MemberSeqGen", sequenceName = "SEQ_MEMBER",allocationSize = 1)
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MemberSeqGen")
    private Long no;
    private String userId;
    private String userPwd;
    private String userNick;

    // MEMBER -> BOARD 연관관계 설정
    // 멤버 하나가 여러보드를 참조할 수 있게,,
    // @OneToMany(mappedBy = "필드명")

    @OneToMany(mappedBy = "writer")
    private List<BoardEntity> boardEntityList;
}
