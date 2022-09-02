package br.com.ucs.eln.user.generator;

import br.com.ucs.eln.group.model.Group;
import br.com.ucs.eln.user.exception.UserException;
import br.com.ucs.eln.user.model.User;
import br.com.ucs.eln.user.model.UserLock;
import br.com.ucs.eln.user.repository.UserRepository;
import br.com.ucs.eln.user.validator.UserRegistrationValidator;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class UserGenerator {

    public static final String UNDEFINED = "-";

    @Inject
    UserRepository repository;
    @Inject
    UserRegistrationValidator registrationValidator;

    public User generatePendingUser(String email, Group group) throws UserException {
        registrationValidator.validate(email);

        User user = new User();
        user.setEmail(email);
        user.setLock(UserLock.PENDING);
        user.setUsername(UNDEFINED);
        user.setPassword(UNDEFINED);
        user.setFullName(UNDEFINED);
        user.setGroup(group);

        repository.persist(user);
        return user;
    }

}
