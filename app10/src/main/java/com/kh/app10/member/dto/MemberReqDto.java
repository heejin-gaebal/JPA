package com.kh.app10.member.dto;

import lombok.Getter;

@Getter
public class MemberReqDto {
//요청받을 때 필요한 필드
    private String userId;
    private String userPwd;
    private String userNick;

}
