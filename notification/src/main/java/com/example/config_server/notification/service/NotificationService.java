package com.example.config_server.notification.service;

import com.example.config_server.notification.dto.NotificationData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class NotificationService {

    private static final String HOST = "localhost";
    private static final Logger log = LoggerFactory.getLogger(NotificationService.class);

    public void notify(NotificationData data) {
        final String to = data.getTo();
        final String from = data.getFrom();
        final String text = data.getMessage();
        final String subject = data.getSubject();

        assert (from != null && to != null &&
                text != null && subject != null);

        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", HOST);

        Session session = Session.getDefaultInstance(properties);

        log.info(
                String.format(
                        "Try to send message: to = %s, subject = %s , text = %s",
                        to, subject, text
                )
        );

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);
            message.setText(text);

            Transport.send(message);
            log.info(String.format("Message to %s is successfully sended!", to));
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
