package com.kh.prac02.member.dto;

import com.kh.prac02.member.entity.MemberEntity;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class MemberDto {
    private Long no;
    private String userId;
    private String userPwd;
    private String userNick;
    private LocalDateTime createAt;
    private String delYn;

    public static MemberDto from(MemberEntity entity) {
        MemberDto memberDto = new MemberDto();
        memberDto.no = entity.getNo();
        memberDto.userId = entity.getUserId();
        memberDto.userPwd = entity.getUserPwd();
        memberDto.userNick = entity.getUserNick();
        memberDto.createAt = entity.getCreateAt();
        memberDto.delYn = entity.getDelYn();
        return memberDto;
    }
}
