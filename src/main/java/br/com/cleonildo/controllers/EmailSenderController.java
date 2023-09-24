package br.com.cleonildo.controllers;

import br.com.cleonildo.application.EmailSenderService;
import br.com.cleonildo.core.EmailRequest;
import br.com.cleonildo.core.exceptions.EmailServiceException;
import br.com.cleonildo.dto.EmailResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
@RequestMapping("/api/v1/email")
public class EmailSenderController {
    private final EmailSenderService emailSenderService;

    public EmailSenderController(EmailSenderService emailSenderService) {
        this.emailSenderService = emailSenderService;
    }

    @PostMapping
    public ResponseEntity<EmailResponse> sendEmail(@RequestBody EmailRequest request) {
        try {
            this.emailSenderService.sendEmail(request.to(), request.subject(), request.body());
            return ResponseEntity.ok(new EmailResponse("Email sent successfully!", Instant.now()));

        } catch(EmailServiceException exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new EmailResponse("Error wile sending email", Instant.now()));
        }
    }
}
