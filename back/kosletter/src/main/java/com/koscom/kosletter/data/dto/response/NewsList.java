package com.koscom.kosletter.data.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class NewsList {
    private String title;
    private String contents;
    private String url;
}
