package com.kh.app05.member.entity;

import com.kh.app05.board.entity.BoardEntity;
import com.kh.app05.member.dto.MemberDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Table(name = "MEMBER")
@SequenceGenerator(name = "MemberSeqGen", sequenceName = "SEQ_MEMBER", allocationSize = 1)
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "MemberSeqGen")
    private Long no;

    @Column(nullable = false, unique = true)
    private String userId;

    @Column(nullable = false)
    private String userPwd;

    @Column(nullable = false)
    private String userNick;

    private LocalDateTime createAt;

    @Column(length = 1)
    private String delYn;

    //기본 생성자
    public MemberEntity() {
        createAt = LocalDateTime.now();
        delYn = "N";
    }

    //dto -> entity
    public static MemberEntity from (MemberDto mDto){
        MemberEntity entity = new MemberEntity();
        entity.no = mDto.getNo();
        entity.userId = mDto.getUserId();
        entity.userPwd = mDto.getUserPwd();
        entity.userNick = mDto.getUserNick();
        return entity;
    }

    //member -> board 1:M관계 게시물리스트를 받아옴 | mappedBy : writer 라는 조인컬럼으로 묶임
    //<제네릭으로> 연관관계 테이블을 찾을 수 있음
    @OneToMany(mappedBy = "writer")
    private List<BoardEntity> boardEntityList;

    //작성자의 게시물리스트에 Board 요소를 추가하는 메서드??????????
    public void addBoardEntity (BoardEntity boardEntity){
        this.boardEntityList.add(boardEntity);
        boardEntity.setWriter(this); //this는 Member 요소
    }

//    public void setDelYn(String delYn) {
//        if(delYn.equals("Y") || delYn.equals("N")){
//            this.delYn = delYn;
//        }else {
//            throw new IllegalArgumentException("DELETE 에는 Y or N만 넣어주세요");
//        }
//    }
    // setter ----
}
