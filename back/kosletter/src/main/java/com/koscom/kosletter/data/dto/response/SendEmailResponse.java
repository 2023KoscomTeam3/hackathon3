package com.koscom.kosletter.data.dto.response;

import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SendEmailResponse {
    private long memberId;
    private String email;
    private String name;
    private String stockCode;
    private String stockName;
    private long price;
    List<NewsList> newsList;

}
