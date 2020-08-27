package com.codeup.hilltopliquors.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service("mailService")
public class EmailService {

    //    Delivery person
    @Autowired
    public JavaMailSender emailSender;

    @Value("${spring.mail.from}")
    private String from;

    public void prepareAndSend(String recipient, String subject, String body) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom(from);
        msg.setTo(recipient);
        msg.setSubject(subject);
        msg.setText(body);

//

        try {
            this.emailSender.send(msg);
        } catch (MailException ex) {
            System.err.println(ex.getMessage());
        }

    }

}
