package com.kh.app10.member.dto;
import com.kh.app10.member.entity.MemberEntity;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class MemberRespDto {
    //응답할때 필요한 필드
    private String userId;
    private String userNick;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<Long> likedBoardNoList; //좋아요를 누른 게시글 목록
    private List<String> likedBoardTitleList; //좋아요를 누른 게시글 제목

    public static MemberRespDto from(MemberEntity entity){
        MemberRespDto respDto = new MemberRespDto();
        respDto.userId = entity.getUserId();
        respDto.userNick = entity.getUserNick();
        respDto.createdAt = entity.getCreatedAt();
        respDto.updatedAt = entity.getUpdatedAt();
        respDto.likedBoardNoList = entity.getLikeEntityList()
                                        .stream()
                                        .map(likeEntity -> likeEntity.getBoardEntity().getNo())
                                        .toList();
        respDto.likedBoardTitleList = entity.getLikeEntityList()
                                        .stream()
                                        .map(likeEntity -> likeEntity.getBoardEntity().getTitle())
                                        .toList();
        return respDto;
    }
}
