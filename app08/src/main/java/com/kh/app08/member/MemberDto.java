package com.kh.app08.member;

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
        memberDto.setNo(memberEntity.getNo());
        memberDto.setUserId(memberEntity.getUserId());
        memberDto.setUserPwd(memberEntity.getUserPwd());
        memberDto.setUserNick(memberEntity.getUserNick());
        memberDto.setCreatedAt(memberEntity.getCreatedAt());
        memberDto.setUpdatedAt(memberEntity.getUpdatedAt());

        return memberDto;
    }
}
