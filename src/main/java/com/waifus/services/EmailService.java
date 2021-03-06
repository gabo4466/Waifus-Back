package com.waifus.services;

import java.util.Properties;
import java.util.Random;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailService {
    public static Properties prop;
    public static Properties prop2;

    public EmailService() {
        prop2 = PropertiesService.getProperties("hidden");
        prop = PropertiesService.getProperties("config_es");
    }

    public void sendMail(String html, String to, String subject) throws MessagingException{
        Properties properties = new Properties();

        properties.put("mail.smtp.host", "nebrijanos-com.correoseguro.dinaserver.com");
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(prop2.getProperty("email.account"), prop2.getProperty("email.pass"));
            }
        });
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(prop2.getProperty("email.account")));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
        message.setSubject(subject);
        message.setText(html, "UTF-8", "html");
        Transport.send(message);
    }

    public String generateOTP() throws MessagingException {
        String result = "";
        Random random = new Random();
        for (int i=0; i<6; i++){
            result += random.nextInt(9);
        }
        return result;
    }

    public String activationOTPHtml(String code, String user, String email) throws MessagingException {
        return "<div style='padding:0 450px; text-align:left;'><h2>Waifus</h2><p>Bienvenido "+user+" a Waifus,</p><p>"+prop.getProperty("email.actv.body")+"</p><h1 style='text-align:center;'>"+code+"</h1></div>";
    }

    public String activationOTPSubject(String  code) throws MessagingException {
        return code + " " + prop.getProperty("email.actv.subj");
    }
}
