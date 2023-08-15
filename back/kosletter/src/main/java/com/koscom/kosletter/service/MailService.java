package com.koscom.kosletter.service;

public interface MailService {
    void sendNewsLetterMail();
    void sendResearchMail(long memberId);
}
