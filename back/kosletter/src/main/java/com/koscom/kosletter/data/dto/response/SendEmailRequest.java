package com.koscom.kosletter.data.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SendEmailRequest {
    private String email;
    private String name;
    private String stockName;
    private String title;
    private String contents;
    private String url;

}
