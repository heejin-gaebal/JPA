package com.kh.app04.board.dto.BoardDto;

import com.kh.app04.board.entity.BoardEntity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BoardDto {
    private String title;
    private String content;

    //엔티티 -> dto 변환
    public static BoardDto changeEntityToDto(BoardEntity entity){
        BoardDto dto = new BoardDto();
        dto.setTitle(entity.getTitle());
        dto.setContent(entity.getContent());
        return dto;
    }
}
