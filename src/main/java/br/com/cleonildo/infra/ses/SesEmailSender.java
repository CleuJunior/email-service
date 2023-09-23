package br.com.cleonildo.infra.ses;

import br.com.cleonildo.adapters.EmailSenderGateway;
import br.com.cleonildo.core.exceptions.EmailServiceException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.Message;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;

public class SesEmailSender implements EmailSenderGateway {
    private final AmazonSimpleEmailService amazonSimpleEmailService;

    public SesEmailSender(AmazonSimpleEmailService amazonSimpleEmailService) {
        this.amazonSimpleEmailService = amazonSimpleEmailService;
    }

    @Override
    public void sendEmail(String to, String subject, String body) {
        SendEmailRequest request = new SendEmailRequest()
                .withSource("cleu.junior@gmail.com")
                .withDestination(new Destination().withBccAddresses("cleu.junior@gmail.com"))
                .withMessage(new Message()
                        .withSubject(new Content(subject))
                        .withBody(new Body().withText(new Content(body))));

        try {
            this.amazonSimpleEmailService.sendEmail(request);

        } catch (AmazonServiceException exception) {
            throw new EmailServiceException("Failure while sending email", exception);
        }

    }
}
