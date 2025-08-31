package com.kh.prac05.member;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class MemberDto {
    private Long no;
    private String userId;
    private String userPwd;
    private String userNick;
    private String delYn;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static MemberDto from(MemberEntity memberEntity){
        MemberDto memberDto = new MemberDto();
        memberDto.no = memberEntity.getNo();
        memberDto.userId = memberEntity.getUserId();
        memberDto.userPwd = memberEntity.getUserPwd();
        memberDto.userNick = memberEntity.getUserNick();
        memberDto.delYn = memberEntity.getDelYn();
        memberDto.createdAt = memberEntity.getCreatedAt();
        memberDto.updatedAt = memberEntity.getUpdatedAt();

        return memberDto;
    }
}
