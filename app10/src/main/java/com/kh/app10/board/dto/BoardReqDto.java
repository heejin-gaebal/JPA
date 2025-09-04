package com.kh.app10.board.dto;

import com.kh.app10.board.entity.BoardEntity;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BoardReqDto {
    private Long no;

    private String title;
    private String content;

    public static BoardReqDto from(BoardEntity entity){
        BoardReqDto dto = new BoardReqDto();
        dto.no = entity.getNo();
        dto.title = entity.getTitle();
        dto.content = entity.getContent();
        return dto;
    }
}
