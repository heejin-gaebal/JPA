package com.kh.app10.like.dto;

import com.kh.app10.like.entity.LikeEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LikeDto {

    private Long no;
    private Long memberNo;
    private Long boardNo;

    public static LikeDto from(LikeEntity likeEntity){
        LikeDto likeDto = new LikeDto();
        likeDto.no = likeEntity.getNo();
        likeDto.memberNo = likeEntity.getMemberEntity().getNo();
        likeDto.boardNo = likeEntity.getBoardEntity().getNo();

        return likeDto;
    }
}
