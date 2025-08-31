package com.kh.prac05.board;

import com.kh.prac05.category.CategoryEntity;
import com.kh.prac05.member.MemberEntity;
import com.kh.prac05.util.AttachFileEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Table(name = "BOARD")
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    private String delYn;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "writerNo")
    private MemberEntity writer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryNo")
    private CategoryEntity category;

//    @OneToMany(mappedBy = "attachFile")
//    private List<AttachFileEntity> attachFileList;

    public BoardEntity() {
        delYn = "N";
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    public static BoardEntity from(BoardDto boardDto , MemberEntity writer, CategoryEntity category){
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.title = boardDto.getTitle();
        boardEntity.content = boardDto.getContent();
        boardEntity.writer = writer;
        boardEntity.category = category;
        return boardEntity;
    }

    public void update(BoardDto boardDto) {
        this.title = boardDto.getTitle();
        this.content = boardDto.getContent();
        this.updatedAt = LocalDateTime.now();
    }

    public void delete() {
        this.delYn = "Y";
        this.updatedAt = LocalDateTime.now();
    }
}
