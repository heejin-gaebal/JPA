package com.kh.app05.board.entity;

import com.kh.app05.board.dto.BoardDto;
import com.kh.app05.member.entity.MemberEntity;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "BOARD")
@SequenceGenerator(name = "BoardSeqGen", sequenceName = "SEQ_BOARD", allocationSize = 1)
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "BoardSeqGen")
    private Long no;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    private LocalDateTime createAt;

    @Column(length = 1)
    private String delYn;

    // 기본 생성자
    public BoardEntity() {
        createAt = LocalDateTime.now();
        delYn = "N";
    }

    @ManyToOne //다대1 관계 board->member
    @JoinColumn (name = "writerNo")
    private MemberEntity writer;

    public static BoardEntity from(BoardDto bDto, MemberEntity memberEntity) {
        BoardEntity entity = new BoardEntity();
        entity.no = bDto.getNo();
        entity.title = bDto.getTitle();
        entity.content = bDto.getContent();
        entity.writer = memberEntity;
        return entity;
    }

    // setter 생성
    public void setWriter(MemberEntity writer) {
        this.writer = writer;
    }

    public void delete() {
        if(delYn.equals("Y")){
            throw new IllegalArgumentException("이미 삭제된 글");
        }
        delYn = "Y";
    }

//    public void setDelYn(String delYn) {
//        if(delYn.equals("Y") || delYn.equals("N")){
//            this.delYn = delYn;
//        }else {
//            throw new IllegalArgumentException("DELETE 에는 Y or N만 넣어주세요");
//        }
//    }

    // setter ----

    //생성자 Dto를 파라미터에 받아서 Entity 생성 (기본생성자 X)
//    public BoardEntity(BoardDto dto) {
//        no = dto.getNo();
//        title = dto.getTitle();
//        content = dto.getContent();
//        createAt = dto.getCreateAt();
//        delYn = dto.getDelYn();
//
//        //createAt = LocalDateTime.now();
//    }
//
//    public static BoardEntity toEntity(BoardDto dto){
//
//    }
}
