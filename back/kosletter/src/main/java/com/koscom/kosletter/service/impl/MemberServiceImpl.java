package com.koscom.kosletter.service.impl;

import com.koscom.kosletter.data.dto.request.MemberCreateRequest;
import com.koscom.kosletter.data.dto.request.MemberLoginRequest;
import com.koscom.kosletter.data.dto.response.MemberIdResponse;
import com.koscom.kosletter.data.entity.Interest;
import com.koscom.kosletter.data.entity.Member;
import com.koscom.kosletter.data.entity.Stock;
import com.koscom.kosletter.data.repository.InterestRepository;
import com.koscom.kosletter.data.repository.MemberRepository;
import com.koscom.kosletter.data.repository.StockRepository;
import com.koscom.kosletter.errors.code.MemberErrorCode;
import com.koscom.kosletter.errors.exception.ErrorException;
import com.koscom.kosletter.service.MailService;
import com.koscom.kosletter.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final StockRepository stockRepository;
    private final InterestRepository interestRepository;
    private final MailService mailService;

    @Override
    public void signUp(MemberCreateRequest memberRequest) {
        log.info("MemberServiceImpl sign-up");
        Member member = Member.builder()
            .email(memberRequest.getEmail())
            .password(memberRequest.getPassword())
            .nickname(memberRequest.getNickname())
            .build();
        memberRepository.save(member);

        Stock stock = stockRepository.getById(memberRequest.getStockId());

        Interest interest = Interest.builder()
            .member(member)
            .stock(stock.getId())
            .build();
        interestRepository.save(interest);
        log.info("MemberServiceImpl sign-up 완료");
    }

    @Override
    public MemberIdResponse logIn(MemberLoginRequest memberRequest) {
        log.info("MemberServiceImpl log-in");
        Member member = memberRepository.findByEmailAndPassword(memberRequest.getEmail(),
            memberRequest.getPassword()).orElseThrow(() -> new ErrorException(MemberErrorCode.MEMBER_UNAUTHORIZED));

        MemberIdResponse memberId = MemberIdResponse.builder()
            .memberId(member.getId())
            .coin(member.getCoin())
            .build();

        mailService.sendMail();
        log.info("MemberServiceImpl log-in 완료 : {}", memberId.getMemberId());
        return memberId;
    }
}
