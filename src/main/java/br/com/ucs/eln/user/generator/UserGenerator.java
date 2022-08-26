package br.com.ucs.eln.user.generator;

import br.com.ucs.eln.user.model.User;
import br.com.ucs.eln.user.model.UserLock;
import br.com.ucs.eln.user.repository.UserRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class UserGenerator {

    public static final String UNDEFINED = "-";

    @Inject
    UserRepository repository;

    public User generatePendingUser(String email) {
        User user = new User();
        user.setEmail(email);
        user.setLock(UserLock.PENDING);
        user.setUsername(UNDEFINED);
        user.setPassword(UNDEFINED);
        user.setFullName(UNDEFINED);

        repository.persist(user);
        return user;
    }

}
