package com.kh.app06.board.dto;

import com.kh.app06.board.entity.BoardEntity;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BoardDto {
    private Long no;
    private String title;
    private String content;
    private Long writerNo;
    private String delYn;
    private LocalDateTime createAt;

    public static BoardDto from(BoardEntity entity) {
        BoardDto dto = new BoardDto();
        dto.no = entity.getNo();
        dto.title = entity.getTitle();
        dto.content = entity.getContent();
        dto.writerNo = entity.getWriter().getNo();
        dto.createAt = entity.getCreateAt();
        dto.delYn = entity.getDelYn();
        return dto;
    }

    public void setWriterNo(Long writerNo) {
        this.writerNo = writerNo;
    }
}
