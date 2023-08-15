package com.koscom.kosletter.data.dto.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberLoginRequest {
    private String email;
    private String password;
}
