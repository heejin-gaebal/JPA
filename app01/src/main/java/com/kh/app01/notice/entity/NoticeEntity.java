package com.kh.app01.notice.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Setter
@Getter
@Entity
@Table(name = "NOTICE")
@SequenceGenerator(name = "notice_seq_gen", sequenceName = "SEQ_NOTICE", allocationSize = 1)
public class NoticeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "notice_seq_gen")
    private Long no;
    private String title;
    private String content;
    private LocalDateTime createAt;
    private String delYn;

    public NoticeEntity() {
        createAt = LocalDateTime.now();
        delYn = "N";
    }
}
