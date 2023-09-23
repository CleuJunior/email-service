package br.com.cleonildo.application;

import br.com.cleonildo.adapters.EmailSenderGateway;
import br.com.cleonildo.core.EmailSenderUseCase;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService implements EmailSenderUseCase {
    private final EmailSenderGateway emailSenderGateway;

    public EmailSenderService(EmailSenderGateway emailSenderGateway) {
        this.emailSenderGateway = emailSenderGateway;
    }

    @Override
    public void sendEmail(String to, String subject, String body) {
        this.emailSenderGateway.sendEmail(to, subject, body);
    }
}
