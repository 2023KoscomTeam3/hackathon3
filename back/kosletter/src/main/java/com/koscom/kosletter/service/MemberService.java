package com.koscom.kosletter.service;

import com.koscom.kosletter.data.dto.request.MemberCreateRequest;
import com.koscom.kosletter.data.dto.request.MemberLoginRequest;
import com.koscom.kosletter.data.dto.response.MemberIdResponse;

public interface MemberService {
    void signUp(MemberCreateRequest memberCreateRequest);
    MemberIdResponse logIn(MemberLoginRequest memberLoginRequest);
}
