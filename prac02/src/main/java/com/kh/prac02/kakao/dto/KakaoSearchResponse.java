package com.kh.prac02.kakao.dto;

import lombok.Data;

import java.util.List;

@Data
public class KakaoSearchResponse {
    private List<KakaoPlace> documents;
    private KakaoMeta meta;
}
