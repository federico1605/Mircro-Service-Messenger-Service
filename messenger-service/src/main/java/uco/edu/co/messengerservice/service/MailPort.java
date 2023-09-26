package uco.edu.co.messengerservice.service;

import java.io.IOException;

public interface MailPort {
    void sendMail(String message, String user, String title) throws IOException;
}
