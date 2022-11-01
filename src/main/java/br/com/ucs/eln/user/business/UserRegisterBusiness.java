package br.com.ucs.eln.user.business;

import br.com.ucs.eln.group.exception.GroupException;
import br.com.ucs.eln.group.model.Group;
import br.com.ucs.eln.group.repository.GroupRepository;
import br.com.ucs.eln.user.exception.UserException;
import br.com.ucs.eln.user.exception.UserExceptionKey;
import br.com.ucs.eln.user.model.User;
import br.com.ucs.eln.user.model.UserLock;
import br.com.ucs.eln.user.repository.UserRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class UserRegisterBusiness {

    @Inject
    UserRepository userRepository;
    @Inject
    GroupRepository groupRepository;

    public void registerUser(String email, Long groupId) throws UserException, GroupException {
        var group = groupRepository.findExistingById(groupId);
        generatePendingUser(email, group);
    }

    private void generatePendingUser(String email, Group group) throws UserException {
        validateEmail(email);

        var user = new User();
        user.setEmail(email);
        user.setLock(UserLock.PENDING);
        user.setUsername("-");
        user.setPassword("-");
        user.setFullName("-");
        user.setGroup(group);

        userRepository.persist(user);
    }

    private void validateEmail(String email) throws UserException {
        if(userRepository.existsByEmail(email)) {
            throw new UserException(UserExceptionKey.USER_EMAIL_ALREADY_REGISTERED);
        }
    }
}
