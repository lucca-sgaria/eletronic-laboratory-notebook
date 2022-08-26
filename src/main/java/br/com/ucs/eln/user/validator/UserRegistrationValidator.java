package br.com.ucs.eln.user.validator;

import br.com.ucs.eln.user.exception.UserException;
import br.com.ucs.eln.user.exception.UserExceptionKey;
import br.com.ucs.eln.user.repository.UserRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class UserRegistrationValidator {

    @Inject
    UserRepository userRepository;

    public void validate(String email) throws UserException {
        requireEmailIsNotRegistered(email);
    }

    private void requireEmailIsNotRegistered(String email) throws UserException {
        if(userRepository.existsByEmail(email)) {
            throw new UserException(UserExceptionKey.USER_EMAIL_ALREADY_REGISTERED);
        }
    }
}
