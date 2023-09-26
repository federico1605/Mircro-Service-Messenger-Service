package uco.edu.co.messengerservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uco.edu.co.messengerservice.dto.EmailDTO;
import uco.edu.co.messengerservice.service.MailPort;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/email")
@Slf4j
public class MessageEmailController {
    @Autowired
    private MailPort mailPort;

    @PostMapping()
    public void sendEmail(@RequestBody EmailDTO emailDTO) {
        try {
            mailPort.sendMail(emailDTO.getMessage(), emailDTO.getUser(), emailDTO.getTitle());
        } catch (IOException exception) {
            log.error(exception.getMessage());
        }
    }
}
