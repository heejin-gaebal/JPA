package com.kh.prac02.member.entity;

import com.kh.prac02.member.dto.MemberDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "MEMBER")
@SequenceGenerator(name = "MemberSeqGen", sequenceName = "SEQ_MEMBER", allocationSize = 1)
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "MemberSeqGen")
    private Long no;

    @Column(nullable = false, unique = true)
    private String userId;

    @Column(nullable = false)
    private String userPwd;

    @Column(nullable = false)
    private String userNick;

    private LocalDateTime createAt;

    @Column(length = 1)
    private String delYn;

    public MemberEntity() {
        createAt = LocalDateTime.now();
        delYn = "N";
    }

    public static MemberEntity from(MemberDto memberDto) {
        //validate 유효성 검사
        if(memberDto.getUserId().length() > 100){
            throw new IllegalArgumentException("id error");
        }
        if(memberDto.getUserPwd().length() > 100){
            throw new IllegalArgumentException("pwd error");
        }
        if(memberDto.getUserNick().length() > 100){
            throw new IllegalArgumentException("nick error");
        }

        MemberEntity memberEntity = new MemberEntity();
        memberEntity.userId = memberDto.getUserId();
        memberEntity.userPwd = memberDto.getUserPwd();
        memberEntity.userNick = memberDto.getUserNick();
        return memberEntity;
    }
}
