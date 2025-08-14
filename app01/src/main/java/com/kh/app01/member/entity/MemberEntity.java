package com.kh.app01.member.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "MEMBER")
@SequenceGenerator(name = "seq_mem_gen", sequenceName = "SEQ_MEMBER", allocationSize = 1)
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_mem_gen")
    private Long no;
    private String userId;
    private String userPwd;
    private String userNick;
    private LocalDateTime createAt;
    private String delYn;

    public MemberEntity() {
        createAt = LocalDateTime.now();
        delYn = "N";
    }
}


