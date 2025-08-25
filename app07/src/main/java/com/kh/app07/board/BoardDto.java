package com.kh.app07.board;

import com.kh.app07.member.MemberEntity;
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
    //private MemberEntity writer;
    private Long writerNo;
    private String writerNick;

    private String delYn;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt ;

    public static BoardDto from(BoardEntity entity){
        BoardDto dto = new BoardDto();
        dto.no = entity.getNo();
        dto.title = entity.getTitle();
        dto.content = entity.getContent();
        dto.writerNo = entity.getWriter().getNo();
        dto.writerNick = entity.getWriter().getUserNick();
        dto.delYn = entity.getDelYn();
        dto.createdAt = entity.getCreatedAt();
        dto.updatedAt = entity.getUpdatedAt();

        return dto;
    }
}