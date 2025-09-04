package com.kh.app10.board.dto;

import com.kh.app10.board.entity.BoardEntity;
import com.kh.app10.like.entity.LikeEntity;
import lombok.Getter;
import java.time.LocalDateTime;
import java.util.List;

@Getter
public class BoardRespDto {

    private Long no;
    private String title;
    private String content;
    private String writerNick;
    private List<Long> likeMemberNoList; //좋아요를 누른 멤버목록
    private List<String> likeMemberNickList; //좋아요를 누른 멤버목록

    public static BoardRespDto from(BoardEntity entity){
        BoardRespDto dto = new BoardRespDto();
        dto.no = entity.getNo();
        dto.title = entity.getTitle();
        dto.content = entity.getContent();
        dto.writerNick = entity.getWriter().getUserNick();
        dto.likeMemberNoList = entity
                                .getLikeEntityList()
                                .stream()
                                .map(LikeEntity -> LikeEntity.getMemberEntity().getNo())
                                //like가 들고있는 멤버엔티티에가서 유저넘버값을 가져오겠다~
                                .toList();
        dto.likeMemberNickList = entity
                                .getLikeEntityList()
                                .stream()
                                .map(LikeEntity -> LikeEntity.getMemberEntity().getUserNick())
                                //like가 들고있는 멤버엔티티에가서 유저닉네임을 가져오겠다~
                                .toList();
        return dto;
    }
}
