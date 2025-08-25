package com.kh.app05.member.dto;

import com.kh.app05.board.dto.BoardDto;
import com.kh.app05.member.entity.MemberEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class MemberDto {

    private Long no;
    private String userId;
    private String userPwd;
    private String userNick;
    private LocalDateTime createAt;
    private String delYn;

    //dto를 받는 리스트
    private List<BoardDto> boardDtoList;

    //entity -> dto 변환
    public static MemberDto from(MemberEntity entity) {
        MemberDto dto = new MemberDto();
        dto.no = entity.getNo();
        dto.userId = entity.getUserId();
        dto.userPwd = entity.getUserPwd();
        dto.userNick = entity.getUserNick();
        dto.createAt = entity.getCreateAt();
        dto.delYn = entity.getDelYn();

        dto.boardDtoList = entity.getBoardEntityList().stream().map(BoardDto::from).toList();

        return dto;
    }
}
