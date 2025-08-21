package com.kh.app06.member.dto;

import com.kh.app06.member.entity.MemberEntity;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class MemberDto {

    private Long no;
    private String userId;
    private String userPwd;
    private String userNick;
    private LocalDateTime createAt;
    private String delYn;

    //여기서는 세터를 연다.......
//    public static MemberEntity toEntity(MemberDto dto){
//        MemberEntity entity = new MemberEntity();
//        entity.setUserId(dto.getUserId());
//        entity.setUserPwd(dto.getUserPwd());
//        entity.setUserNick(dto.getUserNick());
//        return entity;
//    }

    public static MemberDto from(MemberEntity entity){
        MemberDto dto = new MemberDto();
        dto.no = entity.getNo();
        dto.userId = entity.getUserId();
        dto.userPwd = entity.getUserPwd();
        dto.userNick = entity.getUserNick();
        dto.createAt = entity.getCreateAt();
        dto.delYn = entity.getDelYn();
        return dto;
    }

}