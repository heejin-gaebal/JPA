package com.kh.app04.board.entity;

import com.kh.app04.member.entity.MemberEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "BOARD")
@SequenceGenerator(name = "BoardSeqGen", sequenceName = "SEQ_BOARD", allocationSize = 1)
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BoardSeqGen")
    private Long no;
    private String title;
    private String content;

    //BOARD -> MEMBER
    //이거 필드아니고 객체간(n:1) 연결 / 외래키 연결용 필드 보드가 n 멤버가 1
    //MemberEntity의 기본키 타입에 맞춰서 타입 지정 - 생성시 기본키의 이름이 붙는다
    @ManyToOne
    // @JoinColumn : 조인을 위한 컬럼 | name 지정 가능
    @JoinColumn(name = "writerNo")
    private MemberEntity writer;
}
