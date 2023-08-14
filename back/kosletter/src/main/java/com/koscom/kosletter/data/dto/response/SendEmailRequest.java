package com.koscom.kosletter.data.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SendEmailRequest {
    private long memberId;
    private String email;
    private String name;
    private String stockCode;
    private String stockName;
    private String title;
    private String contents;
    private String url;

}
