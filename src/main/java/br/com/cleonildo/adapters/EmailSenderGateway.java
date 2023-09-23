package br.com.cleonildo.adapters;

public interface EmailSenderGateway {
    void sendEmail(String to, String subject, String body);
}
