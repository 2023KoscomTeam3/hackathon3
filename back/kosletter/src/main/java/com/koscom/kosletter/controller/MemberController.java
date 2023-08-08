package com.koscom.kosletter.controller;

import com.koscom.kosletter.data.dto.request.MemberCreateRequest;
import com.koscom.kosletter.data.dto.request.MemberLoginRequest;
import com.koscom.kosletter.data.dto.response.MemberIdResponse;
import com.koscom.kosletter.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/sign-up")
    public ResponseEntity<String> postMember(@RequestBody MemberCreateRequest memberRequest) {
        log.info("PostMember Controller");
        memberService.signUp(memberRequest);

        return ResponseEntity.ok("회원가입 완료.");
    }

    @PostMapping("/login")
    public ResponseEntity<MemberIdResponse> postLogin(@RequestBody MemberLoginRequest memberRequest) {
        log.info("postLogin Controller");
        MemberIdResponse body = memberService.logIn(memberRequest);

        return ResponseEntity.ok()
            .body(body);
    }
}
