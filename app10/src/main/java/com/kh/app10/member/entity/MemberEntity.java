package com.kh.app10.member.entity;

import com.kh.app10.like.entity.LikeEntity;
import com.kh.app10.member.dto.MemberDto;
import com.kh.app10.member.dto.MemberReqDto;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "MEMBER")
@Getter
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

    @OneToMany(mappedBy = "memberEntity", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<LikeEntity> likeEntityList;

    public MemberEntity() {
        delYn = "N";
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    public static MemberEntity from(MemberReqDto reqDto){
        MemberEntity entity = new MemberEntity();
        entity.userId = reqDto.getUserId();
        entity.userPwd = reqDto.getUserPwd();
        entity.userNick = reqDto.getUserNick();
        return entity;
    }
}