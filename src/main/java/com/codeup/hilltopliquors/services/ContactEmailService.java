package com.codeup.hilltopliquors.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service("contactMailService")
public class ContactEmailService {

    @Autowired
    public JavaMailSender contactEmailSender;


    @Value("${spring.mail.from}")
    private String to;

    public void prepareAndSend(String from, String subject, String body) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom(from);
        msg.setTo(to);
        msg.setSubject(subject);
        msg.setText(body);

//

        try {
            this.contactEmailSender.send(msg);
        } catch (MailException ex) {
            System.err.println(ex.getMessage());
        }

    }

}
