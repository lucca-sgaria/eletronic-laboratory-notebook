package br.com.ucs.eln.user.validator;

import br.com.ucs.eln.user.repository.UserRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class UserRegistrationValidator {

    @Inject
    UserRepository userRepository;


}
