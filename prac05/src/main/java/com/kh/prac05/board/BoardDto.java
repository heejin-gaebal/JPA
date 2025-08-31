package com.kh.prac05.board;
import lombok.Getter;
import java.time.LocalDateTime;

@Getter
public class BoardDto {
    private Long no;
    private String title;
    private String content;
    private String delYn;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Long writerNo;
    private String writerNick;
    private Long categoryNo;
    private String categoryName;
//    private Long fileNo;
//    private String fileOriginName;


    public static BoardDto from(BoardEntity boardEntity){
        BoardDto boardDto = new BoardDto();
        boardDto.no = boardEntity.getNo();
        boardDto.title = boardEntity.getTitle();
        boardDto.content = boardEntity.getContent();
        boardDto.delYn = boardEntity.getDelYn();
        boardDto.createdAt = boardEntity.getCreatedAt();
        boardDto.updatedAt = boardEntity.getUpdatedAt();
        boardDto.writerNo = boardEntity.getWriter().getNo();
        boardDto.writerNick = boardEntity.getWriter().getUserNick();
        boardDto.categoryNo = boardEntity.getCategory().getCategoryNo();
        boardDto.categoryName = boardEntity.getCategory().getCategoryName();
//        boardDto.fileNo = boardEntity.getAttachFile().getFileNo();
//        boardDto.fileOriginName = boardEntity.getAttachFile().getFileOriginName();

        return boardDto;
    }
}
