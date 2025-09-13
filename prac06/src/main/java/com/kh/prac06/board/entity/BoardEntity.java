package com.kh.prac06.board.entity;

import com.kh.prac06.board.dto.BoardReqDto;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.DynamicInsert;

import java.time.LocalDateTime;

@Entity(name = "BOARD")
@DynamicInsert
@Getter
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String delYn;

    public static BoardEntity from(BoardReqDto reqDto){
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.title = reqDto.getTitle();
        boardEntity.content = reqDto.getContent();

        return boardEntity;
    }

    public void modify(BoardReqDto reqDto) {
        this.title = reqDto.getTitle();
        this.content = reqDto.getContent();
        this.updatedAt = LocalDateTime.now();
    }

    public void remove() {
        this.updatedAt = LocalDateTime.now();
        this.delYn = "Y";
    }
}
