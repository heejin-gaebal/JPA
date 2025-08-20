package com.kh.app04.member.dto.resp;

import com.kh.app04.board.dto.BoardDto.BoardDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
//엔티티에서 값을 셋팅해줘야 하고 값을 받아야하니 게터세터 필요
public class MemberLoginRespDto {
    private String userId;
    private String userNick;

    // 연관관계 설정
    private List<BoardDto> boardDtoList;
}
