package com.kh.prac02.kakao.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class KakaoPlace {
    @JsonProperty("place_name")
    private String placeName;

    @JsonProperty("category_name")
    private String categoryName;

    @JsonProperty("address_name")
    private String addressName;

    @JsonProperty("road_address_name")
    private String roadAddressName;

    private String phone;

    @JsonProperty("place_url")
    private String placeUrl;

    private String x; // 경도
    private String y; // 위도
}
