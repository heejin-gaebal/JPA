package com.kh.prac06.board.dto;

import com.kh.prac06.board.entity.BoardEntity;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BoardReqDto {
    private Long no;
    private String title;
    private String content;

    public static BoardReqDto from(BoardEntity boardEntity){
        BoardReqDto boardReqDto = new BoardReqDto();
        boardReqDto.no = boardEntity.getNo();
        boardReqDto.title = boardEntity.getTitle();
        boardReqDto.content = boardEntity.getContent();

        return boardReqDto;
    }
}
