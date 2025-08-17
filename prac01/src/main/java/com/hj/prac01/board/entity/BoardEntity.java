package com.hj.prac01.board.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "BOARD")
@SequenceGenerator(name = "board_seq_gen" ,sequenceName = "SEQ_BOARD", allocationSize = 1)
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "board_seq_gen")
    private Long no;
    private String title;
    private String content;
    private LocalDateTime createAt;
    private String delYn;

    public BoardEntity() {
        createAt = LocalDateTime.now();
        delYn = "N";
    }
}
