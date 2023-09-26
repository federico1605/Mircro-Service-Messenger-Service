package uco.edu.co.messengerservice.adapter;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import uco.edu.co.messengerservice.service.MailPort;

import java.io.IOException;

@Component
@Slf4j
public class MailSendGridAdapter implements MailPort {

    @Value("${spring.sendgrid.api-key}")
    private String key;
    @Value("${email}")
    private String senderMail;

    @Override
    public void sendMail(String message, String user, String title) throws IOException {
        Email sender = new Email(senderMail);
        Email receiver = new Email(user);
        Content content = new Content("text/plain", message);
        Mail mail = new Mail(sender, title, receiver, content);
        SendGrid sendGrid = new SendGrid(key);
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sendGrid.api(request);
            log.info(response.toString());
            log.info(response.getBody());
            log.info(String.valueOf(response.getStatusCode()));
            log.info(response.getHeaders().toString());
        } catch (IOException exception) {
            throw exception;
        }
    }
}
