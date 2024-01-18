package com.homeDemo.demo.util;

import com.homeDemo.demo.question.QuestionVO;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

@Service
@Slf4j
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;


    //    public boolean sendMailReject() throws Exception{
//        boolean msg = false;
//        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
//
//        simpleMailMessage.setTo("dooboo_1@naver.com");
//        simpleMailMessage.setSubject("테스트용 메일");
//        simpleMailMessage.setFrom("ansgud963@gmail.com");
//        simpleMailMessage.setText("테스트용으로 보내는 즁 ~ ");
//        try {
//            javaMailSender.send(simpleMailMessage);
//        }
//        catch (Exception e){
//            e.printStackTrace();
//            return msg;
//        }
//        return msg= true;
//    }

    public void sendSimpleEmail(QuestionVO questionVO) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(questionVO.getEMAIL_ADDR());
        message.setFrom("isac@gmail.com");
        message.setSubject(questionVO.getSUBJECT());
        message.setText(questionVO.getMESSAGE());
        try {
            log.info("simpleMail SEND");

            javaMailSender.send(message);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public boolean sendMailMime(QuestionVO param) {
        boolean msg = false;
        MimeMessage message = javaMailSender.createMimeMessage();
        String email_contents = "";
        email_contents += "회사명 :" + param.getCOMPANY_NM() + "에서 <br/>";

        email_contents += param.getMESSAGE() + "라는 내용으로<br/>";
        email_contents += "접수 하셨습니다";
        email_contents += "※ 본 이메일은 발신 전용 입니다.";
        try {
            // 제목
            message.setSubject("이색광고 홈페이지 : 문의 접수   "+param.getSUBJECT());
            // 받는사람
            message.addRecipient(Message.RecipientType.TO,new InternetAddress("ansgud963@gmail.com","","UTF-8"));
            message.setText(email_contents,"UTF-8","html");
            javaMailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
            return msg;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return msg;
        }

        return msg = true;

    }

}
