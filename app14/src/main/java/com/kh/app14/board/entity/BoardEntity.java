package com.kh.app14.board.entity;

import com.kh.app14.board.enums.DelYn;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "BOARD")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED) //JPA가 호출할 수 있게 PROTECTED!
@AllArgsConstructor(access = AccessLevel.PRIVATE) //빌드패턴 사용시 필요 |내부에서 사용하는 기본생성자
//빌더패턴 사용시 초기값 사용X

public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;
    private String title;
    private String content;

    @Builder.Default //빌더패턴 기본값 지정
    @Enumerated(EnumType.STRING)
    private DelYn delYn = DelYn.N;

    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt;
}
