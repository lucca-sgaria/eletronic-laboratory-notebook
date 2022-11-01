package br.com.ucs.eln.user.business;


import br.com.ucs.eln.user.exception.UserException;
import br.com.ucs.eln.user.exception.UserExceptionKey;
import br.com.ucs.eln.user.model.User;
import br.com.ucs.eln.user.model.UserLock;
import br.com.ucs.eln.user.repository.UserRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.Objects;

@RequestScoped
public class UserLoginBusiness {

    @Inject
    UserRepository repository;

    public User login(String email, String password) throws UserException {
        var user = repository.findByEmail(email);
        confirmCorrectPassword(user, password);
        confirmNotLocked(user);

        return user;
    }

    private void confirmCorrectPassword(User user, String password) throws UserException {
        if (!Objects.equals(user.getPassword(), password)) {
            throw new UserException(UserExceptionKey.INCORRECT_PASSWORD);
        }
    }

    private void confirmNotLocked(User user) throws UserException {
        if (Objects.equals(user.getLock(), UserLock.LOCKED)) {
            throw new UserException(UserExceptionKey.USER_IS_LOCKED);
        }
    }
}
