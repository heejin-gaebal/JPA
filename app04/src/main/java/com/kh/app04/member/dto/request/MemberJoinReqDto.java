package com.kh.app04.member.dto.request;

import lombok.Getter;

@Getter
public class MemberJoinReqDto {

    private String userId;
    private String userPwd;
    private String userNick;
}
