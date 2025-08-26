package com.kh.app08.board;

import com.kh.app08.member.MemberEntity;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class BoardDto {
    private Long no;
    private String title;
    private String content;
    private Long writerNo;
    private String writerNick;
    private String delYn;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static BoardDto from(BoardEntity boardEntity){
        BoardDto boardDto = new BoardDto();
        boardDto.setNo(boardEntity.getNo());
        boardDto.setTitle(boardEntity.getTitle());
        boardDto.setContent(boardEntity.getContent());
        boardDto.setWriterNo(boardEntity.getWriter().getNo());
        boardDto.setWriterNick(boardEntity.getWriter().getUserNick());
        boardDto.setDelYn(boardEntity.getDelYn());
        boardDto.createdAt = boardEntity.getCreatedAt();
        boardDto.updatedAt = boardEntity.getUpdatedAt();
        return boardDto;
    }
}


