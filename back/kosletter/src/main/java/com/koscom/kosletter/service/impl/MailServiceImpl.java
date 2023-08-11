package com.koscom.kosletter.service.impl;

import com.koscom.kosletter.data.dto.request.SendEmailRequest;
import com.koscom.kosletter.service.MailService;
import java.io.UnsupportedEncodingException;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MailServiceImpl implements MailService {
    private final JavaMailSender mailSender;

    private MimeMessage createMessage(SendEmailRequest request) throws MessagingException, UnsupportedEncodingException {
        MimeMessage message = mailSender.createMimeMessage();

        message.addRecipients(RecipientType.TO, request.getEmail());
        message.setSubject("제목");

        String msgg = "";
        msgg+= "<div style='margin:20px;'>";
        msgg+= "<h1> 안녕하세요 Kosletter 입니다. </h1>";
        msgg+= "<br>";
        msgg+= "<p>아래 코드를 복사해 입력해주세요<p>";
        msgg+= "<br>";
        msgg+= "<p>감사합니다.<p>";
        msgg+= "<br>";
        msgg+= "<div align='center' style='border:1px solid black; font-family:verdana';>";
        msgg+= "<h3 style='color:blue;'>회원가입 인증 코드입니다.</h3>";
        msgg+= "<div style='font-size:130%'>";
        msgg+= "CODE : <strong>";
        //msgg+= confirm+"</strong><div><br/> ";
        msgg+= "</div>";
        message.setText(msgg, "utf-8", "html");//내용
        message.setFrom(new InternetAddress("kosletter@gmail.com","KOSLETTER"));//보내는 사람

        return message;
    }
    @Override
    public void sendMail(long memberId) {

    }
}
