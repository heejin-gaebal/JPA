package com.kh.prac05.member;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "MEMBER")
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;

    @Column(nullable = false, unique = true)
    private String userId;

    @Column(nullable = false)
    private String userPwd;

    @Column(nullable = false)
    private String userNick;

    private String delYn;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public MemberEntity() {
        delYn = "N";
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    public static MemberEntity from (MemberDto memberDto){
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.userId = memberDto.getUserId();
        memberEntity.userPwd = memberDto.getUserPwd();
        memberEntity.userNick = memberDto.getUserNick();

        return memberEntity;
    }
}
