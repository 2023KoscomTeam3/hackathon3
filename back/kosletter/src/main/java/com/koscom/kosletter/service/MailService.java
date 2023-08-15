package com.koscom.kosletter.service;

public interface MailService {
    void sendNewsLetterMail(long memberId);
    void sendResearchMail(long memberId);
}
