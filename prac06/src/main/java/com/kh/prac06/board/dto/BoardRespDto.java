package com.kh.prac06.board.dto;

import com.kh.prac06.board.entity.BoardEntity;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BoardRespDto {
    private Long no;
    private String title;
    private String content;
    private String delYn;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static BoardRespDto from(BoardEntity entity){
        BoardRespDto boardRespDto = new BoardRespDto();
        boardRespDto.no = entity.getNo();
        boardRespDto.title = entity.getTitle();
        boardRespDto.content = entity.getContent();
        boardRespDto.createdAt = entity.getCreatedAt();
        boardRespDto.updatedAt = entity.getUpdatedAt();
        boardRespDto.delYn = entity.getDelYn();

        return boardRespDto;
    }
}
