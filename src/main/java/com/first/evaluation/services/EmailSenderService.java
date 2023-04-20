package com.first.evaluation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {
    @Autowired
    private JavaMailSender mailSender;

    public String senEmail(String toEmail,String subject,String body){
        try{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("");
            message.setTo(toEmail);
            message.setText(body);
            message.setSubject(subject);

            mailSender.send(message);
            return ("Un e-mail a été envoyé à :"+toEmail);
        }catch (Exception e) {
            return ("Une erreur s'est produite , veuillez Réessayer...");
        }
    }
}
