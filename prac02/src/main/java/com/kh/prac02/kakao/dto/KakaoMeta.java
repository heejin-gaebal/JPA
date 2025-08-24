package com.kh.prac02.kakao.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class KakaoMeta {
    @JsonProperty("total_count")
    private Integer totalCount;

    @JsonProperty("pageable_count")
    private Integer pageableCount;

    @JsonProperty("is_end")
    private Boolean isEnd;
}
