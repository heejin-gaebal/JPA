package com.kh.app12.member.entity;

import com.kh.app12.member.dto.MemberDto;
import com.kh.app12.member.enums.DelYn;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Table(name = "MEMBER")
@Getter
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;
    private String userId;
    private String userPwd;
    private String userNick;

    @Column(length = 1)
    @Enumerated(EnumType.STRING) //열거형 객체
    private DelYn delYn;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public MemberEntity() {
        delYn = DelYn.N;
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    // 엔티티로 이너클래스 찾아갈때
    public static MemberEntity from(MemberDto.MemberReqDto dto){
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.userId = dto.getUserId();
        memberEntity.userPwd = dto.getUserPwd();
        memberEntity.userNick = dto.getUserNick();
        return memberEntity;
    }
}
