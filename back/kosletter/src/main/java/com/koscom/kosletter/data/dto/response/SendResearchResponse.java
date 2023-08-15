package com.koscom.kosletter.data.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SendResearchResponse {
    private long memberId;
    private String email;
    private String name;
    private String stockCode;
    private String stockName;
    private String statImg;
    private String predImg;
    private String tableImg;
}
