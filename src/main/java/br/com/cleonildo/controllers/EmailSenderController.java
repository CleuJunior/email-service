package br.com.cleonildo.controllers;

import br.com.cleonildo.application.EmailSenderService;
import br.com.cleonildo.core.EmailRequest;
import br.com.cleonildo.core.exceptions.EmailServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/email")
public class EmailSenderController {
    private final EmailSenderService emailSenderService;

    public EmailSenderController(EmailSenderService emailSenderService) {
        this.emailSenderService = emailSenderService;
    }

    @PostMapping
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest request) {
        try {
            this.emailSenderService.sendEmail(request.to(), request.subject(), request.body());
            return ResponseEntity.ok("Email sen successfully!");

        } catch(EmailServiceException exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error wile sending email");
        }
    }
}
