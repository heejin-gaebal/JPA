package com.kh.app08.member;

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

    @Column(nullable = false, unique = true, length = 100)
    private String userId;

    @Column(nullable = false, length = 100)
    private String userPwd;

    @Column(nullable = false, length = 30)
    private String userNick;

    private String delYn;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public MemberEntity() {
        delYn = "N";
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    public static MemberEntity from (MemberDto dto){
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.userId = dto.getUserId();
        memberEntity.userPwd = dto.getUserPwd();
        memberEntity.userNick = dto.getUserNick();

        return memberEntity;
    }
}
