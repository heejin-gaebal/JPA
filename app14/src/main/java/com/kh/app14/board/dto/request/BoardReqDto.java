package com.kh.app14.board.dto.request;
import com.kh.app14.board.entity.BoardEntity;
import lombok.Getter;

@Getter
public class BoardReqDto {
    private String title;
    private String content;

    //dto->entity | builder()로 셋팅
    public BoardEntity toEntity() {
        return BoardEntity.builder()
                .title(this.title)
                .content(this.content)
                .build();
    }
}
