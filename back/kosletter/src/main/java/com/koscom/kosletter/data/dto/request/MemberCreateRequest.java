package com.koscom.kosletter.data.dto.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberCreateRequest {
    private String email;
    private String password;
    private String nickname;
    private long stockId;
}
