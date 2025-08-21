package com.kh.app06.board.entity;

import com.kh.app06.board.dto.BoardDto;
import com.kh.app06.member.entity.MemberEntity;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "BOARD")
@SequenceGenerator(name = "BoardSeqGen", sequenceName = "SEQ_BOARD",allocationSize = 1)
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "BoardSeqGen")
    private Long no;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String content;
    @Column(length = 1)
    private String delYn;
    private LocalDateTime createAt;

    @ManyToOne
    @JoinColumn(name = "writerNo", nullable = false)
    private MemberEntity writer;

    public BoardEntity() {
        createAt = LocalDateTime.now();
        delYn = "N";
    }

    public static BoardEntity from(BoardDto dto, MemberEntity memberEntity) {
        BoardEntity entity = new BoardEntity();
        entity.title = dto.getTitle();
        entity.content = dto.getContent();
        entity.writer = memberEntity; //멤버번호가 들어있는 엔티티를 머 어떻게한다고
        return entity;
    }
}
