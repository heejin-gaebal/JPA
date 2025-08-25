package com.kh.app07.board;

import com.kh.app07.member.MemberEntity;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "BOARD")
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;
    private String title;
    private String content;

    private String delYn;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt ;

//    @ManyToOne (fetch = FetchType.EAGER)  // default | 쿼리문 여러번날아감
    @ManyToOne (fetch = FetchType.LAZY) // 1차 캐시 저장 후 필요할 때에 쿼리문 날림
    @JoinColumn(name = "writerNo")
    private MemberEntity writer;

    public BoardEntity() {
        delYn = "N";
        createdAt = LocalDateTime.now();
    }

    public static BoardEntity from(BoardDto boardDto, MemberEntity memberEntity){
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.title = boardDto.getTitle();
        boardEntity.content = boardDto.getContent();
        boardEntity.writer = memberEntity;
        return boardEntity;
    }

    public void delete() {
        this.delYn = "Y";
        this.updatedAt = LocalDateTime.now();
    }

    public void update(BoardDto dto) {
        this.title = dto.getTitle();
        this.content = dto.getContent();
        this.updatedAt = LocalDateTime.now();
    }
}
