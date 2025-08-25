package com.kh.app07.member;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Table(name = "MEMBER")
@Getter
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //시리얼 부여
    private Long no;
    private String userId;
    private String userPwd;
    private String userNick;

    private String delYn;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public MemberEntity() {
        delYn = "N";
        createdAt = LocalDateTime.now();
    }

    public static MemberEntity from(MemberDto memberDto){
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.userId = memberDto.getUserId();
        memberEntity.userPwd = memberDto.getUserPwd();
        memberEntity.userNick = memberDto.getUserNick();

        return memberEntity;
    }
}
