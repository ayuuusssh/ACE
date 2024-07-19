package IESbank.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component

public class EMAIL_UTILS {
    @Autowired
    private JavaMailSender mailSender;
    public boolean sendEmail(String subject, String body, String to){

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setTo(body);
        message.setSubject(subject);
        message.setFrom("");

        mailSender.send(message);

        return true;
    }



}
