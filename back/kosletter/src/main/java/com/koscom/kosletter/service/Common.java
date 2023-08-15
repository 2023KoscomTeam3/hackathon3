package com.koscom.kosletter.service;

import com.koscom.kosletter.data.entity.Member;
import com.koscom.kosletter.data.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Component
@Slf4j
public class Common {
    private final MemberRepository memberRepository;

    @Transactional(readOnly = true)
    public Member getMember(long memberId) {
        log.info("Common getMember {}", memberId);
        return memberRepository.findById(memberId).orElseThrow(RuntimeException::new);
    }
}
