package br.com.ucs.eln.user.business;

import io.quarkus.mailer.Mailer;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class UserRegistrationEmailSender {

    @Inject
    Mailer mailer;

    public void send(String destinationEmail) {
        //TODO gerar link único para finalizar cadastro
        //TODO implementar envio de email corretamente e sem mock (application.properties)
        //mailer.send(Mail.withText(destinationEmail, "-", "-"));
    }

}
