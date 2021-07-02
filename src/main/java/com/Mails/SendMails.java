package com.Mails;

import com.Basepackage.Baseinit;
import org.testng.annotations.Test;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.IOException;
import java.util.Properties;

public class SendMails extends Baseinit {

    @Test
    public void sendMails() throws IOException, AddressException {
        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
//        properties.put("mail.smtp.host", "smtp.mailtrap.io");
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("akash.m.addweb@gmail.com", "addweb9519");
            }

        });
        try {
            // Create object of MimeMessage class
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("johnnyharpertesting@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse("johnnyharpertesting71@gmail.com")
            );

            message.setSubject("Testing Gmail Mail");
            message.setText("Dear User,"
                    + "\n\n This is a test email. Please do not reply");

            Transport.send(message);

            System.out.println("Done");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}