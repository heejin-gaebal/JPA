package com.kh.app01.board.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

//@Getter : 바인딩쿼리의 ?의 값을 채워줄때 사용
@Setter
@Getter
@Entity
@Table(name = "board")
@SequenceGenerator(name = "board_seq_gen", sequenceName = "SEQ_BOARD", allocationSize = 1)
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "board_seq_gen")
    private Long no;
    private String title;
    private String content;
    private LocalDateTime createAt;
    private String delYn;

    //기본생성자로 컬럼의 디폴트값 지정해주기 - JPA는 기본생성자가 꼭 있어야 한다.
    public BoardEntity() {
        createAt = LocalDateTime.now();
        delYn = "N";
    }
}
