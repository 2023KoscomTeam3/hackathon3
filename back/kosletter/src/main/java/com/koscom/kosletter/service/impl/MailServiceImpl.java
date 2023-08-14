package com.koscom.kosletter.service.impl;

import com.koscom.kosletter.data.dto.response.SendEmailRequest;
import com.koscom.kosletter.data.entity.Interest;
import com.koscom.kosletter.data.entity.News;
import com.koscom.kosletter.data.entity.Stock;
import com.koscom.kosletter.data.repository.InterestRepository;
import com.koscom.kosletter.data.repository.NewsRepository;
import com.koscom.kosletter.data.repository.StockRepository;
import com.koscom.kosletter.errors.code.EmailErrorCode;
import com.koscom.kosletter.errors.exception.ErrorException;
import com.koscom.kosletter.service.MailService;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class MailServiceImpl implements MailService {
    private final JavaMailSender mailSender;
    private final InterestRepository interestRepository;
    private final NewsRepository newsRepository;
    private final StockRepository stockRepository;

    private MimeMessage createMessage(SendEmailRequest request) throws MessagingException, UnsupportedEncodingException {
        log.info("[MailServiceImpl] createMessage");
        MimeMessage message = mailSender.createMimeMessage();

        message.addRecipients(RecipientType.TO, request.getEmail());
        message.setSubject("제목");
        String upUrl = "http://localhost:8080/api/mypage/up/" +
            request.getMemberId() + "/" + request.getStockCode();
        String downUrl = "http://localhost:8080/api/mypage/down/" +
            request.getMemberId() + "/" + request.getStockCode();
        String msgg = "";
        msgg+= "<div style='margin:20px;'>";
        msgg+= "<h1> 안녕하세요 ";
        msgg+= request.getName() + "님 ";
        msgg+= "Kosletter 입니다. </h1>";
        msgg+= "<br>";
        msgg+= "<center> ";
        msgg+= request.getTitle() + "<center>";
        msgg+= "<br>";
        msgg+= "<p>" + request.getContents() + "</p>";
        msgg+= "<p>감사합니다.<p>";
        msgg+= "<br>";
        msgg+= "<div align='center' style='border:1px solid black; font-family:verdana';>";
        msgg+= "<a href=" + upUrl + ">" + "<button> 오른다 </button>" + "</a>";
        msgg+= "<a href=" + downUrl + ">" + "<button> 내려간다 </button>" + "</a>";
        msgg+= "<div style='font-size:130%'>";
        msgg+= "</div>";
        message.setText(msgg, "utf-8", "html");//내용
        message.setFrom(new InternetAddress("kosletter@gmail.com","KOSLETTER"));//보내는 사람

        return message;
    }
    @Override
    public void sendMail() {
        log.info("[MailServiceImpl] sendMail");
        List<Interest> interests = interestRepository.findAll();
        List<SendEmailRequest> requests = new ArrayList<>();
        if(interests != null || !interests.isEmpty()) {
            for (var i:interests) {
                log.info("id {}", i.getStock());
                long stockId = i.getStock();
                Stock stock = stockRepository.getById(stockId);
                log.info("stock {}", stock.getCode());
                List<News> news = newsRepository.findByCode(stock.getCode());
                for (var n:news) {
                    SendEmailRequest emailRequest = SendEmailRequest.builder()
                        .memberId(i.getMember().getId())
                        .email(i.getMember().getEmail())
                        .name(i.getMember().getNickname())
                        .stockCode(stock.getCode())
                        .stockName(stock.getName())
                        .title(n.getTitle())
                        .contents(n.getContent())
                        .url(n.getLink())
                        .build();
                    requests.add(emailRequest);
                }
            }
        }

        if(!requests.isEmpty() || requests != null) {
            for (var r:requests) {
                try {
                    MimeMessage message = createMessage(r);
                    mailSender.send(message);
                    log.info("[sendEmail] 인증 메일 전송을 성공했습니다.");
                } catch(Exception e){
                    log.info("[sendEmail] 인증 메일 전송을 실패했습니다.");
                    throw new ErrorException(EmailErrorCode.EMAIL_FAILED);
                }
            }
        }
    }

    public void send() {
        sendMail();
    }
}
