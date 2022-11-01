package br.com.ucs.eln.user.business;

import br.com.ucs.eln.user.exception.UserException;
import br.com.ucs.eln.user.model.User;
import br.com.ucs.eln.user.model.UserLock;
import br.com.ucs.eln.user.repository.UserRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class UserFinishRegistrationBusiness {

    @Inject
    UserRepository repository;


    public User finishRegistration(Long id,
                                   String fullName,
                                   String username,
                                   String password,
                                   String description) throws UserException {

        var user = repository.findExistingById(id);
        user.setFullName(fullName);
        user.setUsername(username);
        user.setPassword(password);
        user.setDescription(description);
        user.setLock(UserLock.UNLOCKED);

        return user;
    }
}
