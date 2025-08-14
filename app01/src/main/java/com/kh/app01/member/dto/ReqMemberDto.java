package com.kh.app01.member.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ReqMemberDto {
    private String userId;
    private String userPwd;
    private String userNick;
}
