package com.kh.app14.board.dto.response;

import com.kh.app14.board.entity.BoardEntity;
import com.kh.app14.board.enums.DelYn;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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

    public static BoardRespDto from(BoardEntity boardEntity) {
        BoardRespDto boardRespDto = new BoardRespDto();
        boardRespDto.no = boardEntity.getNo();
        boardRespDto.title = boardEntity.getTitle();
        boardRespDto.content = boardEntity.getContent();
        boardRespDto.delYn = boardEntity.getDelYn().getLabel();
        boardRespDto.createdAt = boardEntity.getCreatedAt();
        boardRespDto.updatedAt = boardEntity.getUpdatedAt();
        return boardRespDto;
    }
}
