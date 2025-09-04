package com.kh.app10.board.dto;

import com.kh.app10.board.entity.BoardEntity;
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
    //    private MemberEntity writer;
    private Long writerNo;
    private String writerNick;

    private String delYn;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
