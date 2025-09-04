package com.kh.app10.board.entity;

import com.kh.app10.board.dto.BoardDto;
import com.kh.app10.board.dto.BoardReqDto;
import com.kh.app10.like.entity.LikeEntity;
import com.kh.app10.member.entity.MemberEntity;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "BOARD")
@Getter
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "writerNo")
    private MemberEntity writer;

    private String delYn;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    //DB에 관여 X, 연관관계만 설정
    @OneToMany(mappedBy = "boardEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LikeEntity> likeEntityList;

    public BoardEntity() {
        delYn = "N";
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    public static BoardEntity from(BoardReqDto dto , MemberEntity memberEntity){
        BoardEntity entity = new BoardEntity();
        entity.title = dto.getTitle();
        entity.content = dto.getContent();
        entity.writer = memberEntity;
        return entity;
    }

    public void update(BoardReqDto reqDto) {
        this.title = reqDto.getTitle();
        this.content = reqDto.getContent();
        this.updatedAt = LocalDateTime.now();
    }

    public void delete() {
        this.delYn = "Y";
        this.updatedAt = LocalDateTime.now();
    }
}
