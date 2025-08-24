package com.kh.prac02.kakao.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "PLACE")
@SequenceGenerator(name = "placeSeqGen", sequenceName = "SEQ_PLACE", allocationSize = 1)
public class KakaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "placeSeqGen")
    private Long no;
    private String placeName;
    private String categoryName;
    private String addressName;
    private String roadAddressName;
    private String phone;
    private String placeUrl;
    private Double x;
    private Double y;

    private LocalDateTime createAt;

    public KakaoEntity() {
        createAt = LocalDateTime.now();
    }
}
